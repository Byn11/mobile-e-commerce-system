<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<base href="${pageContext.request.contextPath}/"></base>
<%@include file="/admin/admin_top.jsp" %>
<body>
<form action="user/User!adminSelectPage?userMsgDTO.powerId=1" method="post">
	<div class="page-container">
		<div>
			<s:hidden name="pageNumber" value="1" id="pageNumber"></s:hidden>
			<s:textfield cssClass="input-text" cssStyle="width:250px" placeholder="输入用户姓名" name="userMsgDTO.userName"></s:textfield>
			<button type="submit" class="btn btn-success" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜用户</button>
		</div>
		<div class="cl pd-5 bg-1 bk-gray mt-20">
		<%int count=0; %>
		<s:iterator value="userList" var="user">
			<%count++; %>	
		</s:iterator>
		<% pageContext.setAttribute("count", count); %>
			</span> <span class="r">共${count}<strong></strong> 条</span>
		</div>
		<table class="table table-border table-bordered table-bg">
			<thead>
				<tr>
					<th scope="col" colspan="9">用户列表</th>
				</tr>
				<tr class="text-c">					
					<th width="5%">用户编号</th>
					<th width="10%">用户名称</th>
					<th >用户住址</th>
					<th width="15%">用户邮箱</th>
					<th width="15%">用户联系电话</th>
				</tr>
			</thead>
			<tbody>
				<s:if test="userList==null">
						<tr>
							<th scope="col" colspan="6">没有满足条件的用户信息！</th>
						</tr>
					</s:if>
					<s:else>
						<s:iterator value="userList" var="user">
							<tr class="text-c">					
								<td><s:property value="#user.userId"/></td>
								<td><s:property value="#user.userName"/></td>
								<td><s:property value="#user.userAddress"/></td>
								<td><s:property value="#user.userEmail"/></td>
								<td><s:property value="#user.userTelephone"/></td>
							</tr>
						</s:iterator>
					</s:else>
			</tbody>
		</table>
	</div>
	
	
</form>
	
	
	<!-- 导入JS文件开始 -->
	<%@include file="/admin/admin_footer.jsp" %>	
			<script type="text/javascript">
		$(function(){
			$(".pageHref").click(function(){
				var val = $(this).prop("title");
				$("#pageNumber").val(val);
				$("form").submit();
				return false;
			});
		});
	</script>
	<!-- 导入JS文件结束 -->
</body>
</html>