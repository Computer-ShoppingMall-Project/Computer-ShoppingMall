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
					<h1>ComVelvet</h1>
					<p>본인의 취향대로 골라 조립할 수 있는 조립식 컴퓨터, <br>
					 최고의 자유도와 가성비를 ComVelvet에서 함께하세요!</p>
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
			 	<!-- cpu 순위 -->
				<c:forEach var="cpu" items="${cpuRank}">
					<div class="item">
					<a data-rel="prettyPhoto" href="${pageContext.request.contextPath}/image/${cpu.cpuImage}">
					<img class="lazyOwl" src="${pageContext.request.contextPath}/image/${cpu.cpuImage}" data-src="${pageContext.request.contextPath}/image/${cpu.cpuImage}" alt="">
						<div>
							<small>Product Design</small> <span>${cpu.productName}</span> <i class="fa fa-search"></i>
						</div>
					</a>
				</div>
				</c:forEach>
				<!-- case 순위 -->
				<c:forEach var="ca" items="${caRank}">
					<div class="item">
					<a data-rel="prettyPhoto" href="${pageContext.request.contextPath}/image/${ca.caseImage}">
					<img class="lazyOwl" src="${pageContext.request.contextPath}/image/${ca.caseImage}" data-src="${pageContext.request.contextPath}/image/${ca.caseImage}" alt="">
						<div>
							<small>Product Design</small> <span>${ca.productName}</span> <i class="fa fa-search"></i>
						</div>
					</a>
					</div>
				</c:forEach>
				<!-- power 순위 -->
				<c:forEach var="power" items="${powerRank}">
					<div class="item">
					<a data-rel="prettyPhoto" href="${pageContext.request.contextPath}/image/${power.powerImage}">
					<img class="lazyOwl" src="${pageContext.request.contextPath}/image/${power.powerImage}" data-src="${pageContext.request.contextPath}/image/${power.powerImage}" alt="">
						<div>
							<small>Product Design</small> <span>${power.productName}</span> <i class="fa fa-search"></i>
						</div>
					</a>
					</div>
				</c:forEach>	
				<!-- cooler 순위 -->
				<c:forEach var="cooler" items="${coolerRank}">
					<div class="item">
					<a data-rel="prettyPhoto" href="${pageContext.request.contextPath}/image/${cooler.coolerImage}">
					<img class="lazyOwl" src="${pageContext.request.contextPath}/image/${cooler.coolerImage}" data-src="${pageContext.request.contextPath}/image/${cooler.coolerImage}" alt="">
						<div>
							<small>Product Design</small> <span>${cooler.productName}</span> <i class="fa fa-search"></i>
						</div>
					</a>
					</div>
				</c:forEach>	
				<!-- gpu 순위 -->
				<c:forEach var="gpu" items="${GpuRank}">
					<div class="item">
					<a data-rel="prettyPhoto" href="${pageContext.request.contextPath}/image/${gpu.gpuImage}">
					<img class="lazyOwl" src="${pageContext.request.contextPath}/image/${gpu.gpuImage}" data-src="${pageContext.request.contextPath}/image/${gpu.gpuImage}" alt="">
						<div>
							<small>Product Design</small> <span>${gpu.productName}</span> <i class="fa fa-search"></i>
						</div>
					</a>
					</div>
				</c:forEach>	
				<!-- mainboard 순위 -->
				<c:forEach var="mainboard" items="${mainboardRank}">
					<div class="item">
					<a data-rel="prettyPhoto" href="${pageContext.request.contextPath}/image/${mainboard.mainboardImage}">
					<img class="lazyOwl" src="${pageContext.request.contextPath}/image/${mainboard.mainboardImage}" data-src="${pageContext.request.contextPath}/image/${mainboard.mainboardImage}" alt="">
						<div>
							<small>Product Design</small> <span>${mainboard.productName}</span> <i class="fa fa-search"></i>
						</div>
					</a>
					</div>
				</c:forEach>	
				<!-- ram 순위 -->
				<c:forEach var="ram" items="${ramRank}">
					<div class="item">
					<a data-rel="prettyPhoto" href="${pageContext.request.contextPath}/image/${ram.ramImage}">
					<img class="lazyOwl" src="${pageContext.request.contextPath}/image/${ram.ramImage}" data-src="${pageContext.request.contextPath}/image/${ram.ramImage}" alt="">
						<div>
							<small>Product Design</small> <span>${ram.productName}</span> <i class="fa fa-search"></i>
						</div>
					</a>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="portfolio-wrapper">
			<div id="owl-demo" class="owl-carousel">
				<!-- storage순위 -->
				<c:forEach var="storage" items="${storageRank}">
					<div class="item">
					<a data-rel="prettyPhoto" href="${pageContext.request.contextPath}/image/${storage.storageImage}">
					<img class="lazyOwl" src="${pageContext.request.contextPath}/image/${storage.storageImage}" data-src="${pageContext.request.contextPath}/image/${storage.storageImage}" alt="">
						<div>
							<small>Product Design</small> <span>${storage.productName}</span> <i class="fa fa-search"></i>
						</div>
					</a>
					</div>
				</c:forEach>						
			</div>
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
							<img alt="" src="${pageContext.request.contextPath}/img/free-delivery.png" width="130">
						</div>
						<div class="servicetitle">
							<h4>무료배송</h4>
							<hr>
						</div>
						<p>저희 ComVelvet은 모든 제품을 개수와 무관하게<br>무료배송을 원칙으로 하고있습니다.</p>
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
							<img alt="" src="${pageContext.request.contextPath}/img/answer.png" width="130">
						</div>
						<div class="servicetitle">
							<h4>Q&A 활성화</h4>
							<hr>
						</div>
						<p>저희 ComVelvet은 고객님의 문의에대해
						<br> 항상 빠른 답변을 위해 노력하고 있습니다.
						<br> 견적, 배송, 기타 불편사항 등 언제든 문의바랍니다.
						</p>
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
							<img alt="" src="${pageContext.request.contextPath}/img/delivery.png" width="130">
						</div>
						<div class="servicetitle">
							<h4>꼼꼼한 포장</h4>
							<hr>
						</div>
						<p>저희 ComVelvet은 꼼꼼한 안전 포장을 통해 
						<br>고객님이 파손걱정 없이 안전하게 받아볼 수 있도록 
						<br>노력하고 있습니다.</p>
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