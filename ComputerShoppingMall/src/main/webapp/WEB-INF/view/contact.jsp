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
  <!-- header적용 -->
  <jsp:include page="/WEB-INF/banner/header.jsp"></jsp:include>

  <section class="section1">
    <div class="container clearfix">
      <div class="content col-lg-12 col-md-12 col-sm-12 clearfix">
        <div class="col-lg-6 col-md-6 col-sm-6">
        <!-- 고객문의 폼 -->
          <h4 class="title">QNA</h4>
          <div id="message"></div>
          <form class="contact-form php-mail-form" role="form" action="${pageContext.request.contextPath}/InsertQnaController" method="POST">

            <div class="form-group">
              <input type="text" name="customerId" class="form-control" id="customerId">
              <div class="validate"></div>
            </div>
            <div class="form-group">
              <input type="text" name="qnaTitle" class="form-control" id="qnaTitle" placeholder="QNA title" data-rule="required" data-msg="Please enter a valid title">
              <div class="validate"></div>
            </div>
            <div class="form-group">
              <textarea class="form-control" name="qnaContent" id="qnaContent" placeholder="Contact Message" rows="5" data-rule="required" data-msg="Please write something for us"></textarea>
              <div class="validate"></div>
            </div>

            <div class="loading"></div>
            <div class="error-message"></div>
            <div class="sent-message">Your question has been sent. Thank you!</div>

            <div class="form-send">
              <button type="submit" class="btn btn-large btn-primary">Send</button>
            </div>

          </form>
        </div>

        <div class="col-lg-6 col-md-6 col-sm-6">
          <h4 class="title">Answer</h4>
          <div class="form-group">
              <textarea class="form-control text-center" name="qnaAnswer" id="qnaAnswer" rows="5" data-rule="required" data-msg="Please write something message" readonly="readonly">Your answer is not registered</textarea>
              <div class="validate"></div>
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