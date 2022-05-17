<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="topbar clearfix">
	<div class="container">
		<div class="col-lg-10 text-right">
			<div class="social_buttons">
				<c:choose>
					<c:when test="${sessionCustomerId == null}">
						<a href="${pageContext.request.contextPath}/LoginController"
							data-toggle="tooltip" data-placement="bottom">Login</a>
					</c:when>
					<c:otherwise>
						<a href="${pageContext.request.contextPath}/LogoutController"
							data-toggle="tooltip" data-placement="bottom">Logout</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<div class="col-lg-1 text-right"></div>
		<div class="social_buttons">
			<a href="${pageContext.request.contextPath}/SelectMemberOneController"
				data-toggle="tooltip" data-placement="bottom">${sessionCustomerId}</a>
		</div>
		<!-- end container -->
	</div>
</div>
<!-- end topbar -->
<header class="header">
	<div class="container">
		<div class="site-header clearfix">
			<div class="col-lg-3 col-md-3 col-sm-14 title-area">
				<div class="site-title" id="title">
					<a href="IndexController" title="">
						<h4>
							Red<span>Velvet</span>
						</h4>
					</a>
				</div>
			</div>
			<!-- title area -->
			<div class="col-lg-9 col-md-12 col-sm-12">
				<div id="nav" class="right">
					<div class="container clearfix">
						<ul id="jetmenu" class="jetmenu blue">
							<li><a href="IndexController">Home</a></li>
							<li><a href="#">Pages</a>
								<ul class="dropdown">
									<li><a href="Controller404">404 Error</a></li>
									<li><a href="leftSidebarController">Left Sidebar</a></li>
									<li>
									<c:choose>
										<c:when test="${sessionCustomerId == null}">
											<a href="${pageContext.request.contextPath}/LoginController">Login</a>
										</c:when>
										<c:otherwise>
											<a href="${pageContext.request.contextPath}/LogoutController">Logout</a>
										</c:otherwise>
									</c:choose>
									<li><a href="RegisterController">Register</a></li>
									<li><a href="QnaListController">QNA</a></li>
								</ul>
							</li>
							<li><a href="#">Shop</a>
								<ul class="dropdown">
									<li><a href="CpuListController">Products</a></li>
									<li><a href="SingleProductController">Single Product</a></li>
									<li><a href="CheckoutController">Checkout</a></li>
									<li><a href="AccountController">Account Page</a></li>
									<li><a href="SupportController">Support Center</a></li>
									<li><a href="${pageContext.request.contextPath}/MyBasketController">MyBasket</a></li>
								</ul>
							</li>
							<li><a href="#">Portfolio</a>
								<ul class="dropdown">
									<li><a href="PortfolioController">Portfolio (2Columns)</a></li>
									<li><a href="PortfolioController">Portfolio (3Columns)</a></li>
								</ul>
							</li>
							<li><a href="#">Blog</a>
								<ul class="dropdown">
									<li><a href="single-with-sidebarController">Single with Sidebar</a></li>
								</ul>
							</li>
						</ul>
					</div>
				</div>
				<!-- nav -->
			</div>
			<!-- title area -->
		</div>
		<!-- site header -->
	</div>
	<!-- end container -->
</header>
<!-- end header -->