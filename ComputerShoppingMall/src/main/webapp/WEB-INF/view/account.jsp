<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<jsp:include page="/WEB-INF/banner/header.jsp"></jsp:include>

	<section class="post-wrapper-top">
		<div class="container">
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<ul class="breadcrumb">
					<li><a href="index.jsp">Home</a></li>
					<li>My Account</li>
				</ul>
				<h2>MY ACCOUNT</h2>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<!-- search -->
				<div class="search-bar">
					<form action="" method="get">
						<fieldset>
							<input type="image" src="img/pixel.gif" class="searchsubmit"
								alt="" /> <input type="text" class="search_text showtextback"
								name="s" id="s" value="Search..." />
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

				<table class="table table-striped" data-effect="fade">
					<thead>
						<tr>
							<th>Download Name</th>
							<th>Files</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>MaxFront Bootstrap Theme</td>
							<td>No downloadable files found</td>
						</tr>
						<tr>
							<td>Smart - Bootstrap Wordpress Theme</td>
							<td>1 Update Pending</td>
						</tr>
						<tr>
							<td>Spot - GentsThemes Wordpress Theme</td>
							<td>No downloadable files found</td>
						</tr>
						<tr>
							<td>MaxDash Bootstrap Theme</td>
							<td>Payment status is pending</td>
						</tr>
					</tbody>
				</table>

				<div class="clearfix"></div>
				<hr>

				<table class="table table-striped" data-effect="fade">
					<thead>
						<tr>
							<th>ID</th>
							<th>DATE</th>
							<th>AMOUNT</th>
							<th>DETAILS</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>01</td>
							<td>January 29, 2014</td>
							<td>$15.00</td>
							<td><a href="#">View Details and Downloads</a></td>
						</tr>
						<tr>
							<td>02</td>
							<td>December 31, 2013</td>
							<td>$18.00</td>
							<td><a href="#">View Details and Downloads</a></td>
						</tr>
						<tr>
							<td>03</td>
							<td>November 15, 2013</td>
							<td>$45.00</td>
							<td><a href="#">View Details and Downloads</a></td>
						</tr>
						<tr>
							<td>04</td>
							<td>September 12, 2013</td>
							<td>$30.00</td>
							<td><a href="#">View Details and Downloads</a></td>
						</tr>
					</tbody>
				</table>

			</div>
			<!-- end content -->

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