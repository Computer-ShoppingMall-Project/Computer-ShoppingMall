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
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript">
	//이벤트 바인딩 시작
	$(document).ready(function() {
		$('#SendBtn').on('click', function() { // 버튼 클릭시 이벤트 바인딩
			let params = {};
			// params에 답변 값 세팅
			params.qnaAnswer = $('#qnaAnswer').val();
			// 유효성 검사 boolean 변환 
			let vali = validate(params);

			vali ? insertAnswerForm.submit() : $('#qnaAnswer').focus();// ? 연산자 사용 유효성 검사 통과시에 얼럿 실패시 제목에 포커스
		});
	});
	// 이벤트 바인딩 끝

	// 유효성 체크 function
	function validate(params) {
		if (NullVal(params.qnaAnswer)) {
			Swal.fire({
				icon : 'error',
				text : 'Enter your Answer'
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
	<jsp:include page="/WEB-INF/banner/adminHeader.jsp"></jsp:include>

	<section class="section1">
		<div class="container clearfix">
			<div class="content col-lg-12 col-md-12 col-sm-12 clearfix">
				<div class="col-lg-6 col-md-6 col-sm-6">
					<!-- QNA 리스트로 돌아가기 -->
					<a href="${pageContext.request.contextPath}/AdminQnaListController">back</a>
					<!-- 고객문의 상세보기 -->
					<h4 class="title">QNA ANSWER</h4>
					<table class="table">
						<tr>
							<th>NO</th>
							<td>${requestScope.qna.qnaNo}</td>
						</tr>
						<tr>
							<th>ID</th>
							<td>${requestScope.qna.customerId}</td>
						</tr>
						<tr>
							<th>TITLE</th>
							<td>${requestScope.qna.qnaTitle}</td>
						</tr>
						<tr height="100">
							<th style="vertical-align: middle;">CONTENT</th>
							<td>${requestScope.qna.qnaContent}</td>
						</tr>
						<tr>
							<th>CREATE DATE</th>
							<td>${requestScope.qna.createDate}</td>
						</tr>
						<tr>
							<th>UPDATE DATE</th>
							<td>${requestScope.qna.updateDate}</td>
						</tr>
					</table>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-6">
					<br>
					<h4 class="title">Answer</h4>
					<form method="post"
						action="AdminUpdateQnaController?qnaNo=${requestScope.qna.qnaNo}"
						id="insertAnswerForm" class="form-group">
						<textarea class="form-control" name="qnaAnswer" id="qnaAnswer"
							rows="5" data-rule="required"
							data-msg="Please write something message"
							placeholder="Your answer is not registered">${requestScope.qna.qnaAnswer}</textarea>
						<!-- 등록/수정 버튼 -->
						<div class="form-send">
							<button id="SendBtn" type="button"
								class="btn btn-large btn-primary">UPDATE</button>
						</div>
					</form>
					<ul class="contact_details">
						<li><i class="fa fa-envelope-o"></i> redteam@github.com</li>
						<li><i class="fa fa-phone-square"></i> +34 5565 6555</li>
						<li><i class="fa fa-home"></i> Goodee Academy, Seoul, Korea.</li>
					</ul>
					<!-- contact_details -->
				</div>
			</div>
			<!-- end content -->
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