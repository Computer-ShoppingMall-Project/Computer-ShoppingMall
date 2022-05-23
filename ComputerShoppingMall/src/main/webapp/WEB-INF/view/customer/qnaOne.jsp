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
<script type="text/javascript">
	function del() {
		if (confirm('Are you sure you want to delete the QNA?')) {
			document.getElementById('deleteQna').click();
		}
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
				<div class="col-lg-6 col-md-6 col-sm-6">
					<!-- QNA 리스트로 돌아가기 -->
					<a href="${pageContext.request.contextPath}/QnaListController">back</a>
					<!-- 고객문의 상세보기 -->
					<h4 class="title">DETAIL QNA</h4>
					<table class="table">
						<tr>
							<th>NO</th>
							<td>${customerNo}</td>
						</tr>
						<tr>
							<th>ID</th>
							<td>${sessionCustomerId}</td>
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
					<!-- 관리자 답변이 등록된 이후 고객은 QNA 수정 불가 -->
					<c:if test="${adminAnswer == ''}">
						<a href="${pageContext.request.contextPath}/UpdateQnaController?qnaNo=${requestScope.qna.qnaNo}&customerNo=${customerNo}" class="btn btn-large btn-primary">update</a>
						<!-- 수정 -->
					</c:if>
					<a style="display: none;" href="${pageContext.request.contextPath}/DeleteQnaController?qnaNo=${requestScope.qna.qnaNo}&customerNo=${customerNo}" id="deleteQna" class="btn btn-large btn-danger">delete</a>
					<!-- 삭제 -->
					<a href="#" class="btn btn-large btn-danger" onclick="del();">delete</a>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-6">
					<br>
					<h4 class="title">Answer</h4>
					<div class="form-group">
						<textarea class="form-control" name="qnaAnswer" id="qnaAnswer" rows="5" data-rule="required" data-msg="Please write something message" readonly="readonly" placeholder="Your answer is not registered">${adminAnswer}</textarea>
					</div>
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