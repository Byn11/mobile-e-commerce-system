<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<base href="${pageContext.request.contextPath}/"></base>
<%@include file="/admin/admin_top.jsp" %>
<body>
	<!-- 导入页面顶部内容开始 -->
	<%@include file="/admin/admin_navbar.jsp" %>
	<!-- 导入页面顶部内容结束 -->
	<!-- 导入页面左侧菜单开始 -->
	<%@include file="/admin/left_menu.jsp" %>
	<!-- 导入页面左侧菜单结束 -->
	<!-- 页面右侧内容开始 -->
	<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
	<section class="Hui-article-box">
		<div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
			<div class="Hui-tabNav-wp">
				<ul id="min_title_list" class="acrossTab cl">
					<li class="active">
						<span title="用户查询" data-href="user/User!adminSelectPage?userMsgDTO.powerId=1">用户查询</span>
						<em></em>
					</li>
				</ul>
			</div>
			<div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a></div>
		</div>
		<div id="iframe_box" class="Hui-article">
			<div class="show_iframe">
				<div style="display:none" class="loading"></div>
				<iframe scrolling="yes" frameborder="0" src="user/User!adminSelectPage?userMsgDTO.powerId=1"></iframe>
			</div>
		</div>
	</section>
	
	<div class="contextMenu" id="Huiadminmenu">
		<ul>
			<li id="closethis">关闭当前 </li>
			<li id="closeall">关闭全部 </li>
		</ul>
	</div>
	<!-- 页面右侧内容结束 -->
	<!-- 导入JS文件开始 -->
	<%@include file="/admin/admin_footer.jsp" %>
	<!-- 导入JS文件结束 -->
</body>
</html>