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
	<!-- header적용. -->
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
					<li>Update Member</li>
				</ul>
				<h2>Update Member</h2>
			</div>
		</div>
	</section>
	<!-- end post-wrapper-top -->

	<section class="section1">
		<div class="container clearfix">
			<div class="content col-lg-12 col-md-12 col-sm-12 clearfix">
				<div class="col-lg-12 col-md-12 col-sm-12">
					<h4 class="title">
						<span>Update Member</span>
					</h4>
					<form method="post"
						action="${pageContext.request.contextPath}/UpdateMemberController">
						<div>
							<!-- 값넘기기 -->
							<input type="hidden" name="customerId" readonly="readonly" value="${requestScope.customer.customerId}">
						</div>
						<div>
							<table class="table">
								<tr>
									<td>이름 수정</td>
									<td><input type="text" name="name" class="form-control"  value="${requestScope.customer.name}" required></td>
								</tr>
								<tr>
									<td>닉네임 수정</td>
									<td><input type="text" name="nickName" class="form-control"  value="${requestScope.customer.nickName}" required></td>
								</tr>
								<tr>
									<td>이메일 수정</td>
									<td><input type="text" style="width: 300px;" name="email" class="form-control"  value="${requestScope.customer.email}" required></td>
								</tr>
								<tr>
									<td>번호 수정</td>
									<td><input type="text" name="phone" class="form-control" value="${requestScope.customer.phone}" required></td>
								</tr>
								<tr>
									<td>우편번호 수정</td>
									<td><input type="text" id="zipcode" name="zipCode" class="form-control"  value="${requestScope.customer.zipCode}" required></td>
								</tr>
								<tr>
									<td>시(도) 수정</td>
									<td><input style="width: 300px;" type="text" id="province" name="province" class="form-control"  value="${requestScope.customer.province}" required></td>
								</tr>
								<tr>
									<td>시군구 수정</td>
									<td><input style="width: 300px;" type="text" id="city" name="city" class="form-control"  value="${requestScope.customer.city}" required></td>
								</tr>
								<tr>
									<td>읍면 수정</td>
									<td><input style="width: 300px;" type="text" id="town" name="town" class="form-control"  value="${requestScope.customer.town}" required></td>
								</tr>
								<tr>
									<td>도로명 주소 수정</td>
									<td><input type="text" id="roadAddress" name="roadAddress" class="form-control"  value="${requestScope.customer.roadAddress}" required></td>
								</tr>
								<tr>
									<td>상세 주소 수정</td>
									<td><input type="text" id="detailAddress" name="detailAddress" class="form-control"  value="${requestScope.customer.detailAddress}" required></td>
								</tr>
								<tr>
									<td colspan="2">
										<button type="submit" class="btn btn-outline-info btn-sm">Update</button>
									</td>
								</tr>
							</table>
						</div>
					</form>
					<a href="${pageContext.request.contextPath}/SelectMemberOneController" type="button" class="btn btn-outline-info btn-sm">이전</a>
					<a href="${pageContext.request.contextPath}/UpdateMemberPwController" type="button" class="btn btn-outline-info btn-sm">비밀번호 수정</a>
				</div>
			</div>
			<!-- end content -->
		</div>
		<!-- end container! -->
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