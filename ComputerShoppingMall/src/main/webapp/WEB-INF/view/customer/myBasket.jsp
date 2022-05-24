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
<script type="text/javascript">
	function plus() {
		if (confirm('Are you sure you want to put it in your shopping cart?')) {
			document.getElementById('btn').click();
		}
	}
</script>
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
					<li>My Basket</li>
				</ul>
				<h2>My Basket</h2>
			</div>
		</div>
	</section>
	<!-- end post-wrapper-top -->

	<section class="section1">
		<div class="container clearfix">
			
			<div class="content col-lg-12 col-md-12 col-sm-12 col-xs-12 clearfix">
			<a href="${pageContext.request.contextPath}/CpuListController" type="button" style="float:right" class="btn btn-outline-primary">추가구매</a>
				<form action="${pageContext.request.contextPath}/UpdateMyBasketController" method="POST">
					<table class="table" data-effect="fade">
						<thead>
							<tr>
								<th>부품 이름</th>
								<th>부품 종류</th>
								<th>부품 번호</th>
								<th>가격</th>
								<th>수량</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="basket" items="${basketList}">
								<tr>
									<td>${basket.productName}</td>
									<td>${basket.categoryName}</td>
									<td>${basket.productNumber}</td>
									<td>${basket.price*basket.quantity}</td>
									<td>
										<input type="hidden" name="basketNo" value="${basket.basketNo}">
										<input type="number" name="quantity" value="${basket.quantity}" min="1" max="9"  class="text-center form-control">
									</td>
									<td>
										<button type="submit" class="btn btn-success">수정</button>
									</td>
									<td>
										<a hidden="hidden" style="display: none;" id="btn" href="${pageContext.request.contextPath}/DeleteBasketController?basketNo=${basket.basketNo}">삭제</a>
									</td>
									<td>
										<a href="#" class="btn btn-large btn-danger" onclick="plus();">delete</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</form>
				<c:choose>
					<c:when test="${basketCount eq 0}">
						<h4 class="text-primary text-center">등록된 상품이 없습니다</h4>
						<a href="${pageContext.request.contextPath}/CpuListController" type="button" class="button large btn-block">ADD ITEM</a>
					</c:when>
					<c:otherwise>
						<a href="${pageContext.request.contextPath}/OrderController" type="button" class="button large btn-block">PURCHASE THIS ITEM</a>
					</c:otherwise>
				</c:choose>
			</div>
			<!-- end content! -->
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

	<!-- Template Main Javascript File! -->
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
</body>
</html>