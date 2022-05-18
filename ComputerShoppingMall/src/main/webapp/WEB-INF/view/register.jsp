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
<%
   // error 메세지 값 받기 코드
   String msg = "";
   if(request.getParameter("msg") != null){
      if(request.getParameter("msg").equals("notMatch")){
         msg = "Please check your password again";
      }
   }
%>
  <!-- header적용. -->
  <jsp:include page="/WEB-INF/banner/header.jsp"></jsp:include>

  <section class="post-wrapper-top">
    <div class="container">
      <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
        <ul class="breadcrumb">
          <li><a href="index.jsp">Home</a></li>
          <li>Register</li>
        </ul>
        <h2>REGISTER</h2>
      </div>
      <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
        <!-- search -->
        <div class="search-bar">
          <form action="" method="get">
            <fieldset>
              <input type="image" src="img/pixel.gif" class="searchsubmit" alt="" />
              <input type="text" class="search_text showtextback" name="s" id="s" value="Search..." />
            </fieldset>
          </form>
        </div>
        <!-- / end div .search-bar -->
      </div>
    </div>
  </section>
  <!-- end post-wrapper-top -->

  <section class="section1">
    <div class="container clearfix">
      <div class="content col-lg-12 col-md-12 col-sm-12 clearfix">
        <div class="col-lg-4 col-md-4 col-sm-12">
          <h4 class="title">
                       <span>Why Join Us?</span>
                    </h4>
          <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry"s standard dummy text ever since the 1500s..</p>
          <p>It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
        </div>

        <div class="col-lg-4 col-md-4 col-sm-12">
          <h4 class="title">
                       <span>Benefits</span>
                    </h4>
          <ul class="check">
            <li><a href="#">5+ homepage style (check features menu)</a></li>
            <li><a href="#">Compatible any eCommerce solutions</a></li>
            <li><a href="#">Limitless color combinations</a></li>
            <li><a href="#">Limitless page templates (15+ custom pages)</a></li>
            <li><a href="#">100% responsive layout design</a></li>
            <li><a href="#">Awesome slideshows for your contents</a></li>
            <li><a href="#">Super awesome portfolio sections</a></li>
            <li><a href="#">700+ custom font icons included</a></li>
          </ul>
        </div>
        <!-- end login -->

        <div class="col-lg-4 col-md-4 col-sm-12">
          <h4 class="title">
                       <span>Register Form</span>
          </h4>
          <h2><%=msg%></h2>
          <form id="registerform" method="post" name="registerform" action="<%=request.getContextPath()%>/InsertMemberController">
            <div class="form-group">
              <input type="text" name="customerId" class="form-control" placeholder="ID">
            </div>
             <div class="form-group">
              <input type="password" name="customerPw1" class="form-control" placeholder="Password">
            </div>
            <div class="form-group">
              <input type="password" name="customerPw2" class="form-control" placeholder="Re-enter password">
            </div>
            <div class="form-group">
              <input type="text" name="name" class="form-control" placeholder="Name">
            </div>
             <div class="form-group">
              <input type="text" name="nickname" class="form-control" placeholder="Nickname">
            </div>
            <div class="form-group">
              <input type="email" name="email" class="form-control" placeholder="Email">
            </div>
            <div class="form-group">
              <input type="number" name="phone" class="form-control" placeholder="Phone number">
            </div>
            <div class="form-group">
              <input type="number" name="addressId" class="form-control" placeholder="Address">
            </div>
            <div class="form-group">
              <input type="text" name="detailAddress" class="form-control" placeholder="Detail address">
            </div>
            <div class="form-group">
              <input type="submit" class="button" value="Register an account">
            </div>
          </form>
        </div>
        <!-- end register -->
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