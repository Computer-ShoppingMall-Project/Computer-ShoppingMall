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

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">

// companyName 직접입력 
	$(function(){
		$("#selboxDirect").hide();
		
		$("#selbox").change(function() {
	             //직접입력을 누를 때 나타남
			if($("#selbox").val() == "direct") {
				$("#selboxDirect").show();
			}  else {
				$("#selboxDirect").hide();
			}
		}) 
	});
	
	// company 직접입력
	$(function(){
		$("#selboxDirect2").hide();
		
		$("#selbox2").change(function() {
	             //직접입력을 누를 때 나타남
			if($("#selbox2").val() == "direct2") {
				$("#selboxDirect2").show();
			}  else {
				$("#selboxDirect2").hide();
			}
		}) 
	});
</script>

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
					<li>Main Product</li>
				</ul>
				<h2>GRAPHIC CARD</h2>
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
				<c:if test="${sessionAdminId != null }">
					<div>
						<a href="DeleteGpuController?gpuNo=${requestScope.gpuOne.gpuNo}" class="btn btn-danger">DELETE</a>
					</div>
				</c:if>
				<div class="divider"></div>

		
							<!-- buttons -->
							<hr>
							<div class="form-group">
								<div class="content col-lg-12 col-md-12 col-sm-12 clearfix">
									<div>
										<div class="details_section  text-center">
										<br><br>
											<h3>Item Details</h3>
											<table class="table text-primary">
												<tr>
													gpu_no : <span class="form-control">${requestScope.gpuOne.gpuNo}</span>
												</tr><br></br>
												<tr>
													gpu_name : <span>${requestScope.gpuOne.gpuName}</span>
													<input type="text" name="gpuName" class="form-control" placeholder="gpuName">
												</tr><br></br>
												<tr>
													company_name : <span>${requestScope.gpuOne.companyName}</span>
													<select class="form-control" id="selbox" name="companyName">
														<option value="" selected disabled>companyName 선택</option>
															<c:forEach var="c" items="${companyNameList}">
																<option value="${c}">${c}</option>
															</c:forEach>
														<option value="direct">직접 입력</option>
													</select>
													<input type="text" id="selboxDirect" name="companyName" class="form-control" value="" placeholder="companyName 직접 입력">
												</tr><br></br>
												<tr>
												category_name : <span class="form-control">${requestScope.gpuOne.categoryName}</span>
												</tr><br></br>
												<tr>
													chipset_company : <span>${requestScope.gpuOne.chipsetCompany}</span>
													<select class="form-control" id="selbox" name="chipsetCompany">
														<option value="" selected disabled>companyName 선택</option>
															<c:forEach var="c" items="${chipsetCompanyList}">
																<option value="${c}">${c}</option>
															</c:forEach>
														<option value="direct">직접 입력</option>
													</select>
													<input type="text" id="selboxDirect2" name="chipsetCompany" class="form-control" value="" placeholder="chipsetCompany 직접 입력">
												</tr><br></br>
												<tr>
												gpu_size : <span>${requestScope.gpuOne.gpuSize}
												<input type="number" name="gupSize" min="1" class="form-control" placeholder="GpuSize"><br></br>
												</tr>
												<tr>
													<li class="designer">price : <span>${requestScope.gpuOne.price}원</li>
													<input type="number" name="price" min="1" class="form-control" placeholder="Price"><br></br>
												</tr>>
												<tr>
													quantity : <span>${requestScope.gpuOne.quantity}개
													<input type="number" name="quantity" min="1" class="form-control" placeholder="Quantity">
												</tr><br></br>
													<input type="textarea" name="memo" class="theme_details col-lg-12 col-md-12 col-sm-5-" value="" placeholder="memo 직접 입력">
												</tr>
													<div class="theme_details col-lg-12 col-md-12 col-sm-5-">
								
													<div class="theme_details">
														<div class="item-description">
															${requestScope.gpuOne.memo}
												</div>
											</table>
											<button type="submit" style="float:right">등록</button>
										</div>
									</div>
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