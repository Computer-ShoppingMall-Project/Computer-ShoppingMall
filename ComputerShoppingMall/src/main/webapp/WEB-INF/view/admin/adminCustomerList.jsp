<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>RedVelvet</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Favicons -->
<link href="${pageContext.request.contextPath}/img/apple-touch-icon.png" rel="icon">
<link href="${pageContext.request.contextPath}/img/apple-touch-icon.png" rel="icon">

<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Ruda:400,900,700" rel="stylesheet">

<!-- Bootstrap CSS File -->
<link href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Libraries CSS Files -->
<link href="${pageContext.request.contextPath}/lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/lib/prettyphoto/css/prettyphoto.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/lib/hover/hoverex-all.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/lib/jetmenu/jetmenu.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/lib/owl-carousel/owl-carousel.css" rel="stylesheet">

<!-- Main Stylesheet File -->
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/colors/blue.css">

<!-- =======================================================
		Template Name: MaxiBiz
		Template URL: https://templatemag.com/maxibiz-bootstrap-business-template/
		Author: TemplateMag.com
		License: https://templatemag.com/license/
======================================================= -->
</head>
<body>
	<!-- header적용 -->
	<c:choose>
		<c:when test="${sessionAdminId != null}">
			<jsp:include page="/WEB-INF/view/banner/adminHeader.jsp"></jsp:include>
		</c:when>
		<c:otherwise>
			<jsp:include page="/WEB-INF/view/banner/header.jsp"></jsp:include>
		</c:otherwise>
	</c:choose>

	<section class="post-wrapper-top">
		<div class="container">
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<ul class="breadcrumb">
					<li><a href="${pageContext.request.contextPath}/IndexController">Home</a></li>
					<li>CUSTOMER LIST</li>
				</ul>
				<h2>CUSTOMER LIST</h2>
			</div>
		</div>
	</section>
	<!-- end post-wrapper-top -->
	<section class="section1">
		<div class="container clearfix">
			<div class="content col-lg-12 col-md-12 col-sm-12 col-xs-12 clearfix">
				<!-- ID 검색 / 고객 이름 검색 기능 -->
				<form method="post" action="${pageContext.request.contextPath}/AdminCustomerListController">
					<input type="hidden" name="active" value="${active}">
					<table class="table">
						<tr>
							<th style="text-align:center; vertical-align:middle;">ID 검색</th>
							<td class="col-xs-4"><input type="text" name="customerId" value="${customerId}" class="form-control" placeholder="고객 ID를 입력해주세요"></td>
							<th style="text-align:center; vertical-align:middle;">이름 검색</th>
							<td class="col-xs-4"><input type="text" name="name" value="${name}" class="form-control" placeholder="고객 이름을 입력해주세요"></td>
							<td>
								<button type="submit">검색</button>
							</td>
						</tr>
					</table>
				</form>
				<!-- 회원/탈퇴회원 분류해서 보기 -->
				<a href="${pageContext.request.contextPath}/AdminCustomerListController" class="btn btn-info">회원</a>
				<a href="${pageContext.request.contextPath}/AdminCustomerListController?active=1" class="btn btn-primary">탈퇴회원</a>
				<br><br>
				<table class="table" data-effect="fade">
					<thead class="bg-info">
						<tr>
							<th class="text-center">ID</th>
							<th class="text-center">이름</th>
							<th class="text-center">닉네임</th>
							<th class="text-center">이메일</th>
							<th class="text-center">연락처</th>
							<th class="text-center">우편번호</th>
							<th class="text-center">주소</th>
							<th class="text-center">가입일</th>
							<th class="text-center">상태</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="c" items="${customerList}">
							<tr>
								<td class="text-center">${c.customerId}</td>
								<td class="text-center">${c.name}</td>
								<td class="text-center">${c.nickName}</td>
								<td class="text-center">${c.email}</td>
								<td class="text-center">${c.phone}</td>
								<td class="text-center">${c.zipCode}</td>
								<td>${c.province +=' '+= c.city +=' '+= c.town +=' '+= c.roadAddress +=' '+= c.detailAddress}</td>
								<td class="text-center">${c.createDate}</td>
								<c:choose>
									<c:when test="${c.active== '0'}">
										<td class="text-center text-primary">회원</td>
									</c:when>
									<c:otherwise>
										<td class="text-center text-danger">탈퇴</td>
									</c:otherwise>
								</c:choose>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<!-- end content -->
		</div>
		<!-- end container -->
	</section>
	<!-- end section -->

	<!-- footer적용 -->
	<jsp:include page="/WEB-INF/view/banner/footer.jsp"></jsp:include>

	<div class="dmtop">Scroll to Top</div>

	<!-- JavaScript Libraries -->
	<script src="${pageContext.request.contextPath}/lib/jquery/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/lib/php-mail-form/validate.js"></script>
	<script src="${pageContext.request.contextPath}/lib/prettyphoto/js/prettyphoto.js"></script>
	<script src="${pageContext.request.contextPath}/lib/isotope/isotope.min.js"></script>
	<script src="${pageContext.request.contextPath}/lib/hover/hoverdir.js"></script>
	<script src="${pageContext.request.contextPath}/lib/hover/hoverex.min.js"></script>
	<script src="${pageContext.request.contextPath}/lib/unveil-effects/unveil-effects.js"></script>
	<script src="${pageContext.request.contextPath}/lib/owl-carousel/owl-carousel.js"></script>
	<script src="${pageContext.request.contextPath}/lib/jetmenu/jetmenu.js"></script>
	<script src="${pageContext.request.contextPath}/lib/animate-enhanced/animate-enhanced.min.js"></script>
	<script src="${pageContext.request.contextPath}/lib/jigowatt/jigowatt.js"></script>
	<script src="${pageContext.request.contextPath}/lib/easypiechart/easypiechart.min.js"></script>

	<!-- Template Main Javascript File -->
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
</body>
</html>