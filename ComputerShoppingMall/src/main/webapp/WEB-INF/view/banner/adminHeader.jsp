<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="topbar clearfix">
	<div class="container">
		<div class="col-lg-10 text-right">
			<div class="social_buttons">
				<div class="social_buttons text-right text-align-center">
					<a href="#" data-toggle="tooltip" data-placement="bottom"  style=" vertical-align: middle;">관리자&nbsp;[${sessionAdminId}]</a>
					<c:choose>
						<c:when test="${sessionAdminId == null}"> 
							<a href="${pageContext.request.contextPath}/LoginController" data-toggle="tooltip" data-placement="bottom" class="btn">Login</a>
						</c:when>
						<c:otherwise>
							<a href="${pageContext.request.contextPath}/LogoutController" data-toggle="tooltip" data-placement="bottom" class="btn">Logout</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
		<div class="col-lg-1 text-right"></div>
		<!-- end container -->
	</div>
</div>
<!-- end topbar -->
<header class="header">
	<div class="container">
		<div class="site-header clearfix">
			<div class="col-lg-3 col-md-3 col-sm-14 title-area">
				<div class="site-title" id="title">
					<a href="${pageContext.request.contextPath}/IndexController" title="">
						<h4>
							<span><img src="${pageContext.request.contextPath}/img/logo.png" width="30" height="30"></span>
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
							<li><a href="${pageContext.request.contextPath}/IndexController">홈</a></li>
							<li><a href="#">조립PC</a>
		                        <ul class="dropdown">
		                           <li><a href="${pageContext.request.contextPath}/AdminCpuListController">CPU</a></li>
		                           <li><a href="${pageContext.request.contextPath}/AdminMainboardListController">메인보드</a></li>
		                           <li><a href="${pageContext.request.contextPath}/AdminRamListController">RAM</a></li>
		                           <li><a href="${pageContext.request.contextPath}/AdminGpuListController">그래픽카드</a></li>
		                           <li><a href="${pageContext.request.contextPath}/AdminStorageListController">SSD/HDD</a></li>
		                           <li><a href="${pageContext.request.contextPath}/AdminCaseListController">케이스</a></li>
		                           <li><a href="${pageContext.request.contextPath}/AdminPowerListController">파워</a></li>
		                           <li><a href="${pageContext.request.contextPath}/AdminCoolerListController">쿨러</a></li>
		                        </ul>
		                    </li>
							<li><a href="#">상품 등록</a>
								<ul class="dropdown">
									<li><a href="${pageContext.request.contextPath}/InsertCpuController">CPU 등록</a></li>
									<li><a href="${pageContext.request.contextPath}/InsertMainboardController">메인보드 등록</a></li>
									<li><a href="${pageContext.request.contextPath}/InsertRamController">RAM 등록</a></li>
									<li><a href="${pageContext.request.contextPath}/InsertGpuController">그래픽카드 등록</a></li>
									<li><a href="${pageContext.request.contextPath}/InsertStorageController">SSD/HDD 등록</a></li>
									<li><a href="${pageContext.request.contextPath}/InsertCaseController">케이스 등록</a></li>
									<li><a href="${pageContext.request.contextPath}/InsertPowerController">파워 등록</a></li>
									<li><a href="${pageContext.request.contextPath}/InsertCoolerController">쿨러 등록</a></li>
								</ul>
							</li>
							<li><a href="#">상품 수정</a>
								<ul class="dropdown">
									<li><a href="${pageContext.request.contextPath}/UpdateCpuController">CPU 수정</a></li>
									<li><a href="${pageContext.request.contextPath}/UpdateMainboardController">메인보드 수정</a></li>
									<li><a href="${pageContext.request.contextPath}/UpdateRamController">RAM 수정</a></li>
									<li><a href="${pageContext.request.contextPath}/UpdateGpuController">그래픽카드 수정</a></li>
									<li><a href="${pageContext.request.contextPath}/UpdateStorageController">SSD/HDD 수정</a></li>
									<li><a href="${pageContext.request.contextPath}/UpdateCaseController">케이스 수정</a></li>
									<li><a href="${pageContext.request.contextPath}/UpdatePowerController">파워 수정</a></li>
									<li><a href="${pageContext.request.contextPath}/UpdateCoolerController">쿨러 수정</a></li>
								</ul>
							</li>
							<li><a href="#">상품 삭제</a>
								<ul class="dropdown">
									<li><a href="${pageContext.request.contextPath}/DeleteCpuController">CPU 삭제</a></li>
									<li><a href="${pageContext.request.contextPath}/DeleteMainboardController">메인보드 삭제</a></li>
									<li><a href="${pageContext.request.contextPath}/DeleteRamController">RAM 삭제</a></li>
									<li><a href="${pageContext.request.contextPath}/DeleteGpuController">그래픽카드 삭제</a></li>
									<li><a href="${pageContext.request.contextPath}/DeleteStorageController">SSD/HDD 삭제</a></li>
									<li><a href="${pageContext.request.contextPath}/DeleteCaseController">케이스 삭제</a></li>
									<li><a href="${pageContext.request.contextPath}/DeletePowerController">파워 삭제</a></li>
									<li><a href="${pageContext.request.contextPath}/DeleteCoolerController">쿨러 삭제</a></li>
								</ul>
							</li>
							<li><a href="#">주문</a>
								<ul class="dropdown">
									<li><a href="${pageContext.request.contextPath}/AdminOrderListController">주문 내역</a></li>
									<li><a href="${pageContext.request.contextPath}/DigitalDownloadController">상품</a></li>
									<li><a href="${pageContext.request.contextPath}/CheckoutController">결제</a></li>
									<li><a href="${pageContext.request.contextPath}/AccountController">계정</a></li>
									<li><a href="${pageContext.request.contextPath}/SupportController">고객센터</a></li>
								</ul>
							</li>
							<li><a href="#">Q&A</a>
								<ul class="dropdown">
									<li><a href="${pageContext.request.contextPath}/AdminQnaListController">Q&A 관리</a></li>
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