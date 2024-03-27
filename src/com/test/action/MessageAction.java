package com.test.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.test.dto.MessageDTO;
import com.test.service.MessageService;

public class MessageAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6217367695720899575L;
	
	private List<MessageDTO> messageList;
	private MessageDTO messageDTO;
	private Integer menuId;
	public MessageDTO getMessageDTO() {
		return messageDTO;
	}
	public void setMessageDTO(MessageDTO messageDTO) {
		this.messageDTO = messageDTO;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

public String insert() throws Exception{
	MessageService messageService = new MessageService();
		boolean insert = messageService.insert(messageDTO);
		if(insert){
			HttpSession session = ServletActionContext.getRequest().getSession(true);
			session.setAttribute("addSuccess",
					"<script>alert('添加成功！！！');</script>");
			System.out.println("录入成功");
			return "contact";
		}
	else {
		System.out.println("录入失败");
	}
		
	return "error";
	
}
public String selectAll() throws Exception{
	try{
			MessageService messageService = new MessageService();
			messageList=messageService.selectAll();
			return "index";
		
	}catch(Exception e) {
			e.printStackTrace();
		}
		return "error";

	
}
public List<MessageDTO> getMessageList() {
	return messageList;
}
public void setMessageList(List<MessageDTO> messageList) {
	this.messageList = messageList;
}
public Integer getMenuId() {
	return menuId;
}
public void setMenuId(Integer menuId) {
	this.menuId = menuId;
}


}
