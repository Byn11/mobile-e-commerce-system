<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<base href="${pageContext.request.contextPath}/"></base>
<%@include file="/admin/admin_top.jsp" %>

<body>
	<form action="product/Product!selectPage?isAdmin=1" method="post">
		<div class="page-container">
			<div>
				<!-- <input type="text" class="input-text" style="width:250px" placeholder="输入商品名称" id="" name=""> -->
				<s:hidden name="pageNumber" value="1" id="pageNumber"></s:hidden>
				<s:textfield cssClass="input-text" cssStyle="width:250px" name="product.productName"></s:textfield>
				<button type="submit" class="btn btn-success" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜商品</button>
			</div>
			<div class="cl pd-5 bg-1 bk-gray mt-20">
			<%int count=0; %>
				<s:iterator value="productList" var="product">
			<%count++; %>	
				</s:iterator>
		<% pageContext.setAttribute("count", count); %>
			</span> <span class="r">共${count}<strong></strong> 条</span>				
			</div>
			<table class="table table-border table-bordered table-bg table-hover">
				<thead>
					<tr>
						<th scope="col" colspan="6">商品列表</th>
					</tr>
					<tr class="text-c">					
						<th width="5%">商品编号</th>
						<th >商品名称</th>
						<th width="10%">商品价格</th>
						<th width="15%">是否有货</th>
						<th width="15%">品牌名称</th>
						<th width="10%">操作</th>
					</tr>
				</thead>
				<tbody>
					<s:if test="productList==null">
						<tr>
							<th scope="col" colspan="6">没有满足条件的商品信息！</th>
						</tr>
					</s:if>
					<s:else>
						<s:iterator value="productList" var="product">
							<tr class="text-c">					
								<td><s:property value="#product.productId"/></td>
								<td><s:property value="#product.productName"/></td>
								<td><s:property value="#product.productPrice"/></td>
								<td>
									<s:if test="#product.productAvailability==1">
										有货
									</s:if>
									<s:else>
										无货
									</s:else>									
								</td>
								<td><s:property value="#product.brands.brandName"/></td>
								<td class="td-manage">
									<a title="编辑" href="admin_product/AdminProduct!selectById?productsDTO.productId=<s:property value='#product.productId'/>"  class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> 
								</td>
							</tr>
						</s:iterator>
					</s:else>
					<!-- <tr class="text-c">					
						<td>1</td>
						<td>admin</td>
						<td>辽宁大连</td>
						<td>admin@mail.com</td>
						<td>13000000000</td>
						<td class="td-manage"><a style="text-decoration:none" onClick="admin_stop(this,'10001')" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a> <a title="编辑" href="javascript:;" onclick="admin_edit('管理员编辑','admin-add.html','1','800','500')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> <a title="删除" href="javascript:;" onclick="admin_del(this,'1')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
					</tr>
					<tr class="text-c">					
						<td>1</td>
						<td>admin</td>
						<td>辽宁大连</td>
						<td>admin@mail.com</td>
						<td>13000000000</td>
						<td class="td-manage"><a style="text-decoration:none" onClick="admin_stop(this,'10001')" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a> <a title="编辑" href="javascript:;" onclick="admin_edit('管理员编辑','admin-add.html','1','800','500')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> <a title="删除" href="javascript:;" onclick="admin_del(this,'1')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
					</tr> -->
				</tbody>
			</table>
			<div class="text-r">
				<s:if test="pageNumber==1">
					第一页
				</s:if>
				<s:else>
					<a class="pageHref" title="1">第一页</a>
				</s:else>
				<s:iterator value="lastPage" var="page">
					<s:if test="pageNumber==#page">
						<s:property value="#page"/>
					</s:if>
					<s:else>
						<a class="pageHref" title="<s:property value='#page'/>"><s:property value="#page"/></a>
					</s:else>
				</s:iterator>
				<s:if test="pageNumber==#page">
					尾页
				</s:if>
				<s:else>
					<a class="pageHref" title="<s:property value='#page'/>">尾页</a>
				</s:else>
			</div>
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