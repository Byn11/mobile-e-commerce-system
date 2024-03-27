package com.test.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.test.common.DbUtils;
import com.test.dao.OrderDetailsDAO;
import com.test.dao.OrdersDAO;
import com.test.dao.impl.OrderDetailsDaoImpl;
import com.test.dao.impl.OrdersDaoImpl;
import com.test.dto.OrderDetailsDTO;
import com.test.dto.OrdersDTO;

public class OrdersService {
	//订单持久化层对象
	private OrdersDAO ordersDAO;
	//订单明细持久化层对象
	private OrderDetailsDAO orderDetailsDAO;

	public OrdersService(){
		this.orderDetailsDAO=new OrderDetailsDaoImpl();
		this.ordersDAO=new OrdersDaoImpl();
	}
	/**
	 * 添加订单信息与订单
	 * @param ordersDTO 订单信息
	 * @param list 所有订单明细信息
	 * @return 添加成功返回true，否则返回false
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public boolean insert(OrdersDTO ordersDTO,List<OrderDetailsDTO> list) throws ClassNotFoundException, SQLException{
		Connection conn=DbUtils.getConnection();
		try{
			//获得最新订单编号
			Integer orderId=this.ordersDAO.selectOrderId(conn);
			//将最新的订单编号存入订单信息中
			ordersDTO.setOrderId(orderId);
			boolean insert = this.ordersDAO.insert(conn, ordersDTO);
			if(insert){
				//如果订单信息添加成功
				for(OrderDetailsDTO dto:list){
					insert=this.orderDetailsDAO.insert(conn, dto, orderId);
					if(!insert){
						break;						
					}
				}
				if(insert){
					conn.commit();
					return true;
				}
				conn.rollback();
			}
		}finally{
			conn.close();
		}
		
		return false;
		
	}
}
