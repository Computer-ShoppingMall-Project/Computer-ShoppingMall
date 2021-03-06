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
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() { // 이벤트 바인딩 시작
		$('#SendBtn').on('click', function() { // 전송 버튼 클릭시 이벤트 바인딩
			let params = {};
			// params에 제목, 내용 값 세팅
			params.qnaTitle = $('#qnaTitle').val();
			params.qnaContent = $('#qnaContent').val();
			// 유효성 검사 boolean 변환 
			let vali = validate(params);

			vali ? updateQnaForm.submit() : $('#qnaTitle').focus(); // ? 연산자 사용 유효성 검사 통과시에 얼럿 실패시 제목에 포커스
		});
	});
	// 이벤트 바인딩 끝

	// 유효성 체크 function
	function validate(params) {
		if (NullVal(params.qnaTitle)) {
			Swal.fire({
				icon : 'error',
				text : 'Enter your Title'
			});
			return false;
		}
		if (NullVal(params.qnaContent)) {
			Swal.fire({
				icon : 'error',
				text : 'Enter your Content'
			});
			return false;
		}
		if (params.qnaTitle.length > 50) {
			Swal.fire({
				icon : 'error',
				text : 'Title can be up to 50 characters long'
			});
			return false;
		}
		return true;
	};

	// 공백, null, 빈값 검사 function
	function NullVal(param) {
		if ((null == param) || ('' == param) || (param === undefined)
				|| (param === "undefined")) {
			return true;
		}
		return false;
	}
</script>
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

	<section class="section1">
		<div class="container clearfix">
			<div class="content col-lg-12 col-md-12 col-sm-12 clearfix">
				<div class="col-lg-6 col-md-6 col-sm-6 center-block"
					style="float: none; margin: 100 auto;">
					<!-- QNA 리스트로 돌아가기 -->
					<a href="${pageContext.request.contextPath}/QnaOneController?qnaNo=${requestScope.qna.qnaNo}&customerNo=${customerNo}">back</a>

					<!-- 고객문의 수정 폼 -->
					<h4 class="title">Update QNA</h4>
					<form id="updateQnaForm" class="contact-form" role="form" action="${pageContext.request.contextPath}/UpdateQnaController?qnaNo=${requestScope.qna.qnaNo}&customerNo=${customerNo}" method="POST">
						<div class="form-group">
							<input type="text" name="customerId" class="form-control" id="customerId" value="${sessionCustomerId}" readonly="readonly">
						</div>
						<div class="form-group">
							<input type="text" name="qnaTitle" class="form-control" id="qnaTitle" value="${requestScope.qna.qnaTitle}" placeholder="QNA title" data-rule="required">
						</div>
						<div class="form-group">
							<textarea class="form-control" name="qnaContent" id="qnaContent" placeholder="Contact Message" rows="5" data-rule="required">${requestScope.qna.qnaContent}</textarea>
						</div>
						<div class="form-send">
							<button id="SendBtn" type="button" class="btn btn-large btn-primary">Send</button>
						</div>
					</form>
				</div>
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