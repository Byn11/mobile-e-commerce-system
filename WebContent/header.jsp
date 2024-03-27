		<!-- HEADER TOP -->
		<div class="header-top">
			<div class="container">
				<div class="row">
					<div class="col-xs-12 col-sm-6 col-md-7">
						<!-- CONTACT INFO -->
						<div class="contact-info">
							<i class="iconfont-headphones round-icon"></i>
							<strong><s:text name="title.name"></s:text></strong>
							<span><s:text name="title.text"></s:text></span>
							</div>
						<!-- // CONTACT INFO -->
					</div>
					<div class="col-xs-12 col-sm-6 col-md-5">
						<ul class="actions unstyled clearfix">
							<li>
								<!-- SEARCH BOX -->
								<!-- <div class="search-box">
									<form action="#" method="post">
										<div class="input-iconed prepend">
											<button class="input-icon"><i class="iconfont-search"></i></button>
											<input type="text" name="q" id="input-search" class="round-input full-width" required />
										</div>
									</form>
								</div> -->
								<!-- // SEARCH BOX -->
							</li>
							<li data-toggle="sub-header" data-target="#sub-social">
								
							</li>
							<li data-toggle="sub-header" data-target="#sub-cart">
								<!-- SHOPPING CART -->
								<s:if test="#session.login_success != null">
									<a href="product/Product!showCart" id="total-cart">
										<i class="iconfont-shopping-cart round-icon"></i>
									</a>
								</s:if>
								
								<!-- // SHOPPING CART -->
							</li>
						</ul>
					</div>
				</div>
			</div>
			
			<!-- ADD TO CART MESSAGE -->
			<div class="cart-notification">
				<ul class="unstyled"></ul>
			</div>
			<!-- // ADD TO CART MESSAGE -->
		</div>
		<!-- // HEADER TOP -->
		<!-- MAIN HEADER -->
		<div class="main-header-wrapper">
			<div class="container">
				<div class="main-header">
					<!-- CURRENCY / LANGUAGE / USER MENU -->
					<div class="actions">
						<div class="center-xs">
							
							<!-- LANGUAGES -->
							<ul class="option-list unstyled">
								<li class="active"><a href="Language?request_locale=en_US" data-toggle="tooltip" title="English"><s:text name="header.language.en"></s:text></a></li>
								<li><a href="Language?request_locale=zh_CN" data-toggle="tooltip" title="French"><s:text name="header.language.cn"></s:text></a></li>
							</ul>
							<!-- // LANGUAGES -->
						</div>
						<div class="clearfix"></div>
						<!-- USER RELATED MENU -->
						<nav id="tiny-menu" class="clearfix">
							<ul class="user-menu">	
							 <s:if test="#session.login_success != null">													
								<li><a href="user/User!logout"><s:text name="header.user"></s:text>${session.login_success.userName}&nbsp;&nbsp;&nbsp;<s:text name="header.logout"></s:text></a></li>
							</s:if>
							<s:else>
								<li><a href="login.jsp"><s:text name="header.login"></s:text></a></li>
							</s:else> 
							</ul>
						</nav>
						<!-- // USER RELATED MENU -->
					</div>
					<!-- // CURRENCY / LANGUAGE / USER MENU -->
					<!-- SITE LOGO -->
					<div class="logo-wrapper">
						<a href="index.jsp" class="logo" title="GFashion - Responsive e-commerce HTML Template">
							<img src="img/logo.png" alt="GFashion - Responsive e-commerce HTML Template" />
						</a>
					</div>
					<!-- // SITE LOGO -->
					<!-- SITE NAVIGATION MENU -->
					<nav id="site-menu" role="navigation">
						<ul class="main-menu hidden-sm hidden-xs">
							<s:if test="menuId==null">
								<li class="active">
									<a href="index.jsp"><s:text name="header.menu1"></s:text></a>
								</li>
							</s:if>
							<s:else>
								<li>
									<a href="index.jsp"><s:text name="header.menu1"></s:text></a>
								</li>
							</s:else>
							<s:if test="menuId==1">
								<li class="active">
									<a href="product/Product!selectPage?menuId=1"><s:text name="header.menu2"></s:text></a>
								</li>
							</s:if>
							<s:else>
								<li>
									<a href="product/Product!selectPage?menuId=1"><s:text name="header.menu2"></s:text></a>
								</li>
							</s:else>
							<s:if test="menuId==2">
								<li class="active">
									<a href="product/Product!selectPage?menuId=2"><s:text name="header.menu3"></s:text></a>
								</li>
							</s:if>	
							<s:else>
								<li>
									<a href="product/Product!selectPage?menuId=2"><s:text name="header.menu3"></s:text></a>
								</li>
							</s:else>	
							<s:if test="menuId==3">	
								<li class="active">
									<a href="message/Message!selectAll?menuId=3"><s:text name="header.menu4"></s:text></a>
								</li>
							</s:if>	
							<s:else>
								<li>
									<a href="message/Message!selectAll?menuId=3"><s:text name="header.menu4"></s:text></a>
								</li>	
							</s:else>
						</ul>						
						
					</nav>
					<!-- // SITE NAVIGATION MENU -->
				</div>
			</div>
		</div>
		<!-- // MAIN HEADER -->