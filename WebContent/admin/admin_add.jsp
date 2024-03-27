<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<base href="${pageContext.request.contextPath}/"></base>
<%@include file="/admin/admin_top.jsp" %>

<script type="text/javascript" src="js/user_validate.js"></script> 



</head>
<body>
<article class="page-container">
	<form action="user/User!register?userMsgDTO.powerId=0" class="form form-horizontal" id="form-admin-add" autocomplete="off" enctype="multipart/form-data" method="post">
		<div class="row cl">
			<label class="form-label col-xs-2 col-sm-2"><span class="c-red">*</span>管理员：</label>
			<div class="formControls col-xs-5 col-sm-5">
				<input type="text" class="input-text" value="" placeholder="" id="userName" name="userMsgDTO.userName">
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-2 col-sm-2"><span class="c-red">*</span>初始密码：</label>
			<div class="formControls col-xs-5 col-sm-5">
				<input type="password" class="input-text" autocomplete="off" value="" placeholder="密码" id="password" name="userMsgDTO.userPassword">
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-2 col-sm-2"><span class="c-red">*</span>确认密码：</label>
			<div class="formCo	ntrols col-xs-5 col-sm-5">
				<input type="password" class="input-text" autocomplete="off" value="" placeholder="确认新密码" id="password2" >
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-2 col-sm-2"><span class="c-red">*</span>联系电话：</label>
			<div class="formControls col-xs-5 col-sm-5">
				<input type="text" class="input-text" autocomplete="off" value="" placeholder="联系电话" id="user_telephone" name="userMsgDTO.userTelephone">
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-2 col-sm-2"><span class="c-red">*</span>电子邮箱：</label>
			<div class="formControls col-xs-5 col-sm-5">
				<input type="text" class="input-text" autocomplete="off" value="" placeholder="电子邮箱" id="user_email" name="userMsgDTO.userEmail">
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-2 col-sm-2"><span class="c-red">*</span>家庭住址：</label>
			<div class="formControls col-xs-5 col-sm-5">
				<input type="text" class="input-text" autocomplete="off" value="" placeholder="家庭住址" id="user_address" name="userMsgDTO.userAddress">
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-2 col-sm-2"><span class="c-red">*</span>生日：</label>
			<div class="formControls col-xs-5 col-sm-5">
				<input type="text" class="input-text" autocomplete="off" value="" placeholder="生日(请按yyyy-MM-dd格式录入)" id="user_birthday" name="userMsgDTO.userBirthday">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-2 col-sm-2"><span class="c-red">*</span>邮编：</label>
			<div class="formControls col-xs-5 col-sm-5">
				<input type="text" class="input-text" autocomplete="off" value="" placeholder="邮编" id="user_postcode" name="userMsgDTO.userPostcode">
			</div>
		</div>
		<div class="row cl">
			<div class="form-label col-xs-7 col-sm-7 text-r">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;" onclick="return f1();">
			</div>
		</div>
	</form>
</article>

<!-- 导入JS文件开始 -->
<%@include file="/admin/admin_footer.jsp" %>
<!-- 导入JS文件结束 -->
	${sessionScope.registerSuccess }
	<% session.removeAttribute("registerSuccess"); %>
</body>
</html>