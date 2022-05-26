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
	<section class="section1">
		<div class="container clearfix">
			<div class="content col-lg-9 col-md-9 col-sm-9 col-xs-12 clearfix">
			<a href="${pageContext.request.contextPath}/MyPaymentController">back</a>
				<div class="clearfix"></div>
				<div class="clearfix"></div>
				<h4 class="text-primary">DELIVERY ADDRESS</h4>
				<table class="table" data-effect="fade">
					<tr>
						<th class="text-center">우편번호</th>
						<th class="text-center">주소</th>
						<th class="text-center">상세주소</th>
					</tr>
				<c:forEach var="order" items="${orderList}" varStatus="i">
					<c:if test="${i.first}">
					<tr>
						<td class="text-center">${order.zipCode}</td>
						<td class="text-center">${order.roadAddress}</td>
						<td class="text-center">${order.detailAddress}</td>
					</tr>
					</c:if>
				</c:forEach>
				</table>
				<h4 class="text-primary">ORDER INFORMATION</h4>
				<table class="table" data-effect="fade">
					<thead>
						<tr>
							<th class="text-center">상품 이름</th>
							<th class="text-center">가격</th>
							<th class="text-center">구매 수량</th>
							<th class="text-center">주문일</th>
							<th class="text-center">주문상태</th>
							<th class="text-center">주문변경</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="order" items="${orderList}">
							<tr>
								<td>${order.productName}</td>
								<td class="text-center">${order.categoryPrice}</td>
								<td class="text-center">${order.categoryQuantity}</td>
								<td class="text-center">${order.createDate}</td>
								<td class="text-primary text-center">${order.orderStatus}</td>
								<td>
									<c:if test="${order.orderStatus eq '입금 확인'}">
										<a class="btn btn-default btn-xs" href="${pageContext.request.contextPath}/UpdateOrderController?customerUpdateCheck=cancel&orderNo=${order.orderNo}&createDate=${order.createDate}">주문 취소</a>
									</c:if>
									<c:if test="${order.orderStatus eq '배송 완료'}">
										<div class="btn-group">
											<a class="btn btn-default btn-xs" href="${pageContext.request.contextPath}/UpdateOrderController?customerUpdateCheck=refund&orderNo=${order.orderNo}&createDate=${order.createDate}">교환</a>
											<a class="btn btn-default btn-xs" href="${pageContext.request.contextPath}/UpdateOrderController?customerUpdateCheck=cancel&orderNo=${order.orderNo}&createDate=${order.createDate}">환불</a>
										</div>
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
			<!-- end content -->

			<div id="sidebar" class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
				<div class="widget">
					<h4 class="title">
						<span>RedVelvet</span>
					</h4>
					<ul class="pages">
						<li><a href="${pageContext.request.contextPath}/IndexController">Home</a></li>
						<li><a href="${pageContext.request.contextPath}/CpuListController">Buy More</a></li>
						<li><a href="${pageContext.request.contextPath}/QnaListController">QnA</a></li>
					</ul>
				</div>
					<div class="widget">
					<h4 class="title">
						<span>contact information</span>
					</h4>
					<ul class="contact_details">
						<li><i class="fa fa-envelope-o"></i> redteam@github.com</li>
						<li><i class="fa fa-phone-square"></i> +34 5565 6555</li>
						<li><i class="fa fa-home"></i> Goodee Academy, Seoul, Korea.</li>
					</ul>
				</div>

			</div>
			<!-- end sidebar -->
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