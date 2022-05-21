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
<link href="${pageContext.request.contextPath}/img/favicon.png" rel="icon">
<link href="${pageContext.request.contextPath}/img/apple-touch-icon.png" rel="apple-touch-icon">

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
					<li>My Payment</li>
				</ul>
				<h2>MY Payment</h2>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<!-- search -->
				<div class="search-bar">
					<form action="" method="get">
						<fieldset>
							<input type="image" src="${pageContext.request.contextPath}/img/pixel.gif" class="searchsubmit" alt="" /> <input type="text" class="search_text showtextback" name="s" id="s" value="Search..." />
						</fieldset>
					</form>
				</div>
				<!-- / end div .search-bar -->
			</div>
		</div>
	</section>
	<!-- end post-wrapper-top -->

	<section class="section1">
		<div class="container clearfix">
			<div class="content col-lg-8 col-md-8 col-sm-8 col-xs-12 clearfix">
				<div class="clearfix"></div>
				<div class="clearfix"></div>
				<table class="table" data-effect="fade">
					<thead>
						<tr>
							<th>ID</th>
							<th>DATE</th>
							<th>AMOUNT(won)</th>
							<th>DETAILS</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="order" items="${orderList}">
							<tr>
								<td>${order.customerId}</td>
								<td>${order.createDate}</td>
								<td>${order.totalPrice}won</td>
								<td><a href="${pageContext.request.contextPath}/DetailOrderController?createDate=${order.createDate}">View Detail OrderList</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
			<!-- end content -->

			<div id="sidebar" class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
				<div class="widget">
					<h4 class="title">
						<span>RedVelvet</span>
					</h4>
					<ul class="pages">
						<li><a href="${pageContext.request.contextPath}/IndexController">Homepage</a></li>
						<li><a href="${pageContext.request.contextPath}/CpuListController">Buy more</a></li>
						<li><a href="${pageContext.request.contextPath}/QnaListController">Go QnA</a></li>
						<li><a href="#"></a></li>
						<li><a href="#"></a></li>
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