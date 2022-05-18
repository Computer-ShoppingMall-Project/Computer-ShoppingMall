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
  <link href="https://fonts.googleapis.com/css?family=Ruda:400,900,700" rel="stylesheet">

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
</head>
<body>
<!-- 관리자 답변/답변수정/고객 질문 상세보기 페이지 -->
  <!-- header적용 -->
  <jsp:include page="/WEB-INF/banner/adminHeader.jsp"></jsp:include>

  <section class="post-wrapper-top">
    <div class="container">
      <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
        <ul class="breadcrumb">
          <li><a href="${pageContext.request.contextPath}/IndexController">Home</a></li>
          <li>Customer QNA</li>
        </ul>
        <h2>Customer QNA</h2>
      </div>
    </div>
  </section>
  <!-- end post-wrapper-top -->
  <section class="section1">
    <div class="container clearfix">
    <!-- div class="content col-lg-8 col-md-8 col-sm-8 col-xs-12 clearfix" -->
        <div class="clearfix"></div>
        <hr>
        <table class="table table-striped" data-effect="fade">
          <thead>
            <tr>
              <th>NO</th>
              <th>ID</th>
              <th>TITLE</th>
              <th>CREATE DATE</th>
              <th>UPDATE DATE</th>
              <th>ANSWER</th>
            </tr>
          </thead>
          <tbody>
			<c:forEach var="qna" items="${qnaList}">
				<tr>
					<td>${qna.qnaNo}</td>
					<td>${qna.customerId}</td>
					<td><a href="${pageContext.request.contextPath}/AdminQnaOneController?qnaNo=${qna.qnaNo}">${qna.qnaTitle}</a></td>
					<td>${qna.createDate}</td>
					<td>${qna.updateDate}</td>
					<td>
					<!-- 미등록 답변은 INSERT로 표시, 등록된 답변은 UPDATE로 표시 -->
						<c:choose>
							<c:when test="${qna.qnaAnswer == null}">
								<a href="${pageContext.request.contextPath}/AdminQnaOneController?qnaNo=${qna.qnaNo}" class="text-danger">INSERT</a>
							</c:when>
							<c:otherwise>
								<a href="${pageContext.request.contextPath}/AdminQnaOneController?qnaNo=${qna.qnaNo}" >UPDATE</a>
							</c:otherwise>
						</c:choose>
					</td>
					</tr>
			</c:forEach>
          </tbody>
        </table>
      <!-- end content -->
      </div>
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