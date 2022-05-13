<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.Checkout"%>
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
<%
	// request controller
	ArrayList<Checkout> list = (ArrayList<Checkout>)request.getAttribute("list");
%>
  <!-- header적용 -->
  <jsp:include page="header.jsp"></jsp:include>

  <section class="post-wrapper-top">
    <div class="container">
      <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
        <ul class="breadcrumb">
          <li><a href="index.jsp">Home</a></li>
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
      <div class="content col-lg-8 col-md-8 col-sm-8 col-xs-12 clearfix">

        <table class="table table-striped checkout" data-effect="fade">
					<thead>
						<tr>
							<th>주문 번호</th>
							<th>부품 이름</th>
							<th>부품 번호</th>
							<th>가격</th>
							<th>수량</th>
							<th>저장날짜</th>
						</tr>
					</thead>
					<%
						for (Checkout checkout : list) {
					%>
					<tbody>
						<tr>
							<td><%=checkout.getOrderNo()%></td>
							<td><%=checkout.getCategoryName()%></td>
							<td><%=checkout.getCategoryNumber()%></td>
							<td><%=checkout.getCategoryPrice()%></td>
							<td><%=checkout.getCategoryQuantity()%></td>
							<td><%=checkout.getCreateDate()%></td>
						<%
							}
						%>

					</tbody>
				</table>
        <div class="clearfix"></div>

        <div class="pull-right">
          <a class="button" href="#">UPDATE CART</a> <a class="button" href="#">SAVE CART</a>
        </div>

        <div class="clearfix"></div>

        <div class="well text-right"><strong>TOTAL: $18.00</strong></div>

        <div class="clearfix"></div>

        <div class="payments">
          <p><img alt="" src="img/payments.png"></p>

          <label class="checkbox-inline">
                <input id="inlineCheckbox1" type="checkbox" value="option1">
                <strong>PAYPAL</strong>
                </label>
          <label class="checkbox-inline">
                <input id="inlineCheckbox2" type="checkbox" value="option2">
                <strong>CREDIT CARD</strong>
                </label>
        </div>

        <div class="clearfix"></div>
        <div class="divider"></div>

        <h5 class="title">PERSONAL INFORMATION</h5>

        <form id="personalinfo" action="" name="personalinfo" method="post">
          <label for="email">Email Address <span class="required">*</span></label>
          <input type="text" name="name" id="email" class="form-control" placeholder="example@yoursite.com">
          <label for="fname">First Name <span class="required">*</span></label>
          <input type="text" name="fname" id="fname" class="form-control" placeholder="John">
          <label for="lname">Last Name </label>
          <input type="text" name="lname" id="lname" class="form-control" placeholder="DOE">
        </form>

        <div class="clearfix"></div>
        <div class="divider"></div>

        <h5 class="title">CART DETAILS</h5>

        <form id="cartinfo" action="" name="cartinfo" method="post">
          <label for="cardnumber">Card Number <span class="required">*</span></label>
          <input type="text" name="cardnumber" id="cardnumber" class="form-control" placeholder="Your card number">
          <label for="cvc">CVC <span class="required">*</span></label>
          <input type="text" name="cvc" id="cvc" class="form-control" placeholder="Security code">
          <label for="ncard">Name on the Card <span class="required">*</span></label>
          <input type="text" name="ncard" id="ncard" class="form-control" placeholder="Name on the card">
          <label for="ncard">Expiration (MM/YY) <span class="required">*</span></label>

          <div class="clearfix"></div>

          <select class="form-control" style="width:75px; float:left; margin-right:10px;">
					<option>01</option>
					<option>02</option>
					<option>03</option>
					<option>04</option>
					<option>05</option>
					<option>06</option>
					<option>07</option>
					<option>08</option>
					<option>09</option>
					<option>10</option>
					<option>11</option>
					<option>12</option>
				</select>
          <select class="form-control" style="width:75px;float:left">
					<option>14</option>
					<option>15</option>
					<option>16</option>
					<option>17</option>
					<option>18</option>
					<option>19</option>
				</select>
        </form>

        <div class="clearfix"></div>
        <div class="divider"></div>

        <h5 class="title">BILLING INFORMATION</h5>

        <form id="billinginfo" action="" name="billinginfo" method="post">
          <label for="baddress">Billing Address 1</label>
          <input type="text" name="baddress" id="baddress" class="form-control" placeholder="Address line 1">
          <label for="baddress1">Billing Address 2 (Optional)</label>
          <input type="text" name="baddress1" id="baddress1" class="form-control" placeholder="Address line 2">
          <label for="bcity">Billing City</label>
          <input type="text" name="bcity" id="bcity" class="form-control" placeholder="Your city">
          <label for="bzip">Zip / Postal Code </label>
          <input type="text" name="bzip" id="bzip" class="form-control" placeholder="Your ZIP or postal code">

          <div class="clearfix"></div>

          <select class="form-control">
					<option>United States</option>
					<option>Spain</option>
					<option>United Kingdom</option>
					<option>France</option>
					<option>Japan</option>
					<option>Brazil</option>
					<option>Other Country</option>
				</select>
          <select class="form-control">
					<option>Alabama</option>
					<option>Other City</option>
					<option>Other City</option>
					<option>Other City</option>
					<option>Other City</option>
					<option>Other City</option>
					<option>Other City</option>
					<option>Other City</option>
				</select>
          <br>
          <div class="clearfix"></div>
          <button class="button">SHOW TERMS</button>
          <div class="clearfix"></div>

          <label class="checkbox-inline">
                    <input id="inlineCheckbox3" type="checkbox" value="option1">
                    <strong>AGREE TO TERMS</strong>
                </label>

          <br><br>
          <div class="well"><strong>PURCHASE TOTAL:</strong> $18.00</div>
          <br>
          <button class="button large btn-block">PURCHASE THIS ITEM</button>
        </form>

      </div>
      <!-- end content -->

      <div id="sidebar" class="col-lg-4 col-md-4 col-sm-4 col-xs-12">

        <div class="widget">
          <h4 class="title">
                        <span>Subscribe</span>
                    </h4>
          <form id="subscribe" action="mc.php" name="subscribe" method="post">
            <input type="text" name="name" id="name" class="form-control" placeholder="Name">
            <input type="text" name="email" id="email" class="form-control" placeholder="Email">
            <div class="pull-right">
              <input type="submit" value="Subscribe" id="submit" class="button">
            </div>
          </form>
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