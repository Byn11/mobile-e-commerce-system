<%@include file="top.jsp" %>
<body class="product-single" onload="bb()">

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
						<li><a href="product/Product!selectPage?menuId=1">Products</a></li>
						<li class="active">Product Detail</li>
					</ul>
				</div>
			</div>
		</div>
		<!-- // BREADCRUMB -->
		
		<!-- SITE MAIN CONTENT -->
		<main id="main-content" role="main">
					
			<section class="section">
				<div class="container">
					<div class="row">
						<!-- PRODUCT PREVIEW -->
						<div class="col-xs-12 col-sm-4">
							
							<div class="product-preview">
								<div class="big-image">
									<a href='<s:property value="product.ProductBigImage"/>' data-toggle="lightbox">
										<img src='<s:property value="product.ProductSmallImage"/>' alt="" />
									</a>
								</div>
							</div>
							
						</div>
						<!-- // PRODUCT PREVIEW -->
						<div class="space40 visible-xs"></div>
						<!-- PRODUCT DETAILS -->
						<div class="col-xs-12 col-sm-8">
							<section class="product-details add-cart">
								<header class="entry-header">
									<h2 class="entry-title uppercase"><s:property value="product.ProductName"/></h2>
								</header>
								<article class="entry-content">
									<figure>
										<span class="entry-price inline-middle">¥<s:property value="product.ProductPrice"/></span>
										
										
										<ul class="entry-meta unstyled">
											<li>
												<span class="key">Brand:</span>
												<span class="value"><s:property value="product.brands.brandName"/></span>
											</li>
											<li>
												<span class="key">Availability:</span>
												<span class="value">
													<s:if test="product.productAvailability == 1">
														In Stock
													</s:if>
													<s:if test="product.productAvailability == 0">
														No Stock
													</s:if>
												</span>
											</li>
											
										</ul>
										
										<div class="clearfix"></div>
										
										<figcaption class="m-b-sm">
											<h5 class="subheader uppercase">Quick Overview:</h5>
											<p><s:property value="product.productDescription"/></p>
										</figcaption>										
										<s:set name="pid" value="product.productId"></s:set>										
										<form action="product/Product!addToCart" method="post">										
										<input type="hidden" name="orderDetailsDTO.productId" value="${requestScope.pid}"></input>
										<div class="row">											
											<div class="col-xs-12 col-sm-6">
												<h5 class="subheader uppercase">Color:</h5>
												<div class="inline-middle styled-dd">
													<!-- <select>
														<option>-- Please Select --</option>
														<option value="Black">Black</option>
														<option value="Aubergine">Aubergine</option>
													</select> -->
													<s:select name="orderDetailsDTO.productColorId" list="productColorList" listKey="productColorId" listValue="color.colorName"></s:select>
												</div>
											</div>
											<div class="space30 visible-xs"></div>
											<div class="col-xs-12 col-sm-6">
												<h5 class="subheader uppercase">Size:</h5>
												<div class="inline-middle styled-dd">
													<!-- <select>
														<option>-- Please Select --</option>
														<option value="xs">X-Small</option>
														<option value="s">Small</option>
													</select> -->
													<s:select name="orderDetailsDTO.productSizeId" id="size" onchange="change()" list="productSizeList" listKey="productSizeId" listValue="size.sizeName" ></s:select>
												</div>
											</div>
										</div>
										</form>
										<ul class="inline-li li-m-r-l m-t-lg" style="padding-left: 0px;">
											<li>
												<s:if test="#session.login_success != null">
													<a href="#" id="btnHref" class="btn btn-default btn-lg btn-round add-to-cart">Add to Cart</a>
												</s:if>												
											</li>
										</ul>
										
									</figure>
								</article>
							</section>
						</div>
						<!-- // PRODUCT DETAILS -->
					</div>
					
				</div>
			</section>
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
	<script src="js/owl.carousel.js"></script>
	<script src="js/products.js"></script>
	<!-- // Particular Page Javascripts -->
	
	<!-- Disqus -->
	<script type="text/javascript">
	/* * * CONFIGURATION VARIABLES: EDIT BEFORE PASTING INTO YOUR WEBPAGE * * */
	var disqus_shortname = 'gfashion';		// required: replace example with your forum shortname

	/* * * DON'T EDIT BELOW THIS LINE * * */
	(function() {
		var dsq = document.createElement('script'); dsq.async = true;
		dsq.src = '//' + disqus_shortname + '.disqus.com/embed.js';
		(document.getElementsByTagName('head')[0] || document.getElementsByTagName('body')[0]).appendChild(dsq);
	})();
	</script>
	<!-- // Disqus -->
	<script type="text/javascript">
		$(function(){
			$("#btnHref").click(function(){
				$("form").submit();
				return false;
			});
		});
		function change()
		{
			var a1=$("#size").val();
		//	document.getElementById("size")[1].selected=true;//1 dai biao di er ge
			window.location.href="/struts_project/product/Product!priceAlter?product.productId=${requestScope.pid}&aa="+a1;
		}
		function bb(){
		    var a = '<%=request.getAttribute("productSizeId")%>';
		    a=parseInt(a);
		    if(a!=null||!isNaN(a)){
		    	var array = document.getElementById("size").options;
		    	for(var i = 0 ; i < array.length ; i++){
		    		if(array[i].value==a){
		    			document.getElementById("size").options[i].selected=true;
		    			break;
		    		}
		    	}
		    }
			    //document.getElementById("size").options[(parseInt(a)-1)].selected=true;
		   // var b=document.getElementById("size").value;
		   // alert("b="+b);



		    
		}
	</script>
	${sessionScope.addCartSuccess }
	<% session.removeAttribute("addCartSuccess"); %>
</body>
</html>