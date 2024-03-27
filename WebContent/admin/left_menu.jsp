<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 左侧菜单开始 -->
<aside class="Hui-aside">
	<div class="menu_dropdown bk_2">
		<dl>
			<dt class="selected"><i class="Hui-iconfont">&#xe60d;</i> 用户管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd style="display: block;">
				<ul>
					<li><a data-href="user/User!adminSelectPage?userMsgDTO.powerId=1" data-title="用户查询" href="javascript:void(0)">用户查询</a></li>
				</ul>
			</dd>
		</dl>
		<dl>
			<dt><i class="Hui-iconfont">&#xe62d;</i> 管理员管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="admin/admin_add.jsp" data-title="添加管理员" href="javascript:void(0)">添加管理员</a></li>
					<li><a data-href="user/User!adminSelectPage?userMsgDTO.powerId=0" data-title="查询管理员" href="javascript:void(0)">查询管理员</a></li>
				</ul>
			</dd>
		</dl>
		<dl>
			<dt><i class="Hui-iconfont">&#xe620;</i> 商品管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="admin_product/AdminProduct!productInsertForm" data-title="添加商品" href="javascript:void(0)">添加商品</a></li>
					<li><a data-href="product/Product!selectPage?isAdmin=1" data-title="查询商品" href="javascript:void(0)">查询商品</a></li>
				</ul>
			</dd>
		</dl>
		<!-- <dl>
			<dt><i class="Hui-iconfont">&#xe61a;</i> 颜色/尺码<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="#" data-title="颜色管理" href="javascript:void(0)">颜色管理</a></li>
					<li><a data-href="#" data-title="尺码管理" href="javascript:void(0)">尺码管理</a></li>
				</ul>
			</dd>
		</dl> -->
	</div>
</aside>

<!-- 左侧菜单结束 -->