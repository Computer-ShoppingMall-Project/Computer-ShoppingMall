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

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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
					<li>Order</li>
				</ul>
				<h2>Order</h2>
			</div>
			<!-- search -->
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<div class="search-bar">
					<form action="" method="get">
						<fieldset>
							<input type="image" src="${pageContext.request.contextPath}img/pixel.gif" class="searchsubmit" alt="" />
							<input type="text" class="search_text showtextback" name="s" id="s" value="Search..." />
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</section>
	<!-- end post-wrapper-top -->
	<!-- customerId -->
	<section class="section1">
		<div class="container clearfix">
			<h5 class="title">주문자 정보</h5>

			<form id="personalinfo" action="" name="personalinfo" method="post">
				<div class="content col-lg-12 col-md-12 col-sm-12 col-xs-12 clearfix">
					<label for="email">Name <span class="required">*</span>
					</label> <input type="text" name="name" id="name" class="form-control" value="${sessionCustomerId}">
						<label for="fname">Email
							<span class="required">*</span>
					</label> <input type="text" name="email" id="email" class="form-control" value="${requestScope.customer.email}">
						<label for="lname">PHONE
							<input type="text" name="lname" id="lname" class="form-control" value="${requestScope.customer.phone}">
					</label>
				</div>
				<h5 class="title">배송 받을 주소</h5>
				<div>배송 받을 주소가 회원 정보에 저장된 주소와 다를시, 주소를 새로 입력하십시오</div>
				<div class="divider"></div>
				<div>
					<div class="col-lg-1 col-md-4 col-sm-12">
						<label for="lname">Zip_Code </label> 
						<input type="text" name="zipCode" id="zipcode" class="form-control" onclick="execDaumPostcode()" value="${requestScope.customer.zipCode}" class="form-control">
						<span id="zipcodeHelper" class="helper"></span>
					</div>
					<div class="col-lg-4 col-md-4 col-sm-12">
						<label for="lname">Road_Address </label>
						<input type="text" name="roadAddress" id="roadAddress" class="form-control" value="${requestScope.customer.roadAddress}" class="form-control">
						<span id="roadHelper" class="helper"></span>
					</div>
					<div class="col-lg-4 col-md-4 col-sm-12">
						<label for="lname">Detail_Address </label>
						<input type="text" name="detailAddress" id="detailAddress" class="form-control" value="${requestScope.customer.detailAddress}" class="form-control">
						<span id="detailHelper" class="helper"></span>
					</div>
				</div>
				<!-- customerId end -->
				<div class="clearfix"></div>
				<div class="divider"></div>

				<hr>

				<h5 class="title">무통장입금</h5>

				<label for="">무통장 입금시 주의 사항</label>
				<div>1. 결제창에 입력한 입금자명과 실제 주문금액을 이체한 계좌의 입금자명(예금주)이 다른 경우 누락이 됩니다.</div>
				<div>2. 결제금액과 실제 입금금액이 다른 경우 누락이 됩니다.</div>
				<div>3. 주문을 완료하기 전에 입금을 먼저 한 경우에도 누락됩니다.</div>
				<div>4. 개인결제나 추가입금, 주문취소 후 재결제, 주문취소 후 고객의 임의 입금 등의 경우 누락됩니다.</div>
				<div>5. 주문이 접수된지 3일이 지난 경우 자동입금확인 처리가 되지 않아 해당 주문 건은 수동으로 처리해야 합니다.</div>
				<div> ※ 자동입금확인 서비스는 서비스 계좌 최초 등록시 당일 데이터부터 수집 됩니다.</div>
				<div class="clearfix"></div>
				<div class="divider"></div>

				<label for="">예금주 : 박범진</label>
				<div>신한은행: 140-009-854865</div>
				<div>농협은행: 302-0634-2216-71</div>
				<div>국민은행: 037601-04-015155</div>
				<div>기업은행: 596-036185-04-014</div>
				<div class="divider"></div>
				<div class="my-2">입금계좌는 장애상황에 따라 변경될 수 있으니 항상 확인 부탁드립니다.</div>
				<div class="my-2 text-danger">오픈뱅킹 입금 건은 수동처리되므로 오전9시부터 밤11시 사이에 결제 후 다음 날 오전에 처리됩니다.</div>
				<div class="clearfix"></div>
				<div class="divider"></div>

				<!-- 결제품목 -->
				<table class="table table-striped" data-effect="fade">
					<thead>
						<tr>
							<th>NO</th>
							<th>ID</th>
							<th>NAME</th>
							<th>price</th>
							<th>quantity</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="basket" items="${basketList}">
							<tr>
								<td>${basket.basketNo}</td>
								<td>${basket.customerId}</td>
								<td>${basket.productName}</td>
								<td>${basket.price}</td>
								<td>${basket.quantity}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="well text-right">
				<table>
					<c:set var ="sum" value="0"/>
					<c:forEach var="basket" items="${basketList}">
						<c:set var="sum" value="${sum + basket.price}"/>
					</c:forEach>
					<tr>
						<td>총 합계 :</td>
						<td><c:out value="${sum}"/></td>
					</tr>
				</table>
				</div>
				<!-- 결제품목 end-->
				<div class="form-group">
					<input type="submit" class="button" value="결제">
				</div>
			</form>
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
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	
	<script>
		// 카카오 주소api
		function execDaumPostcode() {
			new daum.Postcode({
				oncomplete : function(data) {
					var roadAddr = data.roadAddress; // 도로명 주소 
					var extraRoadAddr = ''; // 참고 항목
					// 법정동명이 있을 경우 추가한다. (법정리는 제외)
					// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
					if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
						extraRoadAddr += data.bname;
					}
					// 건물명이 있고, 공동주택일 경우 추가한다.
					if (data.buildingName !== '' && data.apartment === 'Y') {
						extraRoadAddr += (extraRoadAddr !== '' ? ', '
								+ data.buildingName : data.buildingName);
					}
					// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
					if (extraRoadAddr !== '') {
						extraRoadAddr = ' (' + extraRoadAddr + ')';
					}
					// 우편번호와 주소 정보를 해당 필드에 넣는다.
					document.getElementById('zipcode').value = data.zonecode;
					document.getElementById('roadAddress').value = roadAddr;
				}
			}).open();
		}
	</script>
</body>
</html>