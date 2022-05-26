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

	<section class="post-wrapper-top">
		<div class="container">
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<ul class="breadcrumb">
					<li><a href="${pageContext.request.contextPath}/IndexController">Home</a></li>
					<li>ORDER STATUS UPDATE</li>
				</ul>
				<h2>ORDER STATUS UPDATE</h2>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
			</div>
		</div>
	</section>
	<!-- end post-wrapper-top -->

	<section class="section1">
		<div class="container clearfix">
			<div class="content col-lg-10 col-md-10 col-sm-10 col-xs-10 clearfix">
			<c:choose>
				 <c:when test="${updateCheck eq true}">
				 	<a href="${pageContext.request.contextPath}/AdminOrderUpdateListController" class="btn">back</a>
				 </c:when>
				 <c:otherwise>
				 	<a href="${pageContext.request.contextPath}/AdminOrderListController" class="btn">back</a>
				 </c:otherwise>
			</c:choose>
				<div class="clearfix"></div>
					<form name="orderStatus" method="post" action="${pageContext.request.contextPath}/AdminDetailOrderController">
						<input type="text" value="${customerId}" hidden="hidden" name="customerId">
						<input type="text" value="${createDate}" hidden="hidden" name="createDate">
						<div class="form-inline form-group">
							<h4 class="text-primary">ORDER STATUS UPDATE</h4>
							<div class="col-xs-2">
							<c:choose>
								<c:when test="${updateCheck == null}">
									<select name="orderStatus" class="form-control">
										<option value="입금 전" <c:if test="${orderStatus eq '입금 전'}">selected</c:if>>입금 전</option>
										<option value="입금 확인" <c:if test="${orderStatus eq '입금 확인'}">selected</c:if>>입금 확인</option> <!-- 주문완료시 기본값 -->
										<option value="배송 완료" <c:if test="${orderStatus eq '배송 완료'}">selected</c:if>>배송 완료</option>
									</select>
								</c:when>
								<c:otherwise>
									<input type="text" name="orderNo" value="${orderNo}" hidden="hidden">
									<input type="text" name="updateCheck" value="true" hidden="hidden">
									<select name="orderStatus" class="form-control">
										<option value="취소 불가">취소 불가</option>
										<option value="취소 완료">취소 완료</option>
										<option value="환불 불가">환불 불가</option>
										<option value="환불 완료">환불 완료</option>
									</select>
								</c:otherwise>
							</c:choose>
							</div>
							<button type="submit" class="btn btn-primary">ORDER STATUS UPDATE</button>
						</div>
					</form>
				<div class="clearfix"></div>
				<h4 class="text-primary">DELIVERY ADDRESS</h4>
				<table class="table" data-effect="fade">
					<tr>
						<th class="text-center">우편번호</th>
						<th class="text-center">주소</th>
						<th class="text-center">상세주소</th>
					</tr>
				<c:forEach var="order" items="${detailOrderList}" varStatus="i">
					<c:if test="${i.first}">
						<tr>
							<td class="text-center">${order.zipCode}</td>
							<td class="text-center">${order.roadAddress}</td>
							<td class="text-center">${order.detailAddress}</td>
						</tr>
					</c:if>
				</c:forEach>
				</table>
				<h4 class="text-primary">ORDER INFORMATION</h4>
				<table class="table" data-effect="fade">
					<thead>
						<tr>
							<th class="text-center">No</th>
							<th class="text-center">ID</th>
							<th>상품 이름</th>
							<th class="text-center">가격</th>
							<th class="text-center">구매 수량</th>
							<th class="text-center">주문일</th>
							<th class="text-center">현재 주문상태</th>
						</tr>
					</thead>
					<tbody>
					
						<c:forEach var="order" items="${detailOrderList}">
							<tr>
								<td>${order.orderNo}</td>
								<td>${order.customerId}</td>
								<td>${order.productName}</td>
								<td class="text-center">${order.categoryPrice}</td>
								<td class="text-center">${order.categoryQuantity}</td>
								<td class="text-center">${order.createDate}</td>
								<td class="text-center">${order.orderStatus}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
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