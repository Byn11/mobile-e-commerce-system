<%@include file="top.jsp" %>
<body>
			
	<!-- PAGE WRAPPER -->
<div id="page-wrapper">

	<!-- SITE HEADER -->
	<header id="site-header" role="banner">
		<%@include file="header.jsp" %>
		<script type="text/javascript" src="js/user_validate.js"></script> 
	</header>
	<!-- // SITE HEADER -->
	
		<!-- BREADCRUMB -->
		<div class="breadcrumb-container">
			<div class="container">
				<div class="relative">
					<ul class="bc unstyled clearfix">
						<li><a href="index.jsp">Home</a></li>
						<li class="active">Login</li>
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
							<section class="side-section">
								<h3 class="uppercase text-bold"><span class="text-xs">Usefull Pages</span></h3>
								
								<ul class="nav nav-tabs nav-stacked">
									<li><a href="index.jsp">Homepage</a></li>																													
									<li><a href="product/Product!selectPage?menuId=1">Android</a></li>	
									<li><a href="product/Product!selectPage?menuId=2">Apple</a></li>																														
									<li><a href="message/Message!selectAll?menuId=3">Contact us</a></li>															
								</ul>
							</section>
								
							<!-- PROMO -->
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
						</aside>
						<!-- // SIDEBAR -->
						
						<section class="col-xs-12 col-sm-8 col-md-9">
							<div class="panel-group checkout" id="checkout-collapse">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#checkout-collapse" href="#checkout-collapse1">
												<span class="step">01</span>
												Login Infomation
											</a>
										</h4>
									</div>
									<div id="checkout-collapse1" class="panel-collapse collapse in">
										<div class="panel-body">
											<div class="row">												
												<div class="space40 visible-xs"></div>
												<div class="col-xs-12 col-sm-6">
													<form class="form-horizontal" action="user/User!login" method="post">
														<fieldset>
															<legend class="title">Login</legend>
															<div class="inner">
																<p>Please enter</p>
																<div class="form-login">
																	<div class="form-group stylish-input">
																		<label for="inputEmail" class="col-xs-12 col-sm-3 control-label required">Name</label>
																		<div class="col-lg-7">
																			<s:textfield name="userMsgDTO.userName" cssClass="form-control"></s:textfield>
																		</div>
																	</div>
																	<div class="form-group stylish-input">
																		<label for="inputPassword" class="col-xs-12 col-sm-3 control-label required">Password</label>
																		<div class="col-lg-7">
																			<s:password name="userMsgDTO.userPassword" cssClass="form-control"></s:password>
																			<a href="error1.jsp" class="help-block"><s:text name="login.forget"></s:text></a>
																		</div>
																	</div>
																</div>
																<button class="btn btn-primary btn-round padder">Login</button>
															</div>
														</fieldset>
													</form>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#checkout-collapse" href="#checkout-collapse2">
												<span class="step">02</span>
												Register Infomation
											</a>
										</h4>
									</div>
									<div id="checkout-collapse2" class="panel-collapse collapse">
										<div class="panel-body">
											<form action="user/User!register?userMsgDTO.powerId=1" method="post" class="form-horizontal" role="form">
												<div class="row">
													<div class="col-xs-12 col-sm-12 col-md-6">
														<div class="form-group stylish-input">
															<label for="inputFirstname" class="col-sm-4 col-lg-4 control-label required">Name</label>
															<div class="col-sm-8 col-lg-8">
																<!-- <input type="text" class="form-control" id="inputFirstname" /> -->
																<s:textfield name="userMsgDTO.userName" cssClass="form-control" id="userName"></s:textfield>
															</div>
														</div>
														<div class="form-group stylish-input">
															<label for="inputFirstname" class="col-sm-4 col-lg-4 control-label required">Password 1</label>
															<div class="col-sm-8 col-lg-8">
																<s:password name="userMsgDTO.userPassword" cssClass="form-control" id="password"></s:password>
															</div>
														</div>														
														<div class="form-group stylish-input">
															<label for="inputEmail2" class="col-sm-4 col-lg-4 control-label required">E-Mail</label>
															<div class="col-sm-8 col-lg-8">
																<s:textfield name="userMsgDTO.userEmail" cssClass="form-control" id="user_email"></s:textfield>
															</div>
														</div>
														<div class="form-group stylish-input">
															<label for="inputPhone" class="col-sm-4 col-lg-4 control-label required">Telephone</label>
															<div class="col-sm-8 col-lg-8">
																<s:textfield name="userMsgDTO.userTelephone" cssClass="form-control" id="user_telephone"></s:textfield>
															</div>
														</div>
													</div>
													<div class="col-xs-12 col-sm-12 col-md-6">
														<div class="form-group stylish-input">
															<label for="inputAddress1" class="col-sm-4 col-lg-4 control-label required">Address 1</label>
															<div class="col-sm-8 col-lg-8">
																<s:textfield name="userMsgDTO.userAddress" cssClass="form-control" id="user_address"></s:textfield>
															</div>
														</div>
														<div class="form-group stylish-input">
															<label for="inputFirstname" class="col-sm-4 col-lg-4 control-label required">Password 2</label>
															<div class="col-sm-8 col-lg-8">
																<input type="password" class="form-control" id="password2" />
															</div>
														</div>														
														<div class="form-group stylish-input">
															<label for="inputCity" class="col-sm-4 col-lg-4 control-label required">Birthday</label>
															<div class="col-sm-8 col-lg-8">
																<s:textfield name="userMsgDTO.userBirthday" cssClass="form-control" id="user_birthday"></s:textfield>
															</div>
														</div>
														<div class="form-group stylish-input">
															<label for="inputPostcode" class="col-sm-4 col-lg-4 control-label required">Post Code</label>
															<div class="col-sm-8 col-lg-8">
																<s:textfield name="userMsgDTO.userPostcode" cssClass="form-control" id="user_postcode"></s:textfield>
															</div>
														</div>														
													</div>
												</div>
												<div class="space20 clearfix"></div>
												<button type="submit" class="btn btn-primary" onclick="return f1();">Register</button>
											</form>
										</div>
									</div>
								</div>								
							</div>
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
<script src="js/products.js"></script>
<!-- // Particular Page Javascripts -->
${requestScope.login_error}

</body>
</html>