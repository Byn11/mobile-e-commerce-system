<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<base href="${pageContext.request.contextPath}/"></base>
<%@include file="/admin/admin_top.jsp" %>
</head>
<body>
<article class="page-container">
	<form action="admin_product/AdminProduct!insert" class="form form-horizontal" id="form-admin-add" autocomplete="off" enctype="multipart/form-data" method="post">
		<div class="row cl">
			<label class="form-label col-xs-2 col-sm-2"><span class="c-red">*</span>商品名称：</label>
			<div class="formControls col-xs-5 col-sm-5">
				<input type="text" class="input-text" value="" placeholder="商品名称" id="product_name" name="productsDTO.productName">
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-2 col-sm-2"><span class="c-red">*</span>商品价格：</label>
			<div class="formControls col-xs-5 col-sm-5">
				<input type="text" class="input-text" autocomplete="off" value="" placeholder="商品价格" id="product_price" name="productsDTO.productPrice">
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-2 col-sm-2"><span class="c-red">*</span>商品大图：</label>
			<div class="formCo	ntrols col-xs-5 col-sm-5">
				<input type="file" class="input-text" autocomplete="off" value="" placeholder="商品大图" id="product_big_image" name="productBigImage">
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-2 col-sm-2"><span class="c-red">*</span>商品小图：</label>
			<div class="formCo	ntrols col-xs-5 col-sm-5">
				<input type="file" class="input-text" autocomplete="off" value="" placeholder="商品小图" id="product_small_image" name="productSmallImage">
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-2 col-sm-2"><span class="c-red">*</span>商品品牌：</label>
			<div class="formControls col-xs-5 col-sm-5">				
				<!-- <select class="input-text" name="brand_id" id="brand_id"></select> -->
				<s:select cssClass="input-text" name="brandId" list="brandsList" listKey="brandId" listValue="brandName"></s:select>
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-2 col-sm-2"><span class="c-red">*</span>商品尺码：</label>
			<div class="formControls col-xs-5 col-sm-5">
				<div class="skin-minimal">				 
				  <s:iterator value="sizeList" var="size">
				  	<div class="check-box" style="padding-left:0px;">
					    <input type="radio" name="size" value='<s:property value="#size.sizeId"/>'>
					    <label><s:property value="#size.sizeName"/></label>
					  </div>
				  </s:iterator>
				</div>
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-2 col-sm-2"><span class="c-red">*</span>商品颜色：</label>
			<div class="formControls col-xs-5 col-sm-5">
				<div class="skin-minimal">				 
				  <s:iterator value="colorList" var="color">
				  	<div class="check-box" style="padding-left:0px;">
					    <input type="checkbox" name="colorArray" value='<s:property value="#color.colorId"/>'>
					    <label><s:property value="#color.colorName"/></label>
					  </div>
				  </s:iterator>
				</div>
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-2 col-sm-2">商品简介：</label>
			<div class="formControls col-xs-5 col-sm-5">
				<textarea name="productsDTO.productDescription" cols="" rows="" class="textarea"  placeholder="说点什么...500个字符以内" dragonfly="true"></textarea>
			</div>
		</div>
		
		<div class="row cl">
			<div class="form-label col-xs-7 col-sm-7 text-r">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</article>

<!-- 导入JS文件开始 -->
<%@include file="/admin/admin_footer.jsp" %>
<script type="text/javascript" src="admin/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="admin/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="admin/lib/jquery.validation/1.14.0/messages_zh.js"></script> 
<!-- 导入JS文件结束 -->
<s:if test="actionErrors[0]=='图片格式不正确！！！'">
	<s:property value="actionErrors[0]" />
</s:if>
${sessionScope.product_add_success}
<% session.removeAttribute("product_add_success"); %>
</body>
</html>