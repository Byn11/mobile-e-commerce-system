package com.test.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.test.dto.MenusDTO;
import com.test.dto.ProductColorsDTO;
import com.test.dto.ProductSizesDTO;
import com.test.dto.ProductsDTO;

/**
 * 用于定义对PRODUCTS表进行操作的方法
 * 
 * @author admin
 *
 */
public interface ProductsDAO {

	/**
	 * 查询PRODUCTS表中指定MENU_ID的前8条商品信息
	 * 
	 * @param conn
	 *            数据库连接对象
	 * @param dto
	 *            菜单信息
	 * @return 成功返回java.util.List类型，否则返回null
	 * @throws SQLException
	 */
	public abstract List<ProductsDTO> selectByMenu(Connection conn, MenusDTO dto)
			throws SQLException;

	/**
	 * 查询PRODUCTS表中指定编号的商品信息
	 * 
	 * @param conn
	 *            数据连接对象
	 * @param dto
	 *            查询商品编号
	 * @throws SQLException
	 */
	public abstract void selectByProductId(Connection conn, ProductsDTO dto)
			throws SQLException;

	/**
	 * 查询PRODUCT_COLORS表中指定商品编号的商品颜色信息
	 * 
	 * @param conn
	 *            数据库连接对象
	 * @param dto
	 *            查询商品编号
	 * @return 返回java.util.List类型
	 * @throws SQLException
	 */
	public abstract List<ProductColorsDTO> selectAllColorById(Connection conn,
			ProductsDTO dto) throws SQLException;

	/**
	 * 查询PRODUCT_SIZES表中指定商品编号的商品尺码信息
	 * 
	 * @param conn
	 *            数据库连接对象
	 * @param dto
	 *            查询商品编号
	 * @return 返回java.util.List类型
	 * @throws SQLException
	 */
	public abstract List<ProductSizesDTO> selectAllSizeById(Connection conn,
			ProductsDTO dto) throws SQLException;

	/**
	 * 查询PRODUCTS表中所有商品信息
	 * 
	 * @param conn
	 *            数据库连接对象
	 * @return 返回java.util.List类型
	 * @throws SQLException
	 */
	public abstract List<ProductsDTO> selectAll(Connection conn)
			throws SQLException;

	/**
	 * 向PRODUCTS表中添加一行新的商品信息
	 * 
	 * @param conn
	 *            数据库连接对象
	 * @param dto
	 *            新商品信息
	 * @return 添加成功返回true，否则返回false
	 * @throws SQLException
	 */
	public abstract boolean insert(Connection conn, ProductsDTO dto) throws SQLException;
	
	/**
	 * 获得商品序列products_seq的下一个值
	 * 
	 * @param conn
	 *            数据库连接对象
	 * @return 返回序列的下一个值
	 * @throws SQLException
	 */
	public abstract Integer selectNewId(Connection conn) throws SQLException;

	/**
	 * 查询PRODUCTS表中满足条件的商品信息(分页功能)
	 * 
	 * @param conn
	 *            数据库连接对象
	 * @param startRow
	 *            起始行
	 * @param endRow
	 *            终止行
	 * @param menuId
	 *            菜单编号
	 * @return 返回java.util.List类型
	 * @throws SQLException
	 */
	/**
	 * 查询PRODUCTS表中满足条件的商品信息(分页功能)
	 * 
	 * @param conn
	 *            数据库连接对象
	 * @param startRow
	 *            起始行
	 * @param endRow
	 *            终止行
	 * @param menuId
	 *            菜单编号
	 * @return 返回java.util.List类型
	 * @throws SQLException
	 */
	public abstract List<ProductsDTO> selectPage(Connection conn,
			Integer startRow, Integer endRow, Integer menuId,ProductsDTO dto,int [] brandId)
			throws SQLException;


	/**
	 * 获得商品表中最后一页的页数
	 * 
	 * @param conn
	 *            数据库连接对象
	 * @param pageRows
	 *            每页显示的行数
	 * @return 返回最后一页的页数
	 * @throws SQLException
	 */
	public abstract Integer getLastPage(Connection conn, Integer pageRows)
			throws SQLException;


	public abstract Double priceAlter(Connection conn,Integer productSizeId) throws SQLException;
	/**
	 * 获得商品表中最后一页的页数
	 * 
	 * @param conn
	 *            数据库连接对象
	 * @param pageRows
	 *            每页显示的行数
	 * @return 返回最后一页的页数
	 * @throws SQLException
	 */
	public abstract Integer getLastPage(Connection conn, Integer pageRows,ProductsDTO dto,Integer menuId,int [] brandId)
			throws SQLException;
	/**
	 * 判断商品是否存在
	 * @param conn 数据库连接对象
	 * @param dto 商品
	 * @return 若存在则返回productId，若不存在则返回-1
	 * @throws SQLException
	 */
	public abstract Integer isExists(Connection conn, ProductsDTO dto) throws SQLException;
	/**
	 * 修改PRODUCT表中指定编号的商品信息
	 * @param conn 数据库连接对象
	 * @param dto 商品信息
	 * @return 修改成功返回true，失败返回false
	 * @throws SQLException
	 */
	public abstract boolean update(Connection conn,ProductsDTO dto) throws SQLException;
}
