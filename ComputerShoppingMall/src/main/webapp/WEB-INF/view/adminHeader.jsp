<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="topbar clearfix">
	<div class="container">
		<div class="col-lg-10 text-right">
			<div class="social_buttons">
				<c:choose>
					<c:when test="${sessionAdminId == null}">
						<a href="${pageContext.request.contextPath}/LoginController"
							data-toggle="tooltip" data-placement="bottom">Login</a>
					</c:when>
					<c:otherwise>
						<a href="${pageContext.request.contextPath}/logoutController"
							data-toggle="tooltip" data-placement="bottom">Loginout</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<div class="col-lg-1 text-right"></div>
		<div class="social_buttons">
			<a href="${pagecontext.request.contextPath}/SelectMemberOneController"
				data-toggle="tooltip" data-placement="bottom">${sessionAdminId}</a>
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
					<a href="index.jsp" title="">
						<h4>
							MAXI<span>BIZ</span>
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
							<li class="active"><a href="#">Pages</a>
								<ul class="dropdown">
									<li><a href="Controller404">404 Error</a></li>
									<li><a href="leftSidebarController">Left Sidebar</a></li>
									<li><a href="LoginController">Login</a></li>
									<li><a href="RegisterController">Register</a></li>
									<li><a href="QnaListController">QNA</a></li>
								</ul>
							</li>
							<li><a href="#">Shop</a>
								<ul class="dropdown">
									<li><a href="DigitalDownloadController">Products Page</a></li>
									<li><a href="SingleProductController">Single Product</a></li>
									<li><a href="CheckoutController">Checkout</a></li>
									<li><a href="AccountController">Account Page</a></li>
									<li><a href="SupportController">Support Center</a></li>
								</ul>
							</li>
							<li><a href="#">Portfolio</a>
								<ul class="dropdown">
									<li><a href="PortfolioController">Portfolio (2 Columns)</a></li>
									<li><a href="PortfolioController">Portfolio (3 Columns)</a></li>
								</ul>
							</li>
							<li><a href="#">Blog</a>
								<ul class="dropdown">
									<li><a href="single-with-sidebarController">Single with Sidebar</a></li>
								</ul>
							</li>
							<li><a href="#">ProductInsert</a>
								<ul class="dropdown">
									<li><a href="InsertCaseController">InsertCase</a></li>
									<li><a href="InsertCoolerController">InsertCooler</a></li>
									<li><a href="InsertCpuController">InsertCpu</a></li>
									<li><a href="InsertGpuController">InsertGpu</a></li>
									<li><a href="InsertMainboardController">InsertMainBoard</a></li>
									<li><a href="InsertPowerController">InsertPower</a></li>
									<li><a href="InsertRamController">InsertRam</a></li>
									<li><a href="InsertStorageController">InsertStorage</a></li>
								</ul>
							</li>
							<li><a href="#">ProductUpdate</a>
								<ul class="dropdown">
									<li><a href="UpdateCaseController">UpdateCase</a></li>
									<li><a href="UpdateCoolerController">UpdateCooler</a></li>
									<li><a href="UpdateCpuController">UpdateCpu</a></li>
									<li><a href="UpdateGpuController">UpdateGpu</a></li>
									<li><a href="UpdateMainboardController">UpdateMainBoard</a></li>
									<li><a href="UpdatePowerController">UpdatePower</a></li>
									<li><a href="UpdateRamController">UpdateRam</a></li>
									<li><a href="UpdateStorageController">UpdateStorage</a></li>
								</ul>
							</li>
							<li><a href="#">ProductDelete</a>
								<ul class="dropdown">
									<li><a href="DeleteCaseController">DeleteCase</a></li>
									<li><a href="DeleteCoolerController">DeleteCooler</a></li>
									<li><a href="DeleteCpuController">DeleteCpu</a></li>
									<li><a href="DeleteGpuController">DeleteGpu</a></li>
									<li><a href="DeleteMainboardController">DeleteMainBoard</a></li>
									<li><a href="DeletePowerController">DeletePower</a></li>
									<li><a href="DeleteRamController">DeleteRam</a></li>
									<li><a href="DeleteStorageController">DeleteStorage</a></li>
								</ul>
							</li>
							<li><a href="#">Qna</a>
								<ul class="dropdown">
									<li><a href="AdminQnaListController">AdminQnaListController</a></li>
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