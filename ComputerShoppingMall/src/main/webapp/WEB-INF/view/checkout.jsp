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

  <section class="post-wrapper-top">
    <div class="container">
      <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
        <ul class="breadcrumb">
          <li><a href="${pageContext.request.contextPath}/IndexController">Home</a></li>
          <li>Checkout</li>
        </ul>
        <h2>CHECK OUT</h2>
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
      <div class="content col-lg-12 col-md-12 col-sm-12 col-xs-12 clearfix">
			<table class="table table-striped checkout" data-effect="fade">
				<thead>
            <tr>
              <th>주문 번호</th>
              <th>부품 이름</th>
              <th>부품 번호</th>
              <th>가격</th>
              <th>수량</th>
              <th>주문날짜</th>
            </tr>
          </thead>
          <tbody>
          <c:forEach var="checkout" items="${CheckoutList}">
          	<tr>
				<td>${checkout.orderNo}</td>
				<td>${checkout.categoryName}</td>
				<td>${checkout.categoryNumber}</td>
				<td>${checkout.categoryPrice}</td>
				<td>${checkout.categoryQuantity}</td>	
				<td>${checkout.createDate}</td>		
			</tr>	
          </c:forEach>
          </tbody>
			</table>
   
        <div class="well text-right"><strong>TOTAL: $18.00</strong></div>

        <div class="clearfix"></div>

        <div class="clearfix"></div>
        <div class="divider"></div>
          
          	<h5 class="title">무통장입금</h5>
		
		<label for="">다음 질문 중 하나라도 해당하는 경우 입금하지 말고 즉시 경찰서에 신고하시기 바랍니다.</label>
		  <div>1. 다른 사람으로부터 상품권 구매로 일부 또는 전체 금액을 입금받기로 했습니까?</div>
		  <div>2. 상품권 일부 또는 전체를 대리구매하여 카카오톡 등 메신저로 다른 사람에게 주기로 했습니까?</div>
		  <div>3. 네이트온/카카오톡 등 메신저에서 지인이 급한 돈이 필요하다고 상품권을 요구했습니까?</div>
		  <div>4. 중고나라 또는 번개장터에서 물품대금을 현금 대신 상품권으로 요구 받았습니까?</div>
		  <div>5. 본인이 직접 게임 또는 쇼핑에 사용하기 위한 목적이 아닙니까?</div>
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
      
           <a href="${pageContext.request.contextPath}/WEB-INF/view/order.jsp" class="button large btn-block">입금 완료</a>

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