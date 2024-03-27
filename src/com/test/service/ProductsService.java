package com.test.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.test.common.DbUtils;
import com.test.dao.ProductColorsDAO;
import com.test.dao.ProductSizesDAO;
import com.test.dao.ProductsDAO;
import com.test.dao.impl.ProductColorsDaoImpl;
import com.test.dao.impl.ProductSizesDaoImpl;
import com.test.dao.impl.ProductsDaoImpl;
import com.test.dto.MenusDTO;
import com.test.dto.ProductColorsDTO;
import com.test.dto.ProductSizesDTO;
import com.test.dto.ProductsDTO;

/**
 * 商品的模型层(业务逻辑层)
 * 
 * @author admin
 *
 */
public class ProductsService {

	// 商品持久化层的对象
	private ProductsDAO productsDAO;
	// 商品尺码持久化层对象
	private ProductSizesDAO productSizesDAO;
	// 商品颜色持久化层对象
	private ProductColorsDAO productColorsDAO;
	public ProductsService() {
		this.productsDAO = new ProductsDaoImpl();
		this.productColorsDAO=new ProductColorsDaoImpl();
		this.productSizesDAO = new ProductSizesDaoImpl();
	}

	/**
	 * 获得指定菜单所有的商品
	 * 
	 * @param dto
	 *            菜单信息
	 * @return 返回java.util.List类型
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<ProductsDTO> selectByMenu(MenusDTO dto)
			throws ClassNotFoundException, SQLException {
		Connection conn = DbUtils.getConnection();
		try {
			return this.productsDAO.selectByMenu(conn, dto);
		} finally {
			conn.close();
		}
	}

	/**
	 * 查询指定商品编号的商品信息
	 * 
	 * @param dto
	 *            商品编号
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void selectByProductId(ProductsDTO dto)
			throws ClassNotFoundException, SQLException {
		Connection conn = DbUtils.getConnection();
		try {
			this.productsDAO.selectByProductId(conn, dto);
		} finally {
			conn.close();
		}
	}

	/**
	 * 查询指定商品所有的商品颜色信息
	 * 
	 * @param dto
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<ProductColorsDTO> selectAllColorById(ProductsDTO dto)
			throws ClassNotFoundException, SQLException {
		Connection conn = DbUtils.getConnection();
		try {
			return this.productsDAO.selectAllColorById(conn, dto);
		} finally {
			conn.close();
		}
	}

	/**
	 * 查询指定商品所有商品尺码信息
	 * 
	 * @param dto
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<ProductSizesDTO> selectAllSizeById(ProductsDTO dto)
			throws ClassNotFoundException, SQLException {
		Connection conn = DbUtils.getConnection();
		try {
			return this.productsDAO.selectAllSizeById(conn, dto);
		} finally {
			conn.close();
		}
	}

	/**
	 * 查询所有的商品的信息
	 * 
	 * @return 返回java.util.List类型
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<ProductsDTO> selectAll() throws ClassNotFoundException,
			SQLException {
		Connection conn = DbUtils.getConnection();
		try {
			return this.productsDAO.selectAll(conn);
		} finally {
			conn.close();
		}
	}
	/**
	 * 添加新商品信息，同时添加新商品的商品颜色与商品尺码信息
	 * 
	 * @param product
	 *            新商品信息
	 * @param productSizeList
	 *            商品尺码信息
	 * @param productColorList
	 *            商品颜色信息
	 * @return 添加成功返回ture,否则返回false
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean insert(ProductsDTO product, Integer size, Integer[] colorArray)
			throws ClassNotFoundException, SQLException {
		Connection conn = DbUtils.getConnection();
		try {
			// 获得最新的商品编号
			Integer productId = this.productsDAO.selectNewId(conn);
			// 将最新的商品编号存入商品信息中
			product.setProductId(productId);
			// 向商品表中添加数据
			boolean insert = this.productsDAO.insert(conn, product);
			if (insert) {
				// 如果商品信息添加成功，再向商品尺码表中添加信息
				for (Integer colorId : colorArray) {
					insert = this.productColorsDAO.insert(conn, product.getProductId(), colorId);
					if (!insert) {
						// 如果某次商品尺码信息添加失败，则退出循环
						break;
					}
				}
				if (insert) {
					// 如果商品尺码信息添加成功，则向商品颜色表中添加信息
						insert = this.productSizesDAO.insert(conn, product.getProductId(), size,product.getProductPrice());
					}
					if (insert) {
						// 如果所有添加都成功，提交事务，结束方法
						conn.commit();
						return true;
					}
				}
			
			// 添加失败，回退事务
			conn.rollback();
		} finally {
			conn.close();
		}
		return false;
	}

	public Double priceAlter(Integer productSizeId) throws Exception {
		Connection conn = DbUtils.getConnection();
		
		try{
			return productsDAO.priceAlter(conn, productSizeId);
		}finally{
			conn.close();
		}
		
	}
	
	public List<ProductsDTO> selectPage(Integer menuId, Integer pageRows, Integer pageNumber,ProductsDTO dto,int [] brandId)
			throws ClassNotFoundException, SQLException {
		// 计算起始行与终止行
		Integer endRow = pageRows * pageNumber;
		Integer startRow = endRow - pageRows + 1;
		Connection conn = DbUtils.getConnection();
		try {
			return this.productsDAO.selectPage(conn, startRow, endRow, menuId,dto,brandId);
		} finally {
			conn.close();
		}
	}
	/**
	 * 查询满足条件商品信息分页数据的最后一页的页码
	 * 
	 * @param pageRows
	 *            每页显示数据的行数
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public Integer getLastPage(Integer pageRows,ProductsDTO dto,Integer menuId,int [] brandId) throws ClassNotFoundException, SQLException {
		Connection conn = DbUtils.getConnection();
		try {
			return this.productsDAO.getLastPage(conn, pageRows,dto,menuId,brandId);
		} finally {
			conn.close();
		}
	
	}
	/**
	 * 判断商品名是否存在
	 * @param dto
	 * @return 如果存在返回true，不存在返回false
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public Integer isExists(ProductsDTO dto) throws SQLException, ClassNotFoundException{
		Connection conn=DbUtils.getConnection();
		try{
			return this.productsDAO.isExists(conn, dto);
		}finally{
			conn.close();
		}

			
	}
	public boolean insert2(ProductsDTO product, Integer size, Integer[] colorArray)
			throws ClassNotFoundException, SQLException {
		Connection conn = DbUtils.getConnection();
		try {
				boolean insert=false;
				for (Integer colorId : colorArray) {
					insert = this.productColorsDAO.insert(conn, product.getProductId(), colorId);
					if (!insert) {
						// 如果某次商品颜色信息添加失败，则退出循环
						break;
					}
				}
				if (insert) {
					// 如果商品颜色信息添加成功，则向商品尺码表中添加信息
						insert = this.productSizesDAO.insert(conn, product.getProductId(), size,product.getProductPrice());
					}
					if (insert) {
						// 如果所有添加都成功，提交事务，结束方法
						conn.commit();
						return true;
					}
				
			
			// 添加失败，回退事务
			conn.rollback();
		} finally {
			conn.close();
		}
		return false;
	}
	/**
	 * 修改商品信息
	 * @param dto 商品信息
	 * @return 修改成功返回true,否则返回false
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public boolean update(ProductsDTO dto) throws ClassNotFoundException, SQLException{
		Connection conn=DbUtils.getConnection();
		try{
			boolean update=this.productsDAO.update(conn, dto);
			if(update){
				conn.commit();
				return true;
			}
		}finally{
			conn.close();
		}
		return false;
	}
}


