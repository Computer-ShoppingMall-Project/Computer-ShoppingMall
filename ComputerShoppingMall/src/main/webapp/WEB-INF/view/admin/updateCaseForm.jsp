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
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	// kind 직접입력 
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
			if($("#selbox2").val() == "direct") {
				$("#selboxDirect2").show();
			}  else {
				$("#selboxDirect2").hide();
			}
		}) 
	});
	
	// socketSize 직접입력
	$(function(){
		$("#selboxDirect3").hide();
		
		$("#selbox3").change(function() {
	             //직접입력을 누를 때 나타남
			if($("#selbox3").val() == "direct") {
				$("#selboxDirect3").show();
			}  else {
				$("#selboxDirect3").hide();
			}
		}) 
	});
	
	// chipSet 직접입력
	$(function(){
		$("#selboxDirect4").hide();
		
		$("#selbox4").change(function() {
	             //직접입력을 누를 때 나타남
			if($("#selbox4").val() == "direct") {
				$("#selboxDirect4").show();
			}  else {
				$("#selboxDirect4").hide();
			}
		}) 
	});
</script>
</head>
<body>
	<!-- header적용 -->
	<jsp:include page="/WEB-INF/view/banner/adminHeader.jsp"></jsp:include>

	<section class="post-wrapper-top">
		<div class="container">
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<ul class="breadcrumb">
					<li><a href="${pageContext.request.contextPath}/IndexController">Home</a></li> 
				</ul>
				<h2>상품수정</h2> 
			</div>
		</div>
	</section>
	<!-- end post-wrapper-top -->

	<section class="section1">
		<div class="container clearfix">
			<div class="content col-lg-12 col-md-12 col-sm-12 clearfix">
				<div class="col-lg-3 col-md-6 col-sm-12"></div>
				<div class="col-lg-6 col-md-6 col-sm-12">
					<h4 class="title text-primary">CASE 수정
					<c:if test="${msg != null || msg != ''}">
						<span class="text-danger">${msg}</span>
					</c:if>
					</h4>
						
					<form id="updateCaseform" method="post" name="updateCaseform" action="${pageContext.request.contextPath}/UpdateCaseController">
						<div>
							<!-- 값넘기기 -->
							<input type="hidden" name="caseImageNo" readonly="readonly" value="${requestScope.case.caseImageNo}" required>
							<input type="hidden" name="caseNo" readonly="readonly" value="${requestScope.case.caseNo}" required>
						</div>
						<table class="table text-primary">
							<tr>
								<th>CATEGORY</th>
								<td>
									<input type="text"  name="categoryName" value="${requestScope.case.categoryName}" readonly="readonly" class="form-control">
								</td>
							</tr>
							<tr>
								<th>UPDATE NAME</th>
								<td>
									<input type="text"  name="caseName" class="form-control" placeholder="Case Name">
								</td>
							</tr>
							
							<tr>
								<th>UPDATE CASE SIZE</th>
								<td>
									<select class="form-control" id="selbox" name="caseSize" >
										<option value="" selected disabled>case size 선택</option>
											<c:forEach var="c" items="${caseSizeList}">
												<option value="${c}">${c}</option>
											</c:forEach>
										<option value="direct">직접 입력</option>
									</select>
									<input type="text" id="selboxDirect"  name="caseSizeInsert" class="form-control" value="" placeholder="Case Size 직접 입력">
								</td>
							</tr>
							<tr>
								<th>UPDATE GPU SIZE</th>
								<td>
									<select class="form-control" id="selbox2" name="gpuSize" >
										<option value="" selected disabled>gpu size 선택</option>
											<c:forEach var="c" items="${gpuSizeList}">
												<option value="${c}">${c}</option>
											</c:forEach>
										<option value="direct">직접 입력</option>
									</select>
									<input type="text" id="selboxDirect2"  name="gpuSizeInsert" class="form-control" value="" placeholder="Gpu Size직접 입력">
								</td>
							</tr>
							<tr>
								<th>UPDATE 89BAY</th>
								<td>
									<select class="form-control" id="selbox3" name="bay89mm" >
										<option value="" selected disabled>89bay 선택</option>
											<c:forEach var="c" items="${bay89mmList}">
												<option value="${c}">${c}</option>
											</c:forEach>
										<option value="direct">직접 입력</option>
									</select>
									<input type="text" id="selboxDirect3"  name="bay89mmInsert" class="form-control" value="" placeholder="89bay 직접 입력">
								</td>
							</tr>
							<tr>
								<th>UPDATE 64BAY</th>
								<td>
									<select class="form-control" id="selbox4" name="bay64mm" >
										<option value="" selected disabled>64bay 선택</option>
											<c:forEach var="c" items="${bay64mmList}">
												<option value="${c}">${c}</option>
											</c:forEach>
										<option value="direct">직접 입력</option>
									</select>
									<input type="text" id="selboxDirect4"  name="bay64mmInsert" class="form-control" value="" placeholder="64bay 직접 입력">
								</td>
							</tr>		
							<tr>
								<th>UPDATE QUANTITY</th>
								<td>
									<input type="number" name="quantity" min="1" class="form-control" placeholder="Quantity">
								</td>
							</tr>
							<tr>
								<th>UPDATE PRICE</th>
								<td>
									<input type="number" name="price" min="1" class="form-control" placeholder="Price">
								</td>
							</tr>
							<tr>
								<th>UPDATE MEMO</th>
								<td>
									<textarea class="form-control" cols="30" rows="5" name="memo"></textarea>
								</td>
							</tr>
						</table>
							<button type="submit" style="float:right">수정</button>
					</form>
				</div>
				<!-- end login -->
			</div>
			<!-- end content -->
		</div>
		<!-- end container -->
	</section>
	<!-- end section -->

	<!-- footer적용 -->
	<jsp:include page="/WEB-INF/view/banner/footer.jsp"></jsp:include>

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