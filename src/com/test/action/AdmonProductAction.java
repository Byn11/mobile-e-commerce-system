package com.test.action;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.test.common.FileUtil;
import com.test.dto.BrandsDTO;
import com.test.dto.ColorsDTO;
import com.test.dto.ProductColorsDTO;
import com.test.dto.ProductSizesDTO;
import com.test.dto.ProductsDTO;
import com.test.dto.SizesDTO;
import com.test.service.BrandsService;
import com.test.service.ColorsService;
import com.test.service.ProductsService;
import com.test.service.SizesService;

public class AdmonProductAction extends ActionSupport {

	private static final long serialVersionUID = 3021208294281430519L;
	// 用于保存所有的品牌信息
	private List<BrandsDTO> brandsList;
	// 用于保存商品信息
	private ProductsDTO productsDTO;
	// 用于保存颜色信息
	private List<ColorsDTO> colorList;
	// 用于保存尺码信息
	private List<SizesDTO> sizeList;
	// 用于保存商品尺码编号
	private Integer size;
	// 用于保存商品颜色编号
	private Integer[] colorArray;
	// 用于保存大图片
	private File productBigImage;
	// 因为struts2会将上传文件变为.tmp文件，所以需要声明一个名为xxxFileName的变量保存上传文件的文件名
	private String productBigImageFileName;
	// 保存大图片上传文件类型
	private String productBigImageContentType;
	// 用于保存小图片
	private File productSmallImage;
	// 因为struts2会将上传文件变为.tmp文件，所以需要声明一个名为xxxFileName的变量保存上传文件的文件名
	private String productSmallImageFileName;
	// 保存大图片上传文件类型
	private String productSmallImageContentType;
	// 用于保存商品的品牌编号
	private Integer brandId;
	// 用于保存商品颜色信息
	private List<ProductColorsDTO> productColorList;
	// 用于保存商品尺码信息
	private List<ProductSizesDTO> productSizeList;
	//设置返回的URL
	private String result;
	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public File getProductBigImage() {
		return productBigImage;
	}

	public void setProductBigImage(File productBigImage) {
		this.productBigImage = productBigImage;
	}

	public String getProductBigImageFileName() {
		return productBigImageFileName;
	}

	public void setProductBigImageFileName(String productBigImageFileName) {
		this.productBigImageFileName = productBigImageFileName;
	}

	public String getProductBigImageContentType() {
		return productBigImageContentType;
	}

	public void setProductBigImageContentType(String productBigImageContentType) {
		this.productBigImageContentType = productBigImageContentType;
	}

	public File getProductSmallImage() {
		return productSmallImage;
	}

	public void setProductSmallImage(File productSmallImage) {
		this.productSmallImage = productSmallImage;
	}

	public String getProductSmallImageFileName() {
		return productSmallImageFileName;
	}

	public void setProductSmallImageFileName(String productSmallImageFileName) {
		this.productSmallImageFileName = productSmallImageFileName;
	}

	public String getProductSmallImageContentType() {
		return productSmallImageContentType;
	}

	public void setProductSmallImageContentType(String productSmallImageContentType) {
		this.productSmallImageContentType = productSmallImageContentType;
	}



	public List<ColorsDTO> getColorList() {
		return colorList;
	}

	public void setColorList(List<ColorsDTO> colorList) {
		this.colorList = colorList;
	}

	public List<SizesDTO> getSizeList() {
		return sizeList;
	}

	public void setSizeList(List<SizesDTO> sizeList) {
		this.sizeList = sizeList;
	}

	public ProductsDTO getProductsDTO() {
		return productsDTO;
	}

	public void setProductsDTO(ProductsDTO productsDTO) {
		this.productsDTO = productsDTO;
	}

	public List<BrandsDTO> getBrandsList() {
		return brandsList;
	}

	public void setBrandsList(List<BrandsDTO> brandsList) {
		this.brandsList = brandsList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 跳转到管理员-商品添加页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String productInsertForm() throws Exception {
		try {
			// 获得所有品牌信息
			BrandsService brandsService = new BrandsService();
			this.brandsList = brandsService.selectAll();
			// 获得所有颜色信息
			ColorsService colorsService = new ColorsService();
			this.colorList = colorsService.selectAll();
			// 获得所有尺码 信息
			SizesService sizesService = new SizesService();
			this.sizeList = sizesService.selectAll();

			return "product_add";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

	/**
	 * 添加新商品
	 * 
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		try {
			// 获得上传文件路径
			String filePath = ServletActionContext.getServletContext().getRealPath("images");
			System.out.println(filePath);
			// 获得上传文件的扩展名
			String extension1 = this.productBigImageFileName.substring(this.productBigImageFileName.indexOf(".") + 1);
			String extension2 = this.productSmallImageFileName
					.substring(this.productSmallImageFileName.indexOf(".") + 1);
			// 获得上传文件保存在服务器中的文件名
			String fileName = FileUtil.createFileName();
			System.out.println(filePath + "\\" + fileName + "." + extension1);
			System.out.println(filePath + "\\" + fileName + "." + extension2);

			// 设置新商品为有货状态
			this.productsDTO.setProductAvailability(1);
			// 设置商商品的大图片名与小图片名,大连图片以b开头，小图片以s开头
			this.productsDTO.setProductBigImage("images/b" + fileName + "." + extension1);
			this.productsDTO.setProductSmallImage("images/s" + fileName + "." + extension1);
			
			//设置商品的品牌信息
			BrandsDTO brandsDTO = new BrandsDTO();
			brandsDTO.setBrandId(brandId);
			this.productsDTO.setBrands(brandsDTO);

			// 添加商品信息
			ProductsService productsService = new ProductsService();
			Integer exists = productsService.isExists(productsDTO);
			//如果信息不存在
			boolean insert=false;
			if(exists==-1){
				insert = productsService.insert(productsDTO, size, colorArray);
			}else{
				productsDTO.setProductId(exists);
				insert = productsService.insert2(productsDTO, size, colorArray);
			}
				if (insert) {
					// 如果商品信息添加成功，则上传图片
					FileUtil.uploadFile(this.productBigImage, filePath + "/b" + fileName + "." + extension1);
					FileUtil.uploadFile(this.productSmallImage, filePath + "/s" + fileName + "." + extension1);
					HttpSession session=ServletActionContext.getRequest().getSession();
					session.setAttribute("product_add_success", "<script>alert('商品添加成功!!')</script>");
					return "product_insert_ok";
				}
			


		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

	public void validateInsert() {
		if (this.productBigImage != null) {
			// 检查图片格式是否正确
			boolean image = false;
			switch (this.productBigImageContentType) {
			case "image/bmp":
			case "image/png":
			case "image/gif":
			case "image/jpeg":
				image = true;
			}

			if (!image) {
				this.addActionError("<script>alert('商品大图片格式不正确！！！');</script>");
			}
		}
		if (this.productSmallImage != null) {
			// 检查图片格式是否正确
			boolean image = false;
			switch (this.productSmallImageContentType) {
			case "image/bmp":
			case "image/png":
			case "image/gif":
			case "image/jpeg":
				image = true;
			}

			if (!image) {
				this.addActionError("<script>alert('商品小图片格式不正确！！！');</script>");
			}
		}
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer[] getColorArray() {
		return colorArray;
	}

	public void setColorArray(Integer[] colorArray) {
		this.colorArray = colorArray;
	}
	/**
	 * 根据商品编号查询商品信息
	 * @return
	 * @throws Exception
	 */
	public String selectById() throws Exception{
		try{
			ProductsService productsService=new ProductsService();
			productsService.selectByProductId(productsDTO);
			//获得所有品牌信息
			BrandsService brandsService = new BrandsService();
			this.brandsList = brandsService.selectAll();
			// 获得所有颜色信息
			ColorsService colorsService = new ColorsService();
			this.colorList = colorsService.selectAll();
			// 获得所有尺码 信息
			SizesService sizesService = new SizesService();
			this.sizeList = sizesService.selectAll();
			// 获得商品颜色信息
			this.setProductColorList(productsService.selectAllColorById(productsDTO));
			// 获得商品尺码信息
			this.setProductSizeList(productsService.selectAllSizeById(productsDTO));
			return "product_update";
		}catch(Exception e){
			e.printStackTrace();
		}
		return ERROR;
	}

	public List<ProductColorsDTO> getProductColorList() {
		return productColorList;
	}

	public void setProductColorList(List<ProductColorsDTO> productColorList) {
		this.productColorList = productColorList;
	}

	public List<ProductSizesDTO> getProductSizeList() {
		return productSizeList;
	}

	public void setProductSizeList(List<ProductSizesDTO> productSizeList) {
		this.productSizeList = productSizeList;
	}
	public String update() throws Exception{
		try{
			ProductsService productsService=new ProductsService();
			boolean b=productsService.update(productsDTO);
			HttpSession session=ServletActionContext.getRequest().getSession(true);
			if(b){
				session.setAttribute("update_msg", "<script>alert('商品基本信息修改成功！！！')</script>");
			}else{
				session.setAttribute("update_msg", "<script>alert('商品基本信息修改失败！！')</script>");
			}
			this.setResult("AdminProduct!selectById?productsDTO.productId="+this.productsDTO.getProductId());
			return super.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
		return "error";
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
