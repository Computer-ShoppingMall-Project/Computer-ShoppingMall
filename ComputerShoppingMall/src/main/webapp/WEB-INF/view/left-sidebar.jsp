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
	<jsp:include page="/WEB-INF/banner/header.jsp"></jsp:include>

	<section class="post-wrapper-top">
		<div class="container">
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<ul class="breadcrumb">
					<li><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
					<li>Page Left Sidebar</li>
				</ul>
				<h2>PAGE LEFT SIDEBAR</h2>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<!-- search -->
				<div class="search-bar">
					<form action="" method="get">
						<fieldset>
							<input type="image" src="${pageContext.request.contextPath}/img/pixel.gif" class="searchsubmit" alt="" />
							<input type="text" class="search_text showtextback" name="s" id="s" value="Search..." />
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
			<div class="content pull-right col-lg-8 col-md-8 col-sm-8 col-xs-12 clearfix">
				<h2>Random Text Title</h2>
				<img class="img-resposnive" src="${pageContext.request.contextPath}/img/demo_01.jpg" alt="">
				<div class="clearfix"></div>
				<blockquote>
					<small>Someone famous in <cite title="Source Title">Source Title</cite></small>
				</blockquote>
				<div class="clearfix"></div>
				<blockquote class="pull-right">
					<small>Someone famous in <cite title="Source Title">Source Title</cite></small>
				</blockquote>
				<div class="clearfix"></div>
			</div>
			<!-- end content -->


			<!-- SIDEBAR -->
			<div id="sidebar" class="col-lg-4 col-md-4 col-sm-4 col-xs-12">

				<div class="widget">
					<h4 class="title">
						<span>Subscribe</span>
					</h4>
					<form id="subscribe" action="mc.php" name="subscribe" method="post">
						<input type="text" name="name" id="name" class="form-control"
							placeholder="Name"> <input type="text" name="email"
							id="email" class="form-control" placeholder="Email">
						<div class="pull-right">
							<input type="submit" value="Subscribe" id="submit" class="button">
						</div>
					</form>
				</div>

				<div class="widget">
					<h4 class="title">
						<span>Recent Posts</span>
					</h4>
					<div class="tabbable">
						<ul class="nav nav-tabs">
							<li class="active"><a href="left-sidebar.jsp#recent"
								data-toggle="tab">Recent</a></li>
							<li><a href="left-sidebar.jsp#popular" data-toggle="tab">Popular</a></li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane active" id="recent">
								<ul class="recent_posts">
									<li><a href="#"> <img src="${pageContext.request.contextPath}/img/recent_post_01.png" alt="" />Our New Dashboard Is Here</a>
									<a class="readmore" href="#">read more</a></li>
									<li><a href="#"> <img src="${pageContext.request.contextPath}/img/recent_post_02.png" alt="" />Design Is In The Air</a>
									<a class="readmore" href="#">read more</a></li>
								</ul>
								<!-- recent posts -->
							</div>
							<div class="tab-pane" id="popular">
								<ul class="recent_posts">
									<li><a href="#"><img src="${pageContext.request.contextPath}/img/flickr_01.jpg" alt="" />Blog Post With Image </a>
									<a class="readmore" href="#">read more</a></li> 
									<li><a href="#"><img src="${pageContext.request.contextPath}/img/flickr_02.jpg" alt="" />Another Recent Post with Image </a>
									<a class="readmore" href="#">read more</a></li>
								</ul>
								<!-- recent posts -->
							</div>
						</div>
					</div>
					<!-- tabbable -->
				</div>
				<!-- end widget -->


				<div class="widget">
					<h4 class="title">
						<span>Categories</span>
					</h4>
					<ul class="categories">
						<li><a href="#">Logo Design</a></li>
						<li><a href="l#">Web Design</a></li>
						<li><a href="#">WordPress</a></li>
						<li><a href="#">HTML5 & CSS3</a></li>
						<li><a href="#">Other Works</a></li>
					</ul>
				</div>

				<div class="widget">
					<h4 class="title">
						<span>Pages</span>
					</h4>
					<ul class="pages">
						<li><a href="#">Homepage</a></li>
						<li><a href="#">About us</a></li>
						<li><a href="#">Portfolio</a></li>
						<li><a href="#">Shopping</a></li>
						<li><a href="#">Contact</a></li>
					</ul>
				</div>

				<div class="widget">
					<h4 class="title">
						<span>Tags</span>
					</h4>

					<div class="tagcloud">
						<a href="#" class="" title="12 topics">advice</a> 
						<a href="#" class="" title="2 topics">wordpress</a>
						<a href="#" class="" title="21 topics">joomla</a>
						<a href="#" class="" title="5 topics">blog</a>
						<a href="#" class="" title="62 topics">cms</a>
						<a href="#" class="" title="12 topics">drupal</a>
						<a href="#" class="" title="88 topics">html5</a>
						<a href="#" class="" title="15 topics">css3</a>
						<a href="#" class="" title="31 topics">orange</a>
						<a href="#" class="" title="16 topics">love to</a>
						<a href="#" class="" title="32 topics">tutorials</a>
						<a href="#" class="" title="12 topics">how to</a>
						<a href="#" class="" title="44 topics">advice</a>
					</div>
				</div>

			</div>
			<!-- end sidebar -->
		</div>
		<!-- end container -->
	</section>
	<!-- end section -->

	<!-- footer적용 -->
	<jsp:include page="/WEB-INF/banner/footer.jsp"></jsp:include>

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