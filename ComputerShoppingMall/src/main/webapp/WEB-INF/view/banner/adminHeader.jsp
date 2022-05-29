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
							Com<span>Velvet</span>
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
							<li><a href="#">상품 관리</a>
		                        <ul class="dropdown">
		                          	<li><a href="${pageContext.request.contextPath}/CpuListController">CPU</a></li>
									<li><a href="${pageContext.request.contextPath}/MainboardListController">메인보드</a></li>
									<li><a href="${pageContext.request.contextPath}/RamListController">RAM</a></li>
									<li><a href="${pageContext.request.contextPath}/GpuListController">그래픽카드</a></li>
									<li><a href="${pageContext.request.contextPath}/StorageListController">SSD/HDD</a></li>
									<li><a href="${pageContext.request.contextPath}/CaseListController">케이스</a></li>
									<li><a href="${pageContext.request.contextPath}/PowerListController">파워</a></li>
									<li><a href="${pageContext.request.contextPath}/CoolerListController">쿨러</a></li>
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
							<li><a href="#">주문 확인</a>
								<ul class="dropdown">
									<li><a href="${pageContext.request.contextPath}/AdminOrderListController">주문 내역</a></li>
									<li><a href="${pageContext.request.contextPath}/AdminOrderListController?updateCheck=true">취소/교환/환불 내역</a></li>
								</ul>
							</li>
							<li><a href="#">Q&A</a>
								<ul class="dropdown">
									<li><a href="${pageContext.request.contextPath}/AdminQnaListController">Q&A 관리</a></li>
								</ul>
							</li>
							<li><a href="#">고객 관리</a>
								<ul class="dropdown">
									<li><a href="${pageContext.request.contextPath}/AdminCustomerListController">고객 정보 조회</a></li>
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