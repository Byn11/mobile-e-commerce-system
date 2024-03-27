<%@include file="top.jsp" %>
<body>
			
	<!-- PAGE WRAPPER -->
<div id="page-wrapper">

	<!-- SITE HEADER -->
	<header id="site-header" role="banner">
		<%@include file="header.jsp" %>
	</header>
	<!-- // SITE HEADER -->
	
		<!-- BREADCRUMB -->
		<div class="breadcrumb-container">
			<div class="container">
				<div class="relative">
					<ul class="bc unstyled clearfix">
						<li><a href="index.jsp">Home</a></li>
						<li class="active">Shopping Cart</li>
					</ul>
				</div>
			</div>
		</div>
		<!-- // BREADCRUMB -->
		
		<!-- SITE MAIN CONTENT -->
		<main id="main-content" role="main">
				
			<section class="section">
				<div class="container">					
					<table class="tbl-cart">
						<thead>
							<tr>
								<th>Product Name</th>
								<th style="width: 15%;">Unit Price</th>
								<th style="width: 15%;">QTY</th>
								<th class="hidden-xs" style="width: 15%;">Sub Total</th>
								<th class="hidden-xs" style="width: 10%;"></th>
							</tr>
						</thead>
						<tbody>
							<s:if test="#session.carList==null">
								<tr class="empty-cart">
									<td colspan="5">
										It seems your shopping cart is empty, try looking our <a href="products.html">products</a>.
									</td>
								</tr>
							</s:if>
							<s:else>
								<% 
									double total = 0;									
								%>
								<s:iterator value="#session.carList" var="pro">	
									<s:iterator value="productList" var="product">
										<s:if test="#pro.productId==#product.productId">
											<s:set value="#product.productPrice" name="price" scope="request"></s:set>
											<s:set value="#pro.productQty" name="qty" scope="request"></s:set>
											<% total = total + (Double.valueOf(request.getAttribute("price").toString()) * Double.valueOf(request.getAttribute("qty").toString())); %>
											<tr> 
												<td>
													<a class="entry-thumbnail" href='<s:property value="#product.productBigImage"/>' data-toggle="lightbox">
														<img src='<s:property value="#product.productSmallImage"/>' alt="" />
													</a>
												<%-- 	<a class="entry-title" href="product.html"><s:property value="#product.productName"/> </a> --%>
													<s:a action="Product!selectById" cssClass="entry-title">
														<s:property value="#product.productName"/>
														<s:param name="product.productId" value='#product.productId'></s:param>
												</s:a>
												</td>
												<td><span class="unit-price">$<s:property value="#product.productPrice"/></span></td>
												<td>
													<div class="qty-btn-group">
														<button type="button" class="down"><i class="iconfont-caret-down inline-middle"></i></button>
														<input type="text" value='<s:property value="#pro.productQty"/>' />
														<button type="button" class="up"><i class="iconfont-caret-up inline-middle"></i></button>
													</div>
												</td>
												<td class="hidden-xs"><strong class="text-bold row-total">$<s:property value="#product.productPrice*#pro.productQty"/></strong></td>
												<s:set name="pid" value="#pro.productId"></s:set>
												<s:set name="cid" value="#pro.productColorId"></s:set>
												<s:set name="sid" value="#pro.productSizeId"></s:set>
												<td class="hidden-xs"><button type="button" onclick="delItem(${requestScope.pid},${requestScope.cid},${requestScope.sid});">Remove</button></td>
											</tr>
										</s:if>
									</s:iterator>							
								</s:iterator>
								<% pageContext.setAttribute("total", total); %>
								
							</s:else>
						</tbody>
					</table>
					<form action="product/Product!delCartItem" id="delForm">
						<input type="hidden" name="orderDetailsDTO.productId" id="productId"/>
						<input type="hidden" name="orderDetailsDTO.productColorId" id="colorId"/>
						<input type="hidden" name="orderDetailsDTO.productSizeId" id="sizeId"/>
					</form>
					
					
					<div class="shopcart-total pull-right clearfix">						
						<div class="cart-total text-bold m-b-lg clearfix">
							<span class="pull-left">Grand Total:</span>
							<span class="pull-right">$ ${total==null ? 0.0 : total}</span>
						</div>
						<div class="text-center">
							<s:if test="#session.carList!=null">
								<a class="btn btn-round btn-default uppercase" href="order/Orders!insert">Proceed to checkout</a>
							</s:if>	
						</div>
					</div>
					
				</div>
			</section>
<!-- RELATED PRODUCTS -->
			<section class="section visible-items-4">
				<div class="container">
					<div class="row">
						<header class="section-header clearfix col-sm-offset-3 col-sm-6">
							<h3 class="section-title">You may be interested in</h3>
							<p class="section-teaser">Lorem ipsum dolor sit amet, consectetur adipiscing elit ac lobortis lacus</p>
						</header>
						
						<div class="clearfix"></div>
						
						<!-- BEGIN CAROUSEL -->
						<div id="featured-products" class="add-cart" data-product=".product" data-thumbnail=".entry-media .thumb" data-title=".entry-title > a" data-url=".entry-title > a" data-price=".entry-price > .price">
						
							<div class="owl-controls clickable top">
								<div class="owl-buttons">
									<div class="owl-prev"><i class="iconfont-angle-left"></i></div>
									<div class="owl-next"><i class="iconfont-angle-right"></i></div>
								</div>
							</div>
							
							<div class="owl-carousel owl-theme" data-visible-items="4" data-navigation="true" data-lazyload="true">

				
								<s:iterator value="appleList" var="appleProduct" status="loop">
								<div class="product" data-product-id='<s:property value="#loop.count" />'>
									<div class="entry-media">
										<img data-src='<s:property value="#appleProduct.productSmallImage"/>' alt="" class="lazyOwl thumb" />
										<div class="hover">
												<s:a action="Product!selectById" cssClass="entry-url">
													<s:param name="product.productId" value='#appleProduct.productId'></s:param>
												</s:a>
											<ul class="icons unstyled">
												<li>
													<a href='<s:property value="#appleProduct.productSmallImage"/>' class="circle" data-toggle="lightbox"><i class="iconfont-search"></i></a>
												</li>
<!-- 												<li>
													<a href="#" class="circle add-to-cart" data-><i class="iconfont-shopping-cart"></i></a>
												</li> -->
											</ul>
										</div>
									</div>
									<div class="entry-main">
										<h5 class="entry-title">
												<s:a action="Product!selectById">
													<s:property value="#appleProduct.productName"/>
													<s:param name="product.productId" value='#appleProduct.productId'></s:param>
												</s:a>
										</h5>
										<div class="entry-price">
											<strong class="price">¥ <s:property value="#appleProduct.productPrice"/></strong>
										</div>
									</div>
								</div>
								</s:iterator>
							
							</div>
								
						</div>
						<!-- // END CAROUSEL -->
						
					</div>
				</div>
			</section>
			<!-- // RELATED PRODUCTS -->			

			
			
		</main>
		<!-- // SITE MAIN CONTENT -->
		
		<!-- SITE FOOTER -->
	<footer class="page-footer">
		<%@include file="footer.jsp" %>
	</footer>
	<!-- // SITE FOOTER -->
		
</div>
<!-- // PAGE WRAPPER -->

<!-- Essential Javascripts -->
<script src="js/minified.js"></script>
<!-- // Essential Javascripts -->


<!-- Particular Page Javascripts -->
<script src="js/products.js"></script>
<script src="js/owl.carousel.js"></script>
<!-- // Particular Page Javascripts -->
<script type="text/javascript">
	function delItem(productId,colorId,sizeId){
		$("#productId").val(productId);
		$("#colorId").val(colorId);
		$("#sizeId").val(sizeId);
		$("#delForm").submit();
	}
</script>
${sessionScope.order_success }
<% session.removeAttribute("order_success"); %>
</body>
</html>