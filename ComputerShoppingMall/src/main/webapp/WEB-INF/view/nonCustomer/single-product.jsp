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
	<jsp:include page="/WEB-INF/view/banner/header.jsp"></jsp:include>

	<section class="post-wrapper-top">
		<div class="container">
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<ul class="breadcrumb">
					<li><a href="${pageContext.request.contextPath}/IndexController">Home</a></li>
					<li>Main Product</li>
				</ul>
				<h2>MAINBOARD</h2>
			</div>
		</div>
	</section>
	<!-- end post-wrapper-top -->

	<section class="marketplace-top">
		<div id="market-wrapper">
			<div class="item_image">
				<img data-effect="fade" class="aligncenter" width="1260" height="400" src="${pageContext.request.contextPath}/img/market_single_01.png" alt="">
			</div>
			<!-- end item_image -->
		</div>
	</section>

	<section class="section1">
		<div class="container clearfix">
			<div class="content col-lg-12 col-md-12 col-sm-12 clearfix">

				<div class="general-title text-center">
					<h3>Flat Pack Heritage</h3>
					<p>ÜBER PREMIUM VEGETABLE TANNED ITALIAN LEATHER</p>
					<hr>
				</div>

				<div class="divider"></div>

				<div class="item_details">

					<div class="col-lg-3 col-md-3 col-sm-12">
						<div class="theme_details">
							<div class="details_section">
								<h3>Item Details</h3>
								<ul>
									<li class="version">Size: <span>11.8” X 7.87” X 1.57</span></li>
									<li class="release">Release Date: <span>28 February, 2014</span></li>
									<li class="designer">Designer: <span>Matt Stinson</span></li>
									<li class="designer">Material: <span>Tanned Italian Leather</span></li>
								</ul>
							</div>
						</div>
					</div>
					<!-- col-lg-3 -->

					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="theme_details">
							<div class="item-description">
								<p>Our über premium vegetable tanned Italian leather is hand-stained hide by hide. Skilled workmen apply natural colouring made from tree bark, etc. by hand onto the leather. This traditional technique needs a lot of time but ensures an amazing quality.</p>
								<p>Each hide has its own special touch and is unique in tone and texture. This is a very honest and hands-on process and sometimes colouring can be found on the back which is proof of this age-old way of crafting leather.</p>
								<p>This is ‘real’ leather and the natural skin structure shows through. Sometimes you can see small marks or scratches which are evidence of the über premium and untouched quality. Because of the natural character of the leather, it needs to be taken care of in order to last. Just like applying cream on dry hands - if the leather feels dry, apply a small amount of leather balm or wax.</p>
							</div>
							<!-- item-description -->
						</div>
						<!-- theme_details -->
					</div>
					<!-- col-lg-6 -->

					<div class="col-lg-3 col-md-3 col-sm-12">
						<div class="theme_details">
							<div class="item_price">
								<h3>
									<span><small>$</small>450.00</span>
								</h3>
							</div>
							<!-- item_price -->
							<hr>
							<div class="buttons">
								<a class="button btn-block large" href="${pageContext.request.contextPath}/SingleProductUpdateController">UPDATE</a>
								<a class="button btn-block large" href="${pageContext.request.contextPath}/SingleProductDeleteController">DELETE</a>
							</div>
							<!-- buttons -->
							<hr>
							<div class="rating text-center">
								<i class="fa fa-star"></i>
								<i class="fa fa-star"></i>
								<i class="fa fa-star"></i>
								<i class="fa fa-star"></i>
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

				<div class="general-title text-center">
					<h3>Product Features</h3>
					<p>More information about your product</p>
					<hr>
				</div>

				<div class="divider"></div>
				<div class="theme_overviews clearfix">
					<div class="col-lg-4 col-md-4 col-sm-12 first">
						<div class="services">
							<div class="icon-container">
								<i class="fa fa-arrows"></i>
							</div>
							<header>
								<h3>Different Sizes</h3>
							</header>
							<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
						</div>
					</div>

					<div class="col-lg-4 col-md-4 col-sm-12">
						<div class="services">
							<div class="icon-container">
								<i class="fa fa-heart"></i>
							</div>
							<header>
								<h3>HandMade in Italy</h3>
							</header>
							<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
						</div>
					</div>

					<div class="col-lg-4 col-md-4 col-sm-12 last">
						<div class="services">
							<div class="icon-container">
								<i class="fa fa-lock"></i>
							</div>
							<header>
								<h3>Secure Metal Zip</h3>
							</header>
							<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
						</div>
					</div>

					<div class="col-lg-4 col-md-4 col-sm-12 first">
						<div class="services">
							<div class="icon-container">
								<i class="fa fa-trophy"></i>
							</div>
							<header>
								<h3>Premium Design</h3>
							</header>
							<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
						</div>
					</div>

					<div class="col-lg-4 col-md-4 col-sm-12">
						<div class="services">
							<div class="icon-container">
								<i class="fa fa-cloud"></i>
							</div>
							<header>
								<h3>Softly Padded</h3>
							</header>
							<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
						</div>
					</div>

					<div class="col-lg-4 col-md-4 col-sm-12 last">
						<div class="services">
							<div class="icon-container">
								<i class="fa fa-pencil"></i>
							</div>
							<header>
								<h3>Signed Product</h3>
							</header>
							<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
						</div>
					</div>

				</div>
				<!-- theme / Products overview -->

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