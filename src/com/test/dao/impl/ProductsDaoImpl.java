package com.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.dao.ProductsDAO;
import com.test.dto.BrandsDTO;
import com.test.dto.ColorsDTO;
import com.test.dto.MenusDTO;
import com.test.dto.ProductColorsDTO;
import com.test.dto.ProductSizesDTO;
import com.test.dto.ProductsDTO;
import com.test.dto.SizesDTO;

/**
 * 用于实现对PRODUCTS表进行操作的方法
 * 
 * @author admin
 *
 */
public class ProductsDaoImpl implements ProductsDAO {

	@Override
	public List<ProductsDTO> selectByMenu(Connection conn, MenusDTO dto)
			throws SQLException {
		String sql = "	SELECT * "
				+ "	FROM (SELECT ROW_NUMBER() OVER(ORDER BY PRODUCT_ID ASC) AS R,"
				+ "	       PRODUCT_ID,"
				+ "	       PRODUCT_NAME,"
				+ "	       PRODUCT_PRICE,"
				+ "	       PRODUCT_SMALL_IMAGE"
				+ "	      FROM PRODUCTS P JOIN BRANDS B ON P.BRAND_ID=B.BRAND_ID"
				+ "	      WHERE B.MENU_ID=?)" + "	WHERE R BETWEEN 1 AND 8";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, dto.getMenuId());
		ResultSet rs = ps.executeQuery();
		List<ProductsDTO> list = new ArrayList<>();
		ProductsDTO product = null;
		while (rs.next()) {
			product = new ProductsDTO();
			product.setProductId(rs.getInt("PRODUCT_ID"));
			product.setProductName(rs.getString("PRODUCT_NAME"));
			product.setProductPrice(rs.getDouble("PRODUCT_PRICE"));
			product.setProductSmallImage(rs.getString("PRODUCT_SMALL_IMAGE"));
			list.add(product);
		}
		return list;
	}

	@Override
	public void selectByProductId(Connection conn, ProductsDTO dto) throws SQLException {
		String sql = "	SELECT P.PRODUCT_ID,P.PRODUCT_NAME,"
				+"	P.PRODUCT_PRICE,P.PRODUCT_AVAILABILITY ,"
				+"	P.PRODUCT_BIG_IMAGE,P.PRODUCT_SMALL_IMAGE ,"
				+"	P.BRAND_ID,B.BRAND_NAME,P.PRODUCT_DESCRIPTION "
				+"	FROM PRODUCTS P JOIN BRANDS B "
				+"	ON P.BRAND_ID=B.BRAND_ID "
				+"	WHERE P.PRODUCT_ID=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, dto.getProductId());
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			//封装商品信息
			dto.setProductName(rs.getString("PRODUCT_NAME"));
			dto.setProductPrice(rs.getDouble("PRODUCT_PRICE"));
			dto.setProductAvailability(rs.getInt("PRODUCT_AVAILABILITY"));
			dto.setProductBigImage(rs.getString("PRODUCT_BIG_IMAGE"));
			dto.setProductSmallImage(rs.getString("PRODUCT_SMALL_IMAGE"));
			dto.setProductDescription(rs.getString("PRODUCT_DESCRIPTION"));
			//封装品牌信息
			BrandsDTO brand = new BrandsDTO();
			brand.setBrandId(rs.getInt("BRAND_ID"));
			brand.setBrandName(rs.getString("BRAND_NAME"));
			//设置商品的品牌信息
			dto.setBrands(brand);
		}		
	}

	@Override
	public List<ProductColorsDTO> selectAllColorById(Connection conn, ProductsDTO dto) throws SQLException {
		String sql = "	SELECT PC.PRODUCT_COLOR_ID,"
				+"			  PC.PRODUCT_ID,"
				+"			  PC.COLOR_ID,"
				+"			  C.COLOR_NAME"
				+"	FROM PRODUCT_COLORS PC JOIN COLORS C"
				+"	ON PC.COLOR_ID=C.COLOR_ID"
				+"	WHERE PC.PRODUCT_ID=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, dto.getProductId());
		ResultSet rs = ps.executeQuery();
		List<ProductColorsDTO> list = new ArrayList<>();
		ProductColorsDTO productColor = null;
		while(rs.next()){
			//设置商品颜色信息
			productColor = new ProductColorsDTO();
			productColor.setProductColorId(rs.getInt("PRODUCT_COLOR_ID"));
			productColor.setProductId(dto.getProductId());
			//设置颜色信息
			ColorsDTO color = new ColorsDTO();
			color.setColorId(rs.getInt("COLOR_ID"));
			color.setColorName(rs.getString("COLOR_NAME"));
			//将颜色信息添加到商品颜色中
			productColor.setColor(color);
			//将商品颜色信息添加到List集合中
			list.add(productColor);
		}
		//返回List集合
		return list;
	}

	@Override
	public List<ProductSizesDTO> selectAllSizeById(Connection conn, ProductsDTO dto) throws SQLException {
		String sql = "	SELECT PS.PRODUCT_SIZE_ID,"
				+"			  PS.PRODUCT_ID,"
				+"	       PS.SIZE_ID,"
				+"	       S.SIZE_NAME"
				+"	FROM PRODUCT_SIZES PS JOIN SIZES S"
				+"	ON PS.SIZE_ID=S.SIZE_ID"
				+"	WHERE PS.PRODUCT_ID=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, dto.getProductId());
		ResultSet rs = ps.executeQuery();
		List<ProductSizesDTO> list = new ArrayList<>();
		ProductSizesDTO productSizes = null;
		while(rs.next()){
			productSizes = new ProductSizesDTO();
			productSizes.setProductSizeId(rs.getInt("PRODUCT_SIZE_ID"));
			productSizes.setProductId(dto.getProductId());
			SizesDTO size = new SizesDTO();
			size.setSizeId(rs.getInt("SIZE_ID"));
			size.setSizeName(rs.getString("SIZE_NAME"));
			productSizes.setSize(size);
			list.add(productSizes);
		}
		return list;
	}

	@Override
	public List<ProductsDTO> selectAll(Connection conn) throws SQLException {
		String sql = "	SELECT P.PRODUCT_ID,P.PRODUCT_NAME,"
				+"	P.PRODUCT_PRICE,P.PRODUCT_AVAILABILITY ,"
				+"	P.PRODUCT_BIG_IMAGE,P.PRODUCT_SMALL_IMAGE ,"
				+"	P.BRAND_ID,B.BRAND_NAME,P.PRODUCT_DESCRIPTION "
				+"	FROM PRODUCTS P JOIN BRANDS B "
				+"	ON P.BRAND_ID=B.BRAND_ID ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<ProductsDTO> list = new ArrayList<ProductsDTO>();
		ProductsDTO dto = null;
		while(rs.next()){
			dto = new ProductsDTO();
			//封装商品信息
			dto.setProductId(rs.getInt("PRODUCT_ID"));
			dto.setProductName(rs.getString("PRODUCT_NAME"));
			dto.setProductPrice(rs.getDouble("PRODUCT_PRICE"));
			dto.setProductAvailability(rs.getInt("PRODUCT_AVAILABILITY"));
			dto.setProductBigImage(rs.getString("PRODUCT_BIG_IMAGE"));
			dto.setProductSmallImage(rs.getString("PRODUCT_SMALL_IMAGE"));
			dto.setProductDescription(rs.getString("PRODUCT_DESCRIPTION"));
			//封装品牌信息
			BrandsDTO brand = new BrandsDTO();
			brand.setBrandId(rs.getInt("BRAND_ID"));
			brand.setBrandName(rs.getString("BRAND_NAME"));
			//设置商品的品牌信息
			dto.setBrands(brand);
			list.add(dto);
		}
		return list;
	}
	@Override
	public boolean insert(Connection conn, ProductsDTO dto) throws SQLException {
		String sql = "insert into products values(?,?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		// 替换准备语句对象中的问号
		ps.setInt(1, dto.getProductId());
		ps.setString(2, dto.getProductName());
		ps.setDouble(3, dto.getProductPrice());
		ps.setInt(4, dto.getProductAvailability());
		ps.setString(5, dto.getProductBigImage());
		ps.setString(6, dto.getProductSmallImage());
		ps.setInt(7, dto.getBrands().getBrandId());
		ps.setString(8, dto.getProductDescription());
		// 使用准备语句对象执行INSERT语句
		int rows = ps.executeUpdate();
		if (rows > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Integer selectNewId(Connection conn) throws SQLException {
		String sql = "SELECT PRODUCTS_SEQ.NEXTVAL FROM DUAL";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return rs.getInt(1);
	}

	@Override
	public Double priceAlter(Connection conn, Integer productSizeId)
			throws SQLException {
		String sql="select product_price from product_sizes where product_size_id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, productSizeId);
		ResultSet rs=ps.executeQuery();
		rs.next();
		return rs.getDouble(1);
	}

	@Override
	public List<ProductsDTO> selectPage(Connection conn, Integer startRow,
			Integer endRow, Integer menuId,ProductsDTO product,int[] brandId) throws SQLException {
		StringBuilder sql = new StringBuilder(
				//开始拼接sql语句
				"	SELECT *"
						+ "	FROM (SELECT "
						+ "		ROW_NUMBER() OVER(ORDER BY P.PRODUCT_ID ASC) AS R,"
						+ "		P.PRODUCT_ID,"
						+ "		P.PRODUCT_NAME,"
						+ "		P.PRODUCT_BIG_IMAGE,"
						+ "		P.PRODUCT_SMALL_IMAGE,"
						+ "		P.PRODUCT_PRICE,"
						+ "		P.PRODUCT_DESCRIPTION,"
						+ "		B.BRAND_ID,"
						+ "		B.BRAND_NAME,"
						+ "		P.PRODUCT_AVAILABILITY "
						+ "	      FROM PRODUCTS P JOIN BRANDS B ON P.BRAND_ID=B.BRAND_ID"
						+ "	      WHERE 1=1 ");
		//如果菜单编号不为空，向select语句中添加菜单的查询条件
		if(menuId != null){
			sql.append(" AND B.MENU_ID=?");
		}
		//如果商品名称不为空，向select语句中添加商品名称的查询条件
		if(product!=null && (product.getProductName()!=null && !product.getProductName().equals(""))){
			sql.append(" AND P.PRODUCT_NAME LIKE ?");
		}
		//如果品牌编号不为空，向select语句中添加品牌编号的查询条件
		if(brandId!=null&&brandId.length>0){
			for(int i=0;i<brandId.length;i++){
				if(i==0){
					sql.append(" AND (B.BRAND_ID=?");
				}else{
					sql.append("OR B.BRAND_ID=?");
				}
			}
			sql.append(") ");
		}
		sql.append("	)WHERE R BETWEEN ? AND ?");
		//拼接select语句结束
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		int count = 1;
		//替换菜单编号的问号
		if(menuId != null){
			ps.setInt(count++, menuId);			
		}
		//替换商品名称的问号
		if(product!=null && !"".equals(product.getProductName())){
			ps.setString(count++, "%"+product.getProductName()+"%");
			System.out.println(sql);
			System.out.println(count+"%"+product.getProductName()+"%");
		}
		//替换品牌编号的问号
		if(brandId!=null&&brandId.length>0){
			for(int i=0;i<brandId.length;i++){
				ps.setInt(count++, brandId[i]);
			}
		}
		ps.setInt(count++, startRow);
		ps.setInt(count++, endRow);
		ResultSet rs = ps.executeQuery();
		List<ProductsDTO> list = new ArrayList<ProductsDTO>();
		ProductsDTO dto = null;
		while (rs.next()) {
			dto = new ProductsDTO();
			// 封装商品信息
			dto.setProductId(rs.getInt("PRODUCT_ID"));
			dto.setProductName(rs.getString("PRODUCT_NAME"));
			dto.setProductPrice(rs.getDouble("PRODUCT_PRICE"));
			dto.setProductBigImage(rs.getString("PRODUCT_BIG_IMAGE"));
			dto.setProductSmallImage(rs.getString("PRODUCT_SMALL_IMAGE"));
			dto.setProductDescription(rs.getString("PRODUCT_DESCRIPTION"));
			dto.setProductAvailability(rs.getInt("PRODUCT_AVAILABILITY"));
			// 封装品牌信息
			BrandsDTO brand = new BrandsDTO();
			brand.setBrandId(rs.getInt("BRAND_ID"));
			brand.setBrandName(rs.getString("BRAND_NAME"));
			// 设置商品的品牌信息
			dto.setBrands(brand);
			list.add(dto);
		}
		return list;
	}
	@Override
	public Integer getLastPage(Connection conn, Integer pageRows)
			throws SQLException {
		
		return null;
}
	public Integer getLastPage(Connection conn, Integer pageRows,ProductsDTO product,Integer menuId,int[] brandId)
			throws SQLException {
		StringBuilder sql = new StringBuilder("SELECT CEIL(COUNT(*) / ?) FROM PRODUCTS P JOIN BRANDS B ON P.BRAND_ID=B.BRAND_ID where 1=1");
		if(menuId != null){
			sql.append(" AND B.MENU_ID=?");
		}
		if(product!=null && (product.getProductName()!=null && !product.getProductName().equals(""))){
			sql.append(" AND P.PRODUCT_NAME LIKE ?");
		}
		//如果商品名称不为空，向select语句中添加商品名称的查询条件
				//如果品牌编号不为空，向select语句中添加品牌编号的查询条件
		if(brandId!=null&&brandId.length>0){
			for(int i=0;i<brandId.length;i++){
				if(i==0){
						sql.append(" AND (B.BRAND_ID=?");
					}else{
						sql.append("OR B.BRAND_ID=?");
					}
				}
				sql.append(")");
				}
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		int count = 1;
		ps.setInt(count++, pageRows);
		
		if(menuId != null){
			ps.setInt(count++, menuId);			
		}
		if(product!=null && !"".equals(product.getProductName())){
			ps.setString(count++, "%"+product.getProductName()+"%");
		}
		if(brandId!=null&&brandId.length>0){
			for(int i=0;i<brandId.length;i++){
				ps.setInt(count++, brandId[i]);
			}
		}
		ResultSet rs = ps.executeQuery();
		rs.next();
		return rs.getInt(1);
	}

	@Override
	public Integer isExists(Connection conn, ProductsDTO dto)
			throws SQLException {
		String sql = "SELECT Product_id AS C FROM products WHERE product_name =?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, dto.getProductName());
		ResultSet rs = ps.executeQuery();

		if(rs.next()){
			return rs.getInt("C");
		}		
		return -1;
	}

	@Override
	public boolean update(Connection conn, ProductsDTO dto) throws SQLException {
		int count=1;
		String sql="update products set product_name=?,product_price=?,brand_id=?,product_description=? where product_id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(count++, dto.getProductName());
		ps.setDouble(count++, dto.getProductPrice());
		ps.setInt(count++, dto.getBrands().getBrandId());
		ps.setString(count++, dto.getProductDescription());
		ps.setInt(5, dto.getProductId());
		int rows=ps.executeUpdate();
		if(rows>0){
			return true;
		}
		return false;
	}

}
