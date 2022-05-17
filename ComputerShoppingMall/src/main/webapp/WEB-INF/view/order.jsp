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
          <li>Order</li>
        </ul>
        <h2>Order</h2>
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
	<!-- customerId -->
  <section class="section1">
    <div class="container clearfix">
			<h5 class="title">PERSONAL INFORMATION</h5>

        <form id="personalinfo" action="${pageContext.request.contextPath}/OrderController" name="personalinfo" method="post">
   		 <div class="content col-lg-12 col-md-12 col-sm-12 col-xs-12 clearfix">
          <label for="email">Name <span class="required">*</span></label>
          	<input type="text" name="name" id="name" class="form-control" value="${sessionCustomerId}">
          <label for="fname">Email <span class="required">*</span></label>
          	<input type="text" name="email" id="email" class="form-control" value="${requestScope.customer.email}">
          <label for="lname">PHONE </label>
        	  <input type="text" name="lname" id="lname" class="form-control"value="${requestScope.customer.phone}">
		</div>     
    	<div class="col-lg-1 col-md-4 col-sm-12">
          <label for="lname">Zip_Code </label>
        	  <input type="text" name="ZipCode" id="Zip_Code" class="form-control" value="${requestScope.customer.zipCode}" >
		</div>      
		<div class="col-lg-4 col-md-4 col-sm-12">
          <label for="lname">Road_Address </label>
         	 <input type="text" name="roadAddress" id="roadAddress" class="form-control" value="${requestScope.customer.roadAddress}">
    	</div>
   		<div class="col-lg-4 col-md-4 col-sm-12">
          <label for="lname">Detail_Address </label>
        	  <input type="text" name="detailAddress" id="detailAddress" class="form-control" value="${requestScope.customer.detailAddress}">
		</div>
	<!-- customerId end -->
        <div class="clearfix"></div>
        <div class="divider"></div>
  
        <hr>
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
          		<td>${basket.categoryName}</td>
          		<td>${basket.categoryPrice}</td>
          		<td>${basket.categoryQuantity}</td>
          	</tr>
          </c:forEach>
          </tbody>
        </table>
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