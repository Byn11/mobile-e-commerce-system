package com.test.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.test.common.PageUtil;
import com.test.dto.UserMsgDTO;
import com.test.service.UserService;

public class UserAction extends ActionSupport {

	private static final long serialVersionUID = -1885854904242552572L;
	// 用于封装页面中的用户信息
	private UserMsgDTO userMsgDTO;
	//用于保存批量用户信息
	private List<UserMsgDTO> userList;
	//用于保存分页按钮的信息
	private int[] pageButtons;
	//用于保存最后一页的页数
	private int lastPage;
	//用户保存显示的页数
	private int pageNumber;
	public UserMsgDTO getUserMsgDTO() {
		return userMsgDTO;
	}

	public void setUserMsgDTO(UserMsgDTO userMsgDTO) {
		this.userMsgDTO = userMsgDTO;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 用户注册
	 * 
	 * @return
	 * @throws Exception
	 */
	public String register() throws Exception {
		//this.userMsgDTO.setPowerId(1);
		UserService userService = new UserService();
		// 判断用户名是否重复
		boolean exists = userService.isExists(this.userMsgDTO);
		if (!exists) {
			// 用户名不重复,注册用户信息
			boolean insert = userService.insert(userMsgDTO);
			if (insert) {
				// 如果注册成功，查询注册成功用户的完整信息
				this.userMsgDTO = userService.selectByName(userMsgDTO);
				// 如果查询成功，将注册成功用户的完整信息添加到Session中
				HttpSession session = ServletActionContext.getRequest().getSession(true);
				session.setAttribute("login_success", this.userMsgDTO);
				System.out.println("注册成功");
				if(this.userMsgDTO.getPowerId()==1)
					return "index";
				else{
					session.setAttribute("registerSuccess",
							"<script>alert('添加成功！！！');</script>");
					return "admin_add";
				}
					
				
			} else {
				System.out.println("注册失败");
			}
		} else {
			System.out.println("用户名已存在");
		}
		return null;
	}

	/**
	 * 用户登录
	 * 
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception {
		UserService userService = new UserService();
		this.userMsgDTO.setPowerId(1);
		boolean b = userService.login(userMsgDTO);
		if(b){
			//登录成功，将登录成功用户信息保存到Session
			HttpSession session = ServletActionContext.getRequest().getSession(true);
			session.setAttribute("login_success", this.userMsgDTO);
			return "index";
		}else{
			//登录失败，跳转回login.jsp，并在login.jsp页面中显示错误信息
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("login_error", "<script>alert('登录信息不正确，请重新输入!!!');</script>");
		}
		return "login";
	}
	/**
	 * 注销
	 * @return
	 * @throws Exception
	 */
	public String logout() throws Exception{
		HttpSession session=ServletActionContext.getRequest().getSession();
		if(session!=null){
			session.invalidate();
		}
		return "index";
	}
	/**
	 * 查询管理员信息(分页功能)
	 * 
	 * @return
	 * @throws Exception
	 */
	public String adminSelectPage() throws Exception {
		// 将要显示的页数,如果页数为0则默认为第1页
		if (this.pageNumber == 0) {
			this.pageNumber = 1;
		}
		// 每页显示数据的行数
		int pageRows = PageUtil.PAGE_ROWS;

		// 设置用户的权限为管理员
		if(this.userMsgDTO == null){
			this.userMsgDTO = new UserMsgDTO();
		}
		//this.userMsgDTO.setPowerId(0);
		// 调用Service中的方法，获得指定行数的数据
		UserService service = new UserService();
		this.userList = service.selectPage(userMsgDTO, pageNumber, pageRows);

		int count = service.selectCount(userMsgDTO);
		// 根据行数与每页显示数据的行数，计算出最后一页的页数
		this.lastPage = (int) Math.ceil(Double.valueOf(count)
				/ Double.valueOf(pageRows));

		// 根据最后一页的页数，生成页面中每页按钮的信息
		this.pageButtons = new int[this.lastPage];
		for (int i = 0; i < this.lastPage; i++) {
			this.pageButtons[i] = i + 1;
		}
		if(userMsgDTO.getPowerId()==0)
			return "admin_select";
		else 
			return "user_select";
	}
	public List<UserMsgDTO> getUserList() {
		return userList;
	}

	public void setUserList(List<UserMsgDTO> userList) {
		this.userList = userList;
	}

	public int[] getPageButtons() {
		return pageButtons;
	}

	public void setPageButtons(int[] pageButtons) {
		this.pageButtons = pageButtons;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}


}
