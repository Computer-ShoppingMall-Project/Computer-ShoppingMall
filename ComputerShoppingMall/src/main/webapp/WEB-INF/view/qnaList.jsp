<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>MaxiBiz Bootstrap Business Template</title>
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
  <!-- header적용 -->
  <jsp:include page="header.jsp"></jsp:include>

  <section class="post-wrapper-top">
    <div class="container">
      <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
        <ul class="breadcrumb">
          <li><a href="${pageContext.request.contextPath}/IndexController">Home</a></li>
          <li>QNA</li>
        </ul>
        <h2>QNA</h2>
      </div>
    </div>
  </section>
  <!-- end post-wrapper-top -->
  <section class="section1">
    <div class="container clearfix">
      <div class="content col-lg-8 col-md-8 col-sm-8 col-xs-12 clearfix">
        <div class="clearfix"></div>
        <a href="${pageContext.request.contextPath}/InsertQnaController">write</a>
        <hr>
        <table class="table table-striped" data-effect="fade">
          <thead>
            <tr>
              <th>NO</th>
              <th>TITLE</th>
              <th>DATE</th>
              <th>ANSWER</th>
            </tr>
          </thead>
          <tbody>
          <c:forEach var="qna" items="${qnaList}">
          	<tr>
				<td>${qna.qnaNo}</td>
				<td><a href="${pageContext.request.contextPath}/QnaOneController?qnaNo=${qna.qnaNo}">${qna.qnaTitle}</a></td>
				<td>${qna.createDate}</td>
				<td>${qna.qnaAnswer}</td>	
			</tr>	
          </c:forEach>
          </tbody>
        </table>

      </div>
      <!-- end content -->

      <div id="sidebar" class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
        </div>
        	<br><br><br><br><hr>
        	<h4>contact information</h4>
          <ul class="contact_details">
            <li><i class="fa fa-envelope-o"></i> redteam@github.com</li>
            <li><i class="fa fa-phone-square"></i> +34 5565 6555</li>
            <li><i class="fa fa-home"></i> Goodee Academy, Seoul, Korea.</li>
          </ul>
         	 <hr>
          <!-- contact_details -->
        </div>


      </div>
      <!-- end sidebar -->
    </div>
    <!-- end container -->
  </section>
  <!-- end section -->

  <!-- footer적용 -->
  <jsp:include page="footer.jsp"></jsp:include>
  
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