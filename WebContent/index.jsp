<%@include file="top.jsp" %>

<body class="home">	
	<s:if test="androidList == null">		
		<%-- <jsp:forward page="/product/Product!ready"></jsp:forward> --%>
		<% response.sendRedirect("/struts_project/product/Product!ready"); %>
	</s:if>
			
<!-- PAGE WRAPPER -->
<div id="page-wrapper">

	<!-- SITE HEADER -->
	<header id="site-header" role="banner">
		<%@include file="header.jsp" %>
	</header>
	<!-- // SITE HEADER -->
    
   
		
		<!-- HOMEPAGE SLIDER -->
		<div id="home-slider">
			<div class="flexslider">
	<ul class="slides">
		<!-- THE FIRST SLIDE -->
		<li>
			<!-- THE MAIN IMAGE IN THE SLIDE -->
			<img src="rev-slider/img/slides/index1.jpg" alt="" />
		</li>
		<li>
			<!-- THE MAIN IMAGE IN THE SLIDE -->
			<s:a action="Product!selectById" cssClass="entry-url">
				<s:param name="product.productId" value='7'></s:param>
				<img src="rev-slider/img/slides/index2.jpg" alt="" />
			</s:a>
			
		</li>
		<li>
			<!-- THE MAIN IMAGE IN THE SLIDE -->
			
			<s:a action="Product!selectById" cssClass="entry-url">
				<s:param name="product.productId" value='5'></s:param>
				<img src="rev-slider/img/slides/index3.jpg" alt="" />
			</s:a>
		</li>
		<li>
			<a href="product/Product!selectPage?menuId=2">
				<img src="rev-slider/img/slides/index4.jpg" alt="" />
			</a>
		</li>
			
	</ul>
</div>

<script>
	jQuery(function($) {
		var $slider = $('#home-slider > .flexslider');
		$slider.find('.flex-caption').each(function() {
			var $this = $(this);
			var configs = {
				left: $this.data('x'),
				top: $this.data('y'),
				speed: $this.data('speed') + 'ms',
				delay: $this.data('start') + 'ms'
			};
			if ( configs.left == 'center' && $this.width() !== 0 ) 
			{
				configs.left = ( $slider.width() - $this.width() ) / 2;
			}
			if ( configs.top == 'center' && $this.height() !== 0 ) 
			{
				configs.top = ( $slider.height() - $this.height() ) / 2;
			}
			
			$this.data('positions', configs);
			
			$this.css({
				'left': configs.left + 'px',
				'top': configs.top + 'px',
				'animation-duration': configs.speed,
				'animation-delay': configs.delay
			});
		});
		
		$(window).on('resize', function() {
			var wW = $(window).width(),
				zoom = ( wW >= 1170 ) ? 1 : wW / 1349;
			$('.flex-caption.gfc').css('zoom', zoom);
		});
		$(window).trigger('resize');
		
		
		
		$slider.imagesLoaded(function() {
			$slider.flexslider({
				animation: 'slide',
				easing: 'easeInQuad',
				slideshow: false,
				nextText: '<i class="iconfont-angle-right"></i>',
				prevText: '<i class="iconfont-angle-left"></i>',
				start: function() {
					flex_fix_pos(1);
				},
				before: function(slider) {
					// initial caption animation for next show
					$slider.find('.slides li .animation-done').each(function() {
						$(this).removeClass('animation-done');
						var animation = $(this).attr('data-animation');
						$(this).removeClass(animation);
					});
					
					flex_fix_pos(slider.animatingTo + 1);
				},
				after: function() {
					// run caption animation
					$slider.find('.flex-active-slide .animated').each(function() {
						var animation = $(this).attr('data-animation');
						$(this).addClass('animation-done').addClass(animation);
					});
				}
			});
		});
		
		
		function flex_fix_pos(i) {
			$slider.find('.slides > li:eq(' + i + ') .gfc').each(function() {
				var $this = $(this),
					pos = $(this).data('positions');
					
				if ( pos.left == 'center' )
				{
					pos.left = ( $slider.width() - $this.width() ) / 2;
					$this.css('left', pos.left + 'px');
					$this.data('positions', pos);
				}
				if ( pos.top == 'center' )
				{
					pos.top = ( $slider.height() - $this.height() ) / 2;
					$this.css('left', pos.top + 'px');
					$this.data('positions', pos);
				}
			});
		}
	});
</script>		</div>
		<!-- // HOMEPAGE SLIDER -->
		
		<!-- SITE MAIN CONTENT -->
		<main id="main-content" role="main">
			
			<!-- PROMO BOXES -->
			<section class="section promos">
				<div class="container">
					<div class="row">
						<div class="col-md-4">
							<div class="promo inverse-background first-row animated" data-animation="fadeInDown" style="background: url('images/demo/3.jpg') no-repeat; background-size: 100%;">
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
						</div>
						<div class="col-md-4">
							<div class="promo inverse-background first-row animated" data-animation="fadeInDown" style="background: url('images/demo/2.jpg') no-repeat; background-size: 100%;">
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
						</div>
						<div class="col-md-4">
							<div class="promo inverse-background first-row animated" data-animation="fadeInDown" style="background: url('images/demo/1.jpg') no-repeat; background-size: 100%;">
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
						</div>					
					</div>
				</div>
			</section>
		
			<!-- // PROMO BOXES -->
			
			<!-- FEATURED PRODUCTS -->
			<section class="section featured visible-items-4">
				<div class="container">
					<div class="row">
						<header class="section-header clearfix col-sm-offset-3 col-sm-6">
							<h3 class="section-title"><s:text name="index.menu1"></s:text></h3>
							<!-- <p class="section-teaser">Lorem ipsum dolor sit amet, consectetur adipiscing elit ac lobortis lacus</p> -->
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
								<s:iterator value="androidList" var="androidProduct" status="loop">
									<div class="product" data-product-id='<s:property value="#loop.count" />' >
										<div class="entry-media">
											<img data-src='<s:property value="#androidProduct.productSmallImage"/>' alt="" class="lazyOwl thumb" />
											<div class="hover">
												<!-- <a href="Product!selectById" class="entry-url"></a> -->
												<s:a action="Product!selectById" cssClass="entry-url">
													<s:param name="product.productId" value='#androidProduct.productId'></s:param>
												</s:a>
												<ul class="icons unstyled">													
													 <li>
														<a href='<s:property value="#androidProduct.productSmallImage"/>' class="circle" data-toggle="lightbox"><i class="iconfont-search"></i></a>
													</li>		 										
												</ul>												
											</div>
										</div>
										<div class="entry-main">
											<h5 class="entry-title">
												<%-- <a href="#"><s:property value="#womenProduct.productName"/></a> --%>
												<s:a action="Product!selectById">
													<s:property value="#androidProduct.productName"/>
													<s:param name="product.productId" value='#androidProduct.productId'></s:param>
												</s:a>
											</h5>
											<div class="entry-price">
												<strong class="accent-color price">¥ <s:property value="#androidProduct.productPrice"/></strong>
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
			<!-- // FEATURED PRODUCTS -->
			
			<!-- NEW ARRIVAL PRODUCTS -->
			<section class="section new-arrivals visible-items-5">
				<div class="container">
					<div class="row">
						<header class="section-header clearfix col-sm-offset-3 col-sm-6">
							<h3 class="section-title"><s:text name="index.menu2"></s:text></h3>
							<!-- <p class="section-teaser">Lorem ipsum dolor sit amet, consectetur adipiscing elit ac lobortis lacus</p> -->
						</header>
						
						<div class="clearfix"></div>
						
						<!-- BEGIN CAROUSEL -->
						<div id="new-arrivals-products" class="add-cart" data-product=".product" data-thumbnail=".entry-media .thumb" data-title=".entry-title > a" data-url=".entry-title > a" data-price=".entry-price > .price">
						
							<div class="owl-controls clickable outside">
								<div class="owl-buttons">
									<div class="owl-prev"><i class="iconfont-angle-left"></i></div>
									<div class="owl-next"><i class="iconfont-angle-right"></i></div>
								</div>
							</div>
							<div class="owl-carousel owl-theme" data-visible-items="4" data-navigation="true" data-lazyload="true">
							<s:iterator value="appleList" var="appleProduct" status="loop">
									<div class="product" data-product-id='<s:property value="#loop.count" />' >
										<div class="entry-media">
											<img data-src='<s:property value="#appleProduct.productSmallImage"/>' alt="" class="lazyOwl thumb" />
											<div class="hover">
												<!-- <a href="Product!selectById" class="entry-url"></a> -->
												<s:a action="Product!selectById" cssClass="entry-url">
													<s:param name="product.productId" value='#appleProduct.productId'></s:param>
												</s:a>
												<ul class="icons unstyled">													
													<li>
														<a href='<s:property value="#appleProduct.productSmallImage"/>' class="circle" data-toggle="lightbox"><i class="iconfont-search"></i></a>
													</li>													
												</ul>												
											</div>
										</div>
										<div class="entry-main">
											<h5 class="entry-title">
												<%-- <a href="#"><s:property value="#menProduct.productName"/></a> --%>
												<s:a action="Product!selectById">
													<s:property value="#appleProduct.productName"/>
													<s:param name="product.productId" value='#appleProduct.productId'></s:param>
												</s:a>
											</h5>
											<div class="entry-price">
												<strong class="accent-color price">¥ <s:property value="#appleProduct.productPrice"/></strong>
											</div>											
										</div>
									</div>
								</s:iterator>
							
						</div>
						<!-- // END CAROUSEL -->
						
					</div>
				</div>
			</div>
			</section>
			<!-- // NEW ARRIVAL PRODUCTS -->
			
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
	<script src="js/owl.carousel.js"></script>
	<script src="js/jquery.flexslider-min.js"></script>
	<!-- // Particular Page Javascripts -->
</body>
</html>