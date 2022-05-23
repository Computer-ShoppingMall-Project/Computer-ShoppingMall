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
		<c:when test="${sessionAdminId != null }">
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
					<li>ORDER STATUS UPDATE</li>
				</ul>
				<h2>ORDER STATUS UPDATE</h2>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
			</div>
		</div>
	</section>
	<!-- end post-wrapper-top -->

	<section class="section1">
		<div class="container clearfix">
			<div class="content col-lg-10 col-md-10 col-sm-10 col-xs-10 clearfix">
			<a href="${pageContext.request.contextPath}/AdminOrderListController" class="btn">back</a>
				<div class="clearfix"></div>
					<form name="orderStatus" method="post" action="${pageContext.request.contextPath}/AdminDetailOrderController">
						<input type="text" value="${customerId}" hidden="hidden" name="customerId">
						<input type="text" value="${createDate}" hidden="hidden" name="createDate">
						<div class="form-inline form-group">
							<h4 class="text-primary">&nbsp;&nbsp;&nbsp;&nbsp;ORDER STATUS UPDATE</h4>
							<div class="col-xs-2">
								<select name="orderStatus" class="form-control">
									<option value="입금 전" <c:if test="${orderStatus eq '입금 전'}">selected</c:if>>입금 전</option>
									<option value="입금 확인" <c:if test="${orderStatus eq '입금 확인'}">selected</c:if>>입금 확인</option> <!-- 주문완료시 기본값 -->
									<option value="배송 완료" <c:if test="${orderStatus eq '배송 완료'}">selected</c:if>>배송 완료</option>
								</select>
							</div>
							<button type="submit" class="btn btn-primary">ORDER STATUS UPDATE</button>
						</div>
					</form>
				<div class="clearfix"></div>
				<table class="table" data-effect="fade">
					<thead>
						<tr>
							<th class="text-center">No</th>
							<th class="text-center">ID</th>
							<th>상품 이름</th>
							<th class="text-center">가격</th>
							<th class="text-center">구매 수량</th>
							<th class="text-center">주문일</th>
							<th class="text-center">현재 주문상태</th>
						</tr>
					</thead>
					<tbody>
					
						<c:forEach var="order" items="${detailOrderList}">
							<tr>
								<td>${order.orderNo}</td>
								<td>${order.customerId}</td>
								<td>${order.productName}</td>
								<td class="text-center">${order.categoryPrice}</td>
								<td class="text-center">${order.categoryQuantity}</td>
								<td class="text-center">${order.createDate}</td>
								<td class="text-center">${order.orderStatus}</td>
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