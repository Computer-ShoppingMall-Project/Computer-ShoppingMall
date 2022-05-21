<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="topbar clearfix">
	<div class="container">
		<div class="col-lg-10 text-right">
			<div class="social_buttons">
				<c:choose>
					<c:when test="${sessionAdminId == null}">
						<a href="${pageContext.request.contextPath}/LoginController" data-toggle="tooltip" data-placement="bottom">로그인</a>
					</c:when>
					<c:otherwise>
						<a href="${pageContext.request.contextPath}/LogoutController" data-toggle="tooltip" data-placement="bottom">로그아웃</a>
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
							<li><a href="${pageContext.request.contextPath}/IndexController">홈</a></li>
							<li class="active"><a href="#">로그인</a>
								<ul class="dropdown">
									<li>
									<c:choose>
										<c:when test="${sessionAdminId == null}">
											<a href="${pageContext.request.contextPath}/LoginController" data-toggle="tooltip" data-placement="bottom">로그인</a>
										</c:when>
										<c:otherwise>
											<a href="${pageContext.request.contextPath}/LogoutController" data-toggle="tooltip" data-placement="bottom">로그아웃</a>
										</c:otherwise>
									</c:choose>
									</li>
								</ul>
							</li>
							<li><a href="#">ProductList</a>
		                        <ul class="dropdown">
		                           <li><a href="${pageContext.request.contextPath}/CpuListController">Cpu List</a></li>
		                           <li><a href="${pageContext.request.contextPath}/GpuListController">Gpu List</a></li>
		                           <li><a href="${pageContext.request.contextPath}/MainboardListController">Mainboard List</a></li>
		                           <li><a href="${pageContext.request.contextPath}/CaseListController">Case List</a></li>
		                           <li><a href="${pageContext.request.contextPath}/RamListController">Ram List</a></li>
		                           <li><a href="${pageContext.request.contextPath}/CoolerListController">Cooler List</a></li>
		                           <li><a href="${pageContext.request.contextPath}/PowerListController">Power List</a></li>
		                           <li><a href="${pageContext.request.contextPath}/StorageListController">Storage List</a></li>
		                        </ul>
		                    </li>
							<li><a href="#">상품</a>
								<ul class="dropdown">
									<li><a href="${pageContext.request.contextPath}/DigitalDownloadController">상품</a></li>
									<li><a href="${pageContext.request.contextPath}/CheckoutController">결제</a></li>
									<li><a href="${pageContext.request.contextPath}/AccountController">계정</a></li>
									<li><a href="${pageContext.request.contextPath}/SupportController">고객센터</a></li>
								</ul>
							</li>
							<li><a href="#">제품추가</a>
								<ul class="dropdown">
									<li><a href="${pageContext.request.contextPath}/InsertCaseController">케이스 등록</a></li>
									<li><a href="${pageContext.request.contextPath}/InsertCoolerController">쿨러 등록</a></li>
									<li><a href="${pageContext.request.contextPath}/InsertCpuController">씨피유 등록</a></li>
									<li><a href="${pageContext.request.contextPath}/InsertGpuController">그래픽카드 등록</a></li>
									<li><a href="${pageContext.request.contextPath}/InsertMainboardController">메인보드 등록</a></li>
									<li><a href="${pageContext.request.contextPath}/InsertPowerController">파워 등록</a></li>
									<li><a href="${pageContext.request.contextPath}/InsertRamController">램 등록</a></li>
									<li><a href="${pageContext.request.contextPath}/InsertStorageController">저장소 등록</a></li>
								</ul>
							</li>
							<li><a href="#">제품갱신</a>
								<ul class="dropdown">
									<li><a href="${pageContext.request.contextPath}/UpdateCaseController">케이스 수정</a></li>
									<li><a href="${pageContext.request.contextPath}/UpdateCoolerController">쿨러 수정</a></li>
									<li><a href="${pageContext.request.contextPath}/UpdateCpuController">씨피유 수정</a></li>
									<li><a href="${pageContext.request.contextPath}/UpdateGpuController">그래픽카드 수정</a></li>
									<li><a href="${pageContext.request.contextPath}/UpdateMainboardController">메인보드 수정</a></li>
									<li><a href="${pageContext.request.contextPath}/UpdatePowerController">파워 수정</a></li>
									<li><a href="${pageContext.request.contextPath}/UpdateRamController">램 수정</a></li>
									<li><a href="${pageContext.request.contextPath}/UpdateStorageController">저장소 수정</a></li>
								</ul>
							</li>
							<li><a href="#">제품삭제</a>
								<ul class="dropdown">
									<li><a href="${pageContext.request.contextPath}/DeleteCaseController">케이스 삭제</a></li>
									<li><a href="${pageContext.request.contextPath}/DeleteCoolerController">쿨러 삭제</a></li>
									<li><a href="${pageContext.request.contextPath}/DeleteCpuController">씨피유 삭제</a></li>
									<li><a href="${pageContext.request.contextPath}/DeleteGpuController">그래픽카드 삭제</a></li>
									<li><a href="${pageContext.request.contextPath}/DeleteMainboardController">메인보드 삭제</a></li>
									<li><a href="${pageContext.request.contextPath}/DeletePowerController">파워 삭제</a></li>
									<li><a href="${pageContext.request.contextPath}/DeleteRamController">램 삭제</a></li>
									<li><a href="${pageContext.request.contextPath}/DeleteStorageController">저장소 삭제</a></li>
								</ul>
							</li>
							<li><a href="#">Q&A</a>
								<ul class="dropdown">
									<li><a href="${pageContext.request.contextPath}/AdminQnaListController">Q&A 관리</a></li>
									<li><a href="${pageContext.request.contextPath}/QnaListController">Q&A 리스트</a></li>
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