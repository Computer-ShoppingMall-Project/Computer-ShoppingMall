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
<link href="img/favicon.png" rel="icon">
<link href="img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Ruda:400,900,700"
	rel="stylesheet">

<!-- Bootstrap CSS File -->
<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Libraries CSS Files -->
<link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="lib/prettyphoto/css/prettyphoto.css" rel="stylesheet">
<link href="lib/hover/hoverex-all.css" rel="stylesheet">
<link href="lib/jetmenu/jetmenu.css" rel="stylesheet">
<link href="lib/owl-carousel/owl-carousel.css" rel="stylesheet">

<!-- Main Stylesheet File -->
<link href="css/style.css" rel="stylesheet">
<link rel="stylesheet" href="css/colors/blue.css">

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
					<li><a href="index.jsp">Home</a></li>
					<li>Main Product</li>
				</ul>
				<h2>STORAGE</h2>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<!-- search -->
				<div class="search-bar">
					<form action="" method="get">
						<fieldset>
							<input type="image" src="img/pixel.gif" class="searchsubmit" alt="" /> 
							<input type="text" class="search_text showtextback" name="s" id="s" value="Search..." />
						</fieldset>
					</form>
				</div>
				<!-- / end div .search-bar -->
			</div>
		</div>
	</section>
	<!-- end post-wrapper-top -->

	<section class="marketplace-top">
		<div id="market-wrapper">
			<div class="item_image" style="background: white;">
				<img data-effect="fade" class="aligncenter" width="400" height="200" src="${pageContext.request.contextPath}/image/${requestScope.storageOne.storageImageName}" alt="">
			</div>
			<!-- end item_image -->
		</div>
	</section>

	<section class="section1">
		<div class="container clearfix">
			<div class="content col-lg-12 col-md-12 col-sm-12 clearfix">

				<div class="general-title text-center">
					<h3>${requestScope.storageOne.storageName}</h3>
					<hr>
				</div>

				<div class="divider"></div>

				<div class="item_details">

					<div class="col-lg-3 col-md-3 col-sm-12">
						<div class="theme_details">
							<div class="details_section">
								<h3>Item Details</h3>
								<ul>
									<li class="version">storage_no : <span>${requestScope.storageOne.storageNo}</span></li>
									<li class="designer">company_name : <span>${requestScope.storageOne.companyName}</span></li>
									<li class="designer">category_name : <span>${requestScope.storageOne.categoryName}</span></li>
									<li class="designer">storage_interface : <span>${requestScope.storageOne.storageInterface}</span></li>
									<li class="designer">capacity : <span>${requestScope.storageOne.capacity}</span></li>
								</ul>
							</div>
						</div>
					</div>
					<!-- col-lg-3 -->

					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="theme_details">
							<div class="item-description">
								<p>${requestScope.storageOne.memo}</p>
							</div>
							<!-- item-description -->
						</div>
						<!-- theme_details -->
					</div>
					<!-- col-lg-6 -->
					<div class="col-lg-3 col-md-3 col-sm-12">
							<div class="form-group">
								<div> 개수 선택 
									<form  class="contact-form" action="${pageContext.request.contextPath}/CartAddStorageController?storageNo=${requestScope.storageOne.storageNo}" method="POST">
										<input type="number" max="${requestScope.storageOne.quantity}" name="quantity" value="1" class="text-center">개 
										<input type="submit" class="btn btn-large btn-primary" value="담기">
									</form>
								</div>
							</div>
							<h4 class="text-danger">재고 : ${requestScope.storageOne.quantity}</h4>
							<div class="form-group">
								<div class="item_price">
									<h3>
										<span>${requestScope.storageOne.price}원</span>
									</h3>
								</div>
							</div>
							<!-- buttons -->
							<hr>
							<div class="rating text-center">
								<i class="fa fa-star"></i> <i class="fa fa-star"></i> 
								<i class="fa fa-star"></i> <i class="fa fa-star"></i> 
								<i class="fa fa-star-o"></i>
								<p>Users Rating</p>
							</div>
							<!-- rating -->
						</div>
						<!-- theme_details -->
					</div>
					<!-- col-lg-3 -->

				</div>
				<!-- item_details -->

				<div class="clearfix"></div>

				<div class="divider"></div>

				<!-- theme / Products overview -->

			</div>
			<!-- end content -->
		<!-- end container -->
	</section>
	<!-- end section -->

	<!-- footer적용 -->
	<jsp:include page="/WEB-INF/view/banner/footer.jsp"></jsp:include>

	<div class="dmtop">Scroll to Top</div>

	<!-- JavaScript Libraries -->
	<script src="lib/jquery/jquery.min.js"></script>
	<script src="lib/bootstrap/js/bootstrap.min.js"></script>
	<script src="lib/php-mail-form/validate.js"></script>
	<script src="lib/prettyphoto/js/prettyphoto.js"></script>
	<script src="lib/isotope/isotope.min.js"></script>
	<script src="lib/hover/hoverdir.js"></script>
	<script src="lib/hover/hoverex.min.js"></script>
	<script src="lib/unveil-effects/unveil-effects.js"></script>
	<script src="lib/owl-carousel/owl-carousel.js"></script>
	<script src="lib/jetmenu/jetmenu.js"></script>
	<script src="lib/animate-enhanced/animate-enhanced.min.js"></script>
	<script src="lib/jigowatt/jigowatt.js"></script>
	<script src="lib/easypiechart/easypiechart.min.js"></script>

	<!-- Template Main Javascript File -->
	<script src="js/main.js"></script>
</body>
</html>