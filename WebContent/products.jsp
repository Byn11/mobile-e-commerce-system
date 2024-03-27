<%@include file="top.jsp" %>
<body class="products-view">
			
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
					<ul class="bc push-up unstyled clearfix">
						<li><a href="index.jsp">Home</a></li>
						<li class="active">Products</li>
					</ul>
				</div>
			</div>
		</div>
		<!-- // BREADCRUMB -->
		
		<!-- SITE MAIN CONTENT -->
		<main id="main-content" role="main">
			<div class="container">
				<div class="row">
					
					<div class="m-t-b clearfix">
						<!-- SIDEBAR -->
						<aside class="col-xs-12 col-sm-4 col-md-3">
							<section class="sidebar push-up">
							
								<!-- CATEGORIES -->
								<section class="side-section bg-white">
									<header class="side-section-header">
										<h3 class="side-section-title">Categories</h3>
									</header>
									<form action="product/Product!selectPage" method="post">
									<s:hidden name="menuId"></s:hidden>
									<s:hidden name="pageNumber" id="pageNumber"></s:hidden>
									<div class="side-section-content">
										<ul id="category-list" class="vmenu unstyled">
											<li>
												<s:if test="menuId==1">
													<input type="checkbox" id="check-women" class="prettyCheckable" data-label="<s:text name="header.menu2"></s:text>" data-labelPosition="right" value="women" />
													<ul>														
														<s:iterator value="brandList" var="brand">	
															<s:set value="" name="isChecked" scope="request"></s:set>
															<s:if test="#brand.menus.menuId==1">	
																<s:iterator value="brandIdArray" var="b">																	
																	<s:if test="#b==#brand.brandId">
																		<s:set value="checked='checked'" name="isChecked" scope="request"></s:set>
																	</s:if>																	
																</s:iterator>
																
																<li>
																	<input type="checkbox" ${requestScope.isChecked }  name="brandIdArray" class="prettyCheckable selectBtn" data-label='<s:property value="#brand.brandName"/>' data-labelPosition="right" value="<s:property value="#brand.brandId"/>" />
																</li>													
															</s:if> 
														</s:iterator>
													</ul>
												</s:if>
											</li>
											<li>
												<s:if test="menuId==2">
													<input type="checkbox" id="check-men" class="prettyCheckable" data-label="<s:text name="header.menu3"></s:text>" data-labelPosition="right" value="men" />
													<ul>
														<s:iterator value="brandList" var="brand">	
															<s:set value="" name="isChecked" scope="request"></s:set>
															<s:if test="#brand.menus.menuId==2">	
																<s:iterator value="brandIdArray" var="b">																	
																	<s:if test="#b==#brand.brandId">
																		<s:set value="checked='checked'" name="isChecked" scope="request"></s:set>
																	</s:if>																	
																</s:iterator>																
																<li>
																	<input type="checkbox" ${requestScope.isChecked }  name="brandIdArray" class="prettyCheckable selectBtn" data-label='<s:property value="#brand.brandName"/>' data-labelPosition="right" value="<s:property value="#brand.brandId"/>" />
																</li>													
															</s:if> 
														</s:iterator>
													</ul>
												</s:if>
												
											</li>
										</ul>
									</div>
									</form>
									<footer class="side-section-footer text-center hide">
										<button type="button" id="btn-filter-cat" class="btn btn-primary btn-round uppercase">Clear Filters</button>
									</footer>
								</section>
								<!-- // CATEGORIES -->
								
								
								
								
								
								
								<!-- PROMO -->
								<div class="promo inverse-background" style="background: url('images/demo/1.jpg') no-repeat; background-size: auto 100%;">
									<div class="inner text-center np">
										<div class="ribbon">
											<h6 class="nmb">New Arrivals</h6>
											<h5 class="text-semibold uppercase nmb">note 5A</h5>
											<div class="space10"></div>			
											<s:a action="Product!selectById" cssClass="with-icon prepend-icon"><i class="iconfont-caret-right"></i><span> Shop Now</span>
											<s:param name="product.productId" value='5'></s:param>
										</s:a>
										</div>
									</div>
								</div>
								<div class="promo inverse-background" style="background: url('images/demo/2.jpg') no-repeat; background-size: auto 100%;">
									<div class="inner text-center np">
										<div class="ribbon">
											<h6 class="nmb">New Arrivals</h6>
											<h5 class="text-semibold uppercase nmb">mix2s</h5>
											<div class="space10"></div>			
											<s:a action="Product!selectById" cssClass="with-icon prepend-icon"><i class="iconfont-caret-right"></i><span> Shop Now</span>
											<s:param name="product.productId" value='1'></s:param>
										</s:a>
										</div>
									</div>
								</div>
								<div class="promo inverse-background" style="background: url('images/demo/3.jpg') no-repeat; background-size: auto 100%;">
									<div class="inner text-center np">
										<div class="ribbon">
											<h6 class="nmb">New Arrivals</h6>
											<h5 class="text-semibold uppercase nmb">6</h5>
											<div class="space10"></div>			
											<s:a action="Product!selectById" cssClass="with-icon prepend-icon"><i class="iconfont-caret-right"></i><span> Shop Now</span>
											<s:param name="product.productId" value='5'></s:param>
										</s:a>
										</div>
									</div>
								</div>
								<!-- // PROMO -->
								
							</section>
						</aside>
						<!-- // SIDEBAR -->
						<section class="col-xs-12 col-sm-8 col-md-9">
							
							<section class="products-wrapper">
								<!-- DISPLAY MODE - NUMBER OF ITEMS TO BE DISPLAY - PAGINATION -->
								<header class="products-header">
									<div class="row">
										<div class="col-xs-12 col-sm-12 col-md-6 center-xs">
											<!-- DISPLAY MODE -->
											<ul class="unstyled inline-li li-m-r-l-sm pull-left">
												<li><a class="round-icon active" href="#" data-toggle="tooltip" data-layout="grid" data-title="Switch to List Grid Mode"><i class="iconfont-th"></i></a></li>
												<li><a class="round-icon" href="#" data-toggle="tooltip" data-layout="list" data-title="Switch to List View Mode"><i class="iconfont-list"></i></a></li>
											</ul>
											<!-- // DISPLAY MODE -->
											
										</div>
										<div class="space30 visible-xs"></div>
										<!-- PAGINATION -->
										<div class="col-xs-12 col-sm-12 col-md-6 center-xs">
											<ul class="paginator li-m-r-l pull-right">
												<s:if test="pageNumber==1">
													<li><a class="round-icon" data-toggle="tooltip" data-title="Previous Page"><i class="iconfont-angle-left"></i></a></li>
												</s:if>
												<s:else>
													<li><a class="pageHref round-icon" name='<s:property value="pageNumber-1"/>'  href="#" data-toggle="tooltip" data-title="Previous Page"><i class="iconfont-angle-left"></i></a></li>
												</s:else>
												<s:iterator value="lastPage" var="page">
													<s:if test="pageNumber==#page">
														<li><a><s:property value="#page"/></a></li>
													</s:if>
													<s:else>
														<li><a href="#" class="pageHref" name='<s:property value="#page"/>'><s:property value="#page"/></a></li>
													</s:else>
												</s:iterator>
												<s:if test="pageNumber==#page">
													<li><a class="round-icon" data-toggle="tooltip" data-title="Next Page"><i class="iconfont-angle-right"></i></a></li>
												</s:if>
												<s:else>
													<li><a class="pageHref round-icon" name='<s:property value="pageNumber+1"/>' href="#" data-toggle="tooltip" data-title="Next Page"><i class="iconfont-angle-right"></i></a></li>
												</s:else>
											</ul>
										</div>
										<!-- // PAGINATION -->
									</div>
								</header>
								<!-- // DISPLAY MODE - NUMBER OF ITEMS TO BE DISPLAY - PAGINATION -->
								
								<!-- PRODUCT LAYOUT -->
								<div class="products-layout grid m-t-b add-cart" data-product=".product" data-thumbnail=".entry-media .thumb" data-title=".entry-title > a" data-url=".entry-title > a" data-price=".entry-price > .price">
									<s:iterator value="productList" var="product" status="loop">
										<div class="product" data-product-id='<s:property value="#loop.count"/>' data-category="women|women-jeans|women-skirt" data-brand="brand1" data-price="250" data-colors="red|blue|black|white" data-size="S|M|L">
											<div class="entry-media">
												<img data-src="<s:property value="#product.productSmallImage"/>" alt="" class="lazyLoad thumb" />
												<div class="hover">
													<a href="product/Product!selectById?product.productId=<s:property value='#product.productId'/>" class="entry-url"></a>
													<ul class="icons unstyled">														
														<li>
															<a href="<s:property value="#product.productBigImage"/>" class="circle" data-toggle="lightbox"><i class="iconfont-search"></i></a>
														</li>														
													</ul>													
												</div>
											</div>
											<div class="entry-main">
												<h5 class="entry-title">
													<a href="product/Product!selectById?product.productId=<s:property value='#product.productId'/>"><s:property value="#product.productName"/></a>
												</h5>
												<div class="entry-description visible-list">
													<p><s:property value="#product.productDescription"/></p>
												</div>
												<div class="entry-price">
													<strong class="accent-color price">$ <s:property value="#product.productPrice"/></strong>
												</div>
												
											</div>
										</div>
									</s:iterator>
									
									
								</div>
								<!-- // PRODUCT LAYOUT -->
							</section>
							
						</section>
					</div>
					
				</div>
			</div>
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
	<script src="js/jquery.nouislider.js"></script>
	<script src="js/jquery.isotope.min.js"></script>
	<script src="js/products.js"></script>
	<!-- // Particular Page Javascripts -->
	<script type="text/javascript">
		$(function(){
			$(".selectBtn+a").click(function(){
				$("form").submit();
				return false;
			});
			
			$(".pageHref").click(function(){
				var page = $(this).prop("name");
				$("#pageNumber").val(page);
				$("form").submit();
				return false;
			});
		});
	</script>
	
</body>
</html>