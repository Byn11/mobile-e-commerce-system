package com.test.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.test.dto.OrderDetailsDTO;
import com.test.dto.OrdersDTO;
import com.test.dto.UserMsgDTO;
import com.test.service.OrdersService;

public class OrderAction extends ActionSupport {

	private static final long serialVersionUID = 8950564158377780986L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String insert() throws Exception{
		try {
			
			HttpSession session = ServletActionContext.getRequest().getSession(true);
			//从Session中获得登录用户的完整信息
			UserMsgDTO userMsgDTO = (UserMsgDTO) session.getAttribute("login_success");
			//获得登录用户的编号
			Integer userId = userMsgDTO.getUserId();
			
			//创建订单信息
			OrdersDTO ordersDTO = new OrdersDTO();
			//设置订单的用户信息
			ordersDTO.setUserId(userId);
			
			//从Session中获得当前用户的购物车信息
			@SuppressWarnings("unchecked")
			List<OrderDetailsDTO> carList = (List<OrderDetailsDTO>) session.getAttribute("carList");
			
			//添加订单信息与订单明细信息
			OrdersService ordersService = new OrdersService();
			boolean insert = ordersService.insert(ordersDTO, carList);
			if(insert){
				//删除当前用户的购物车
				session.removeAttribute("carList");
				session.setAttribute("order_success", "<script>alert('购买成功！！！')</script>");
				return "order_success";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}
}
