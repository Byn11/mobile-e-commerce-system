package com.test.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.test.dto.UserMsgDTO;
import com.test.service.UserService;

public class AdminAction extends ActionSupport {

	private static final long serialVersionUID = -6935626505785724785L;
	// 用于封装页面中的用户信息
	private UserMsgDTO userMsgDTO;

	public UserMsgDTO getUserMsgDTO() {
		return userMsgDTO;
	}

	public void setUserMsgDTO(UserMsgDTO userMsgDTO) {
		this.userMsgDTO = userMsgDTO;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String login() throws Exception{
		try {
			UserService userService = new UserService();
			this.userMsgDTO.setPowerId(0);
			boolean b = userService.login(userMsgDTO);
			if(b){
				//登录成功，将登录成功用户信息保存到Session
				HttpSession session = ServletActionContext.getRequest().getSession(true);
				session.setAttribute("admin_login_success", this.userMsgDTO);
				return "admin_index";
			}else{
				//登录失败，跳转回login.jsp，并在login.jsp页面中显示错误信息
				HttpServletRequest request = ServletActionContext.getRequest();
				request.setAttribute("login_error", "<script>alert('登录信息不正确，请重新输入!!!');</script>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "input";
	}
}
