package com.test.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.test.common.PageUtil;
import com.test.dto.BrandsDTO;
import com.test.dto.MenusDTO;
import com.test.dto.OrderDetailsDTO;
import com.test.dto.ProductColorsDTO;
import com.test.dto.ProductSizesDTO;
import com.test.dto.ProductsDTO;
import com.test.service.BrandsService;
import com.test.service.ProductsService;

public class ProductAction extends ActionSupport {

	private static final long serialVersionUID = -5892154708638285935L;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	// 用于保存女装的商品信息
	private List<ProductsDTO> androidList;
	// 用于保存男装的商品信息
	private List<ProductsDTO> appleList;
	// 用于保存商品的信息
	private ProductsDTO product;
	// 用于保存商品颜色信息
	private List<ProductColorsDTO> productColorList;
	// 用于保存商品尺码信息
	private List<ProductSizesDTO> productSizeList;
	// 保存订单明细信息
	private OrderDetailsDTO orderDetailsDTO;
	// 保存结果的名字
	private String result;
	// 用于保存所有商品信息
	private List<ProductsDTO> productList;

	// 商品尺码编号
	private Integer productSizeId;
	// 用于保存显示的页码
		private int pageNumber;
		// 用于保存最后一页的页码
		private int[] lastPage;
		// 用于保存菜单编号
		private Integer menuId;
		// 用户保存当前功能是否为管理员模块 1为管理员，0为普通用户
		private int isAdmin;
		//用于保存品牌信息
		private List<BrandsDTO> brandList;
		//用于保存品牌编号信息
		private int [] brandIdArray;
	public int getPageNumber() {
			return pageNumber;
		}

		public void setPageNumber(int pageNumber) {
			this.pageNumber = pageNumber;
		}

		public int[] getLastPage() {
			return lastPage;
		}

		public void setLastPage(int[] lastPage) {
			this.lastPage = lastPage;
		}

		public Integer getMenuId() {
			return menuId;
		}

		public void setMenuId(Integer menuId) {
			this.menuId = menuId;
		}

		public int getIsAdmin() {
			return isAdmin;
		}

		public void setIsAdmin(int isAdmin) {
			this.isAdmin = isAdmin;
		}

	/**
	 * 向购物车中添加商品信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String addToCart() throws Exception {
		try {
			// 获得当前用户的Session
			HttpSession session = ServletActionContext.getRequest().getSession(
					true);
			// 从Session中添加当前用户的购物车
			@SuppressWarnings("unchecked")
			List<OrderDetailsDTO> carList = (List<OrderDetailsDTO>) session
					.getAttribute("carList");
			if (carList == null) {
				// 当前用户在本次登录为第一次购物
				carList = new ArrayList<OrderDetailsDTO>();
			}
			// 在购物车中判断是否存在同样颜色同样尺码的同一商品编号的商品
			// 在List集合中获得指定的订单明细信息首次出现的位置，没找到返回-1
			int index = carList.indexOf(orderDetailsDTO);
			if (index == -1) {
				// 设置商品数量为1
				orderDetailsDTO.setProductQty(1);
				// 在购物车中没有此订单明细信息,将订单信息添加到购物车中
				carList.add(orderDetailsDTO);
			} else {
				// 在购物车中找到了订单明细信息
				// 获得购物车中指定位置的订单明细信息
				this.orderDetailsDTO = carList.get(index);
				// 获得当前订单明细的数量
				int qty = this.orderDetailsDTO.getProductQty();
				// 重新设置当前订单明细的数量
				this.orderDetailsDTO.setProductQty(qty + 1);
				// 将订单明细信息重新放加到购物车中
				carList.set(index, orderDetailsDTO);
			}
			// 将购物车重新放入到Session中
			session.setAttribute("carList", carList);
			session.setAttribute("addCartSuccess",
					"<script>alert('添加成功！！！');</script>");
			this.result = "Product!selectById?product.productId="
					+ this.orderDetailsDTO.getProductId();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

	/**
	 * 删除购物车中的数据
	 * 
	 * @return
	 * @throws Exception
	 */
	public String delCartItem() throws Exception {
		try {
			HttpSession session = ServletActionContext.getRequest().getSession(
					true);
			@SuppressWarnings("unchecked")
			List<OrderDetailsDTO> carList = (List<OrderDetailsDTO>) session.getAttribute("carList");
			//在购物车中查找将要移除商品的位置
			int i=carList.indexOf(this.orderDetailsDTO);
			//移除购物车中指定位置的商品信息
			carList.remove(i);
			//判断购物车的长度
			if(carList.size()==0){
				session.removeAttribute("carList");
			}else{
				session.setAttribute("carList", carList);
			}
			return "deleteOk";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}



	public OrderDetailsDTO getOrderDetailsDTO() {
		return orderDetailsDTO;
	}

	public ProductsDTO getProduct() {
		return product;
	}

	public List<ProductColorsDTO> getProductColorList() {
		return productColorList;
	}

	public List<ProductsDTO> getProductList() {
		return productList;
	}

	public Integer getProductSizeId() {
		return productSizeId;
	}

	public List<ProductSizesDTO> getProductSizeList() {
		return productSizeList;
	}

	public String getResult() {
		return result;
	}



	public String priceAlter() throws Exception {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();

			// System.out.println(product.getProductId());
			System.out.println(request.getParameter("aa"));
			this.productSizeId = Integer.valueOf(request.getParameter("aa"));
			request.setAttribute("productSizeId", this.productSizeId);
			ProductsService productService = new ProductsService();
			// 获得商品信息:方法形参是引用数据类型，形参改变，实参也会发生改变。
			productService.selectByProductId(product);
			product.setProductPrice(productService.priceAlter(productSizeId));
			// 获得商品颜色信息
			this.productColorList = productService.selectAllColorById(product);
			// 获得商品尺码信息
			this.productSizeList = productService.selectAllSizeById(product);
			
			return "product";
			// 跳转到product.jsp页面
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

	/**
	 * 主页面初始化方法
	 * 
	 * @return
	 * @throws Exception
	 */
	public String ready() throws Exception {
		try {
			// 首先获得安卓前8条商品信息
			ProductsService productsSerivce = new ProductsService();
			MenusDTO menusDTO = new MenusDTO();
			menusDTO.setMenuId(1);
			this.androidList = productsSerivce.selectByMenu(menusDTO);
			// 然后获得苹果前8条商品信息
			menusDTO.setMenuId(2);
			this.appleList = productsSerivce.selectByMenu(menusDTO);
			return "index";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

	/**
	 * 获得指定商品的商品信息，商品颜色信息，商品尺码信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String selectById() throws Exception {
		try {
			ProductsService productService = new ProductsService();
			// 获得商品信息:方法形参是引用数据类型，形参改变，实参也会发生改变。
			productService.selectByProductId(product);
			// 获得商品颜色信息
			this.productColorList = productService.selectAllColorById(product);
			// 获得商品尺码信息
			this.productSizeList = productService.selectAllSizeById(product);
			// 跳转到product.jsp页面
			return "product";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

	public void setOrderDetailsDTO(OrderDetailsDTO orderDetailsDTO) {
		this.orderDetailsDTO = orderDetailsDTO;
	}

	public void setProduct(ProductsDTO product) {
		this.product = product;
	}

	public void setProductColorList(List<ProductColorsDTO> productColorList) {
		this.productColorList = productColorList;
	}

	public void setProductList(List<ProductsDTO> productList) {
		this.productList = productList;
	}

	public void setProductSizeId(Integer productSizeId) {
		this.productSizeId = productSizeId;
	}

	public void setProductSizeList(List<ProductSizesDTO> productSizeList) {
		this.productSizeList = productSizeList;
	}

	public void setResult(String result) {
		this.result = result;
	}



	/**
	 * 显示购物车信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String showCart() throws Exception {
		try {
			// 获得所有商品信息
			ProductsService productsService = new ProductsService();
			this.productList = productsService.selectAll();
			MenusDTO menusDTO=new MenusDTO();
			menusDTO.setMenuId(2);
			this.appleList = productsService.selectByMenu(menusDTO);


			return "cart";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}
	/**
	 * 查询满足条件的商品信息(分页功能)
	 * 
	 * @return
	 * @throws Exception
	 */
	public String selectPage() throws Exception {
		try {
			// 获得每页显示数据的行数
			Integer pageRows = PageUtil.PAGE_ROWS;
			// 如果没有获得当前页数，则设置当前页数为1
			if (this.pageNumber == 0) {
				this.pageNumber = 1;
			}

			ProductsService productsService = new ProductsService();
			this.productList = productsService.selectPage(menuId, pageRows, pageNumber, this.product,this.brandIdArray);

			int last = productsService.getLastPage(pageRows, this.product, menuId,this.brandIdArray);
			// 根据最后一页的页码，创建出显示分页按钮的数据
			this.lastPage = new int[last];
			for (int i = 0; i < this.lastPage.length; i++) {
				this.lastPage[i] = i + 1;
			}
			BrandsService brandService=new BrandsService();
			this.brandList=brandService.selectAll();
			if (this.isAdmin == 1) {
				return "product_select";	
			}
			//获得所有品牌信息

			return "products";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

	public List<BrandsDTO> getBrandList() {
		return brandList;
	}

	public void setBrandList(List<BrandsDTO> brandList) {
		this.brandList = brandList;
	}

	public int [] getBrandIdArray() {
		return brandIdArray;
	}

	public void setBrandIdArray(int [] brandIdArray) {
		this.brandIdArray = brandIdArray;
	}

	public List<ProductsDTO> getAndroidList() {
		return androidList;
	}

	public void setAndroidList(List<ProductsDTO> androidList) {
		this.androidList = androidList;
	}

	public List<ProductsDTO> getAppleList() {
		return appleList;
	}

	public void setAppleList(List<ProductsDTO> appleList) {
		this.appleList = appleList;
	}


}