<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="topbar clearfix">
	<div class="container">
		<div class="col-lg-10 text-right">
			<div class="social_buttons">
				<c:choose>
					<c:when test="${sessionAdminId == null}">
						<a href="${pageContext.request.contextPath}/LoginController" data-toggle="tooltip" data-placement="bottom">Login</a>
					</c:when>
					<c:otherwise>
						<a href="${pageContext.request.contextPath}/logoutController" data-toggle="tooltip" data-placement="bottom">Loginout</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<div class="col-lg-1 text-right"></div>
		<div class="social_buttons">
			<a href="${pagecontext.request.contextPath}/SelectMemberOneController" data-toggle="tooltip" data-placement="bottom">${sessionAdminId}</a>
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
					<a href="${pageContext.request.contextPath}/index.jsp" title="">
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
							<li class="active"><a href="#">Pages</a>
								<ul class="dropdown">
									<li><a href="${pageContext.request.contextPath}/Controller404">404 Error</a></li>
									<li><a href="${pageContext.request.contextPath}/leftSidebarController">Left Sidebar</a></li>
									<li><a href="${pageContext.request.contextPath}/LoginController">Login</a></li>
									<li><a href="${pageContext.request.contextPath}/RegisterController">Register</a></li>
									<li><a href="${pageContext.request.contextPath}/QnaListController">QNA</a></li>
								</ul>
							</li>
							<li><a href="#">Shop</a>
								<ul class="dropdown">
									<li><a href="${pageContext.request.contextPath}/DigitalDownloadController">Products Page</a></li>
									<li><a href="${pageContext.request.contextPath}/SingleProductController">Single Product</a></li>
									<li><a href="${pageContext.request.contextPath}/CheckoutController">Checkout</a></li>
									<li><a href="${pageContext.request.contextPath}/AccountController">Account Page</a></li>
									<li><a href="${pageContext.request.contextPath}/SupportController">Support Center</a></li>
								</ul>
							</li>
							<li><a href="#">Portfolio</a>
								<ul class="dropdown">
									<li><a href="${pageContext.request.contextPath}/PortfolioController">Portfolio (2 Columns)</a></li>
									<li><a href="${pageContext.request.contextPath}/PortfolioController">Portfolio (3 Columns)</a></li>
								</ul>
							</li>
							<li><a href="#">Blog</a>
								<ul class="dropdown">
									<li><a href="${pageContext.request.contextPath}/single-with-sidebarController">Single with Sidebar</a></li>
								</ul>
							</li>
							<li><a href="#">ProductInsert</a>
								<ul class="dropdown">
									<li><a href="${pageContext.request.contextPath}/InsertCaseController">InsertCase</a></li>
									<li><a href="${pageContext.request.contextPath}/InsertCoolerController">InsertCooler</a></li>
									<li><a href="${pageContext.request.contextPath}/InsertCpuController">InsertCpu</a></li>
									<li><a href="${pageContext.request.contextPath}/InsertGpuController">InsertGpu</a></li>
									<li><a href="${pageContext.request.contextPath}/InsertMainboardController">InsertMainBoard</a></li>
									<li><a href="${pageContext.request.contextPath}/InsertPowerController">InsertPower</a></li>
									<li><a href="${pageContext.request.contextPath}/InsertRamController">InsertRam</a></li>
									<li><a href="${pageContext.request.contextPath}/InsertStorageController">InsertStorage</a></li>
								</ul>
							</li>
							<li><a href="#">ProductUpdate</a>
								<ul class="dropdown">
									<li><a href="${pageContext.request.contextPath}/UpdateCaseController">UpdateCase</a></li>
									<li><a href="${pageContext.request.contextPath}/UpdateCoolerController">UpdateCooler</a></li>
									<li><a href="${pageContext.request.contextPath}/UpdateCpuController">UpdateCpu</a></li>
									<li><a href="${pageContext.request.contextPath}/UpdateGpuController">UpdateGpu</a></li>
									<li><a href="${pageContext.request.contextPath}/UpdateMainboardController">UpdateMainBoard</a></li>
									<li><a href="${pageContext.request.contextPath}/UpdatePowerController">UpdatePower</a></li>
									<li><a href="${pageContext.request.contextPath}/UpdateRamController">UpdateRam</a></li>
									<li><a href="${pageContext.request.contextPath}/UpdateStorageController">UpdateStorage</a></li>
								</ul>
							</li>
							<li><a href="#">ProductDelete</a>
								<ul class="dropdown">
									<li><a href="${pageContext.request.contextPath}/DeleteCaseController">DeleteCase</a></li>
									<li><a href="${pageContext.request.contextPath}/DeleteCoolerController">DeleteCooler</a></li>
									<li><a href="${pageContext.request.contextPath}/DeleteCpuController">DeleteCpu</a></li>
									<li><a href="${pageContext.request.contextPath}/DeleteGpuController">DeleteGpu</a></li>
									<li><a href="${pageContext.request.contextPath}/DeleteMainboardController">DeleteMainBoard</a></li>
									<li><a href="${pageContext.request.contextPath}/DeletePowerController">DeletePower</a></li>
									<li><a href="${pageContext.request.contextPath}/DeleteRamController">DeleteRam</a></li>
									<li><a href="${pageContext.request.contextPath}/DeleteStorageController">DeleteStorage</a></li>
								</ul>
							</li>
							<li><a href="#">Qna</a>
								<ul class="dropdown">
									<li><a href="${pageContext.request.contextPath}/AdminQnaListController">AdminQnaListController</a></li>
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