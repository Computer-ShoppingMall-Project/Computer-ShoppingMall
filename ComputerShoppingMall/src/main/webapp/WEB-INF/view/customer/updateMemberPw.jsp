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
	<!-- 05.17 유효성 검사 추가 -->
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
					<li>Update Member Pw</li>
				</ul>
				<h2>Update Member Pw</h2>
			</div>
		</div>
	</section>
	<!-- end post-wrapper-top -->

	<section class="section1">
		<div class="container clearfix">
			<div class="content col-lg-12 col-md-12 col-sm-12 clearfix">
				<div class="col-lg-12 col-md-12 col-sm-12">
					<h4 class="title">
						<span>Update Member Pw</span>
							<c:if test="${empty customerPw}">
								<form id="checkPwForm" method="get" action="${pageContext.request.contextPath}/UpdateMemberPwController" >
									<div class="form-group">
										<input type="password" id="currentPw" name="currentPw" class="form-control" placeholder="비밀번호를 변경하려면 현재 비밀번호를 입력하세요!"> 
										<button type="button" id="check">비밀번호 확인</button>
										<span id="currentHelper" class="helper"></span>
										<span class="helper">${msg}</span>
									</div>
								</form>
							</c:if>
					</h4>
					
					<c:if test="${not empty customerPw}">	
						<form id="updateform" method="post" name="updateform" action="${pageContext.request.contextPath}/UpdateMemberPwController">
							<div>
								<!-- 값넘기기 -->
								<input type="hidden" name="customerId" class="form-control" value="${requestScope.customer.customerId}" required>
								<input type="hidden" name="name" class="form-control" value="${requestScope.customer.name}" required>
								<input type="hidden" name="nickName" class="form-control" value="${requestScope.customer.nickName}" required>
								<input type="hidden" name="email" class="form-control" value="${requestScope.customer.email}" required>
								<input type="hidden" name="phone" class="form-control" value="${requestScope.customer.phone}" required> 
								<input type="hidden" name="zipCode" class="form-control" value="${requestScope.customer.zipCode}" required> 
								<input type="hidden" name="roadAddress" class="form-control" value="${requestScope.customer.roadAddress}" required> 
								<input type="hidden" name="detailAddress" class="form-control" value="${requestScope.customer.detailAddress}" required>
							</div>
						<div class="form-group">
							<input type="password" readonly="readonly" name="customerPw" class="form-control" value="${customerPw}"> 
						</div>
							<div class="form-group">
								<input type="password" id="pw" name="newCustomerPw1" class="form-control" placeholder="New Password">
								<span id="pwHelper" class="helper"></span>
							</div>
							<div class="form-group">
								<input type="password" id="pwConfirm" name="newCustomerPw2" class="form-control" placeholder="New Password check">
								<span id="pwConfirmHelper" class="helper"></span>
							</div>
							<div class="form-group">
								<button type="button" id="update" class="btn btn-outline-info btn-sm">Update</button>
							</div>
						</form>
					 </c:if>
				</div>
				<div>
					<a href="${pageContext.request.contextPath}/SelectMemberOneController" type="button" class="btn btn-outline-info btn-sm">이전</a>
					<a href="${pageContext.request.contextPath}/IndexController" type="button" class="btn btn-outline-info btn-sm">index</a>
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
	<script type="text/javascript">
		// 현재 비밀번호 확인 
		$('#currentPw').focus();

		$('#currentPw').blur(function() {
			if ($('#currentPw').val().length == 0) {
				$('#currentHelper').text('현재 비밀번호를 확인하세요');
				$('#currentPw').focus();
			} else {
				$('#currentHelper').text('');
			}
		});
		// 현재 비밀번호 검사 버튼 이벤트
		$('#check').click(function() {
    		if($('#currentPw').val() == '') {
    			$('#currentHelper').text('현재 비밀번호를 확인하세요');
    			$('#currentPw').focus();
    		} else {
    			$('#checkPwForm').submit();
    		}
    	}); 
		
		// 바꿀 비밀번호 유효성
		$('#pwConfirm').blur(function() {
			if ($('#pw').val().length < 4) {
				$('#pwHelper').text('바꿀 비밀번호를 확인하세요, 비밀번호는 4자이상으로 설정해야합니다.');
				$('#pw').focus();
			} else if ($('#pw').val() != $('#pwConfirm').val()) {
				$('#pwHelper').text('비밀번호 확인이 일치하지 않습니다');
				$('#pw').focus();
			} else {
				$('#pwHelper').text('');
			}
		});
		// 비밀번호 변경 버튼 누를시 이벤트 처리
		$('#update').click(function() {
			if ($('#pw').val() == '') {
				$('#pwHelper').text('바꿀 비밀번호를 입력하세요');
				$('#pw').focus();
			} else if ($('#pwConfirm').val() == '') {
				$('#pwHelper').text('');

				$('#pwConfirmHelper').text('비밀번호 확인란을 입력하세요');
				$('#pwConfirm').focus();
			} else {
				$('#updateform').submit();
			}
		});
	</script>
</body>
</html>