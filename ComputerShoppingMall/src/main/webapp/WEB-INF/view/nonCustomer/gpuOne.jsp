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
<link href="https://fonts.googleapis.com/css?family=Ruda:400,900,700"
	rel="stylesheet">

<!-- Bootstrap CSS File -->
<link href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Libraries CSS Files -->
<link href="${pageContext.request.contextPath}/lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/lib/prettyphoto/css/prettyphoto.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/lib/hover/hoverex-all.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/lib/jetmenu/jetmenu.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/lib/owl-carousel/owl-carousel.css" rel="stylesheet">

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
<script type="text/javascript">
	function plus() {
		if (confirm('Are you sure you want to put it in your shopping cart?')) {
			document.getElementById('btn').click();
		}
	}
	window.onload = function() {
	    document.getElementById('btn').onclick = function() {
	        document.getElementById('frm').submit();
	        return false;
	    };
	};
</script>
<body>
	<!-- header적용 -->
		<c:choose>
		<c:when test="${sessionAdminId != null }">
			<jsp:include page="/WEB-INF/view/banner/adminHeader.jsp"></jsp:include>
		</c:when>
		<c:otherwise>
			<jsp:include page="${pageContext.request.contextPath}//WEB-INF/view/banner/header.jsp"></jsp:include>
		</c:otherwise>
	</c:choose>

	<section class="post-wrapper-top">
		<div class="container">
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<ul class="breadcrumb">
					<li><a href="index.jsp">Home</a></li>
					<li>Main Product</li>
				</ul>
				<h2>GRAPHIC CARD</h2>
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

	<section class="marketplace-top">
		<div id="market-wrapper">
			<div class="item_image" style="background: white;">
				<img data-effect="fade" class="aligncenter" width="400" height="200" src="${pageContext.request.contextPath}/image/${requestScope.gpuOne.gpuImageName}" alt="">
			</div>
			<!-- end item_image -->
		</div>
	</section>
	
		<section class="section1">
		<div class="container clearfix">
			<div class="content col-lg-12 col-md-12 col-sm-12 clearfix">

				<div class="general-title text-center">
					<h3>${requestScope.gpuOne.gpuName}</h3>
					<hr>
				</div>

				<div class="divider"></div>

				<div class="item_details">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<!-- theme_details -->
							<div class="form-group">
								<div class="item_price">
									<h3>
										<span>${requestScope.gpuOne.price}원</span>
									</h3>
								</div>
							</div>
							<!-- buttons -->
							<hr>
							<div class="form-group">
								<div class="text-center">
									<div class="theme_details col-lg-6 col-md-6 col-sm-6">
										<div class="details_section  text-center">
										<br><br>
											<h3>Item Details</h3>
											<ul>
												<li class="version">gpu_no : <span>${requestScope.gpuOne.gpuNo}</span></li>
												<li class="designer">company_name : <span>${requestScope.gpuOne.companyName}</span></li>
												<li class="designer">category_name : <span>${requestScope.gpuOne.categoryName}</span></li>
												<li class="designer">chipset_company : <span>${requestScope.gpuOne.chipsetCompany}</span></li>
												<li class="designer">gpu_size : <span>${requestScope.gpuOne.gpuSize}</span></li>
											</ul>
										</div>
									</div>
								</div>
								<div class="theme_details col-lg-6 col-md-6 col-sm-6">
								<br>
									<div class="theme_details">
										<div class="item-description">
											<p>${requestScope.gpuOne.memo}</p>
										</div>
										<!-- item-description -->
									</div>  
									<br>
									<div class="text-center">
										<form id="frm" class="contact-form"  action="${pageContext.request.contextPath}/CartAddGpuController?gpuNo=${requestScope.gpuOne.gpuNo}" method="POST">
											개수 선택 &nbsp; <input type="number" min="1" max="${requestScope.gpuOne.quantity}" name="quantity" value="1" class="text-center ">
											<input hidden="hidden" style="display: none;" id="btn" type="submit" class="btn btn-large btn-primary" value="담기">
											<a href="#" class="btn btn-large btn-primary" onclick="plus();">담기</a>
										</form>
									</div>
									<h4 class="text-danger text-center">재고 : ${requestScope.gpuOne.quantity}</h4>
									<br><br>
									<div class="rating text-center">
										<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
											class="fa fa-star"></i> <i class="fa fa-star"></i> <i
											class="fa fa-star-o"></i>
										<p>Users Rating</p>
									</div>
								<!-- theme_details -->
								</div>
							</div>
							<br><br>
						</div>
					</div>
					<div class="clearfix"></div>
					</div>
				</div>
			</section>
	<!-- end section -->

	<!-- footer적용 -->
	<jsp:include page="/WEB-INF/view/banner/footer.jsp"></jsp:include>

	<div class="dmtop">Scroll to Top</div>

	<!-- JavaScript Libraries -->
	<script src="${pageContext.request.contextPath}/lib/jquery/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}lib/php-mail-form/validate.js"></script>
	<script src="${pageContext.request.contextPath}/lib/prettyphoto/js/prettyphoto.js"></script>
	<script src="${pageContext.request.contextPath}lib/isotope/isotope.min.js"></script>
	<script src="${pageContext.request.contextPath}lib/hover/hoverdir.js"></script>
	<script src="${pageContext.request.contextPath}lib/hover/hoverex.min.js"></script>
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