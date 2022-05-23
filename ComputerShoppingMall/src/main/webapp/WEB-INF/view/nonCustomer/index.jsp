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

	<section id="intro">
		<div class="container">
			<div class="ror">
				<div class="col-md-8 col-md-offset-2">
					<h1>RedVelvet Computer ShoppingMall</h1>
					<p>조립PC 부품을 판매하는 쇼핑몰 프로젝트 입니다. 
					-- 설명추가</p>
				</div>
			</div>
		</div>
	</section>

	<section class="section4 text-center">
		<div class="general-title">
			<h3>OUR BEST PRODUCTS</h3>
			<hr>
		</div>
		<div class="portfolio-wrapper">
			<div id="owl-demo" class="owl-carousel">

				<div class="item">
					<a data-rel="prettyPhoto" href="${pageContext.request.contextPath}/img/portfolio_01.jpg">
					<img class="lazyOwl" src="${pageContext.request.contextPath}/img/portfolio_01.jpg" data-src="${pageContext.request.contextPath}/img/portfolio_01.jpg" alt="">
						<div>
							<small>Product Design</small> <span>Project Name Here</span> <i class="fa fa-search"></i>
						</div>
					</a>
				</div>

				<div class="item">
					<a data-rel="prettyPhoto" href="${pageContext.request.contextPath}/img/portfolio_02.jpg">
					<img class="lazyOwl" src="${pageContext.request.contextPath}/img/portfolio_02.jpg" data-src="${pageContext.request.contextPath}/img/portfolio_02.jpg" alt="">
						<div>
							<small>Product Design</small> <span>Project Name Here</span>
							<i class="fa fa-search"></i>
						</div>
					</a>
				</div>

				<div class="item">
					<a href="${pageContext.request.contextPath}/single-portfolio-1.jsp">
					<img class="lazyOwl" src="/${pageContext.request.contextPath}/img/portfolio_07.jpg" data-src="${pageContext.request.contextPath}/img/portfolio_07.jpg" alt="">
						<div>
							<small>Product Design</small> <span>Project Name Here</span> <i class="fa fa-link"></i>
						</div>
					</a>
				</div>

				<div class="item">
					<a href="${pageContext.request.contextPath}/single-portfolio-1.jsp">
					<img class="lazyOwl" src="${pageContext.request.contextPath}/img/portfolio_05.jpg" data-src="${pageContext.request.contextPath}/img/portfolio_05.jpg" alt="">
						<div>
							<small>Product Design</small> <span>Project Name Here</span>
							<i class="fa fa-link"></i>
						</div>
					</a>
				</div>

				<div class="item">
					<a data-rel="prettyPhoto" href="${pageContext.request.contextPath}/img/portfolio_09.jpg">
					<img class="lazyOwl" src="${pageContext.request.contextPath}/img/portfolio_09.jpg" data-src="${pageContext.request.contextPath}/img/portfolio_09.jpg" alt="">
						<div>
							<small>Product Design</small> <span>Project Name Here</span> <i
								class="fa fa-search"></i>
						</div>
					</a>
				</div>

				<div class="item">
					<a data-rel="prettyPhoto" href="${pageContext.request.contextPath}/img/portfolio_10.jpg">
					<img class="lazyOwl" src="${pageContext.request.contextPath}/img/portfolio_10.jpg" data-src="${pageContext.request.contextPath}/img/portfolio_10.jpg" alt="">
						<div>
							<small>Product Design</small> <span>Project Name Here</span> <i class="fa fa-search"></i>
						</div>
					</a>
				</div>

				<div class="item">
					<a data-rel="prettyPhoto" href="${pageContext.request.contextPath}/img/portfolio_06.jpg">
					<img class="lazyOwl" src="${pageContext.request.contextPath}/img/portfolio_06.jpg" data-src="${pageContext.request.contextPath}/img/portfolio_06.jpg" alt="">
						<div>
							<small>Product Design</small> <span>Project Name Here</span>
						</div>
					</a>
				</div>

			</div>
			<!-- end owl-demo -->
		</div>
		<!-- end portfolio-wrapper -->
		<a class="button large" href="${pageContext.request.contextPath}/CpuListController">VIEW ALL PRODUCT</a>
	</section>
	

	<section class="section1">

		<div class="container">
			<div class="col-lg-4 col-md-4 col-sm-4">
				<div class="servicebox text-center">
					<div class="service-icon">
						<div class="dm-icon-effect-1" data-effect="slide-left">
							<a href="#" class=""> <i
								class="active dm-icon fa fa-bars fa-3x"></i>
							</a>
						</div>
						<div class="servicetitle">
							<h4>Responsive Layout</h4>
							<hr>
						</div>
						<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry"s standard dummy text ever since..</p>
					</div>
					<!-- service-icon -->
				</div>
				<!-- servicebox -->
			</div>
			<!-- large-4 -->

			<div class="col-lg-4 col-md-4 col-sm-4">
				<div class="servicebox text-center">
					<div class="service-icon">
						<div class="dm-icon-effect-1" data-effect="slide-bottom">
							<a href="#" class=""> <i
								class="active dm-icon fa fa-laptop fa-3x"></i>
							</a>
						</div>
						<div class="servicetitle">
							<h4>Creative Design</h4>
							<hr>
						</div>
						<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry"s standard dummy text ever since..</p>
					</div>
					<!-- service-icon -->
				</div>
				<!-- servicebox -->
			</div>
			<!-- large-4 -->

			<div class="col-lg-4 col-md-4 col-sm-4">
				<div class="servicebox text-center">
					<div class="service-icon">
						<div class="dm-icon-effect-1" data-effect="slide-right">
							<i class="active dm-icon fa fa-book fa-3x"></i>
						</div>
						<div class="servicetitle">
							<h4>Easy to Setup</h4>
							<hr>
						</div>
						<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry"s standard dummy text ever since..</p>
					</div>
					<!-- service-icon -->
				</div>
				<!-- servicebox -->
			</div>
			<!-- large-4 -->
		</div>
		<!-- end container -->
	</section>
	<!-- end section -->
	<!-- end section1 -->
	<!-- footer적용 -->
	<jsp:include page="/WEB-INF/view/banner/footer.jsp"></jsp:include>

	<!-- end footer -->
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