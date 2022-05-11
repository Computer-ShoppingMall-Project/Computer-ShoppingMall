<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>MaxiBiz Bootstrap Business Template</title>
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <meta content="" name="keywords">
  <meta content="" name="description">

  <!-- Favicons -->
  <link href="view/img/favicon.png" rel="icon">
  <link href="view/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Ruda:400,900,700" rel="stylesheet">

  <!-- Bootstrap CSS File -->
  <link href="view/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Libraries CSS Files -->
  <link href="view/lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="view/lib/prettyphoto/css/prettyphoto.css" rel="stylesheet">
  <link href="view/lib/hover/hoverex-all.css" rel="stylesheet">
  <link href="view/lib/jetmenu/jetmenu.css" rel="stylesheet">
  <link href="view/lib/owl-carousel/owl-carousel.css" rel="stylesheet">

  <!-- Main Stylesheet File -->
  <link href="view/css/style.css" rel="stylesheet">
  <link rel="stylesheet" href="view/css/colors/blue.css">

  <!-- =======================================================
    Template Name: MaxiBiz
    Template URL: https://templatemag.com/maxibiz-bootstrap-business-template/
    Author: TemplateMag.com
    License: https://templatemag.com/license/
  ======================================================= -->
</head>
<body>
  <div class="topbar clearfix">
    <div class="container">
      <div class="col-lg-12 text-right">
        <div class="social_buttons">
	         <a href="index.jsp" data-toggle="tooltip" data-placement="bottom">Logout</a>
        </div>
      </div>
    </div>
    <!-- end container -->
  </div>
  <!-- end topbar -->

  <header class="header">
    <div class="container">
      <div class="site-header clearfix">
        <div class="col-lg-3 col-md-3 col-sm-12 title-area">
          <div class="site-title" id="title">
            <a href="index.jsp" title="">
              <h4>MAXI<span>BIZ</span></h4>
            </a>
          </div>
        </div>
        <!-- title area -->
        <div class="col-lg-9 col-md-12 col-sm-12">
          <div id="nav" class="right">
            <div class="container clearfix">
              <ul id="jetmenu" class="jetmenu blue">
                <li><a href="index.jsp">Home</a>
                </li>
                <li class="active"><a href="#">Pages</a>
                  <ul class="dropdown">
                    <li><a href="404.jsp">404 Error</a></li>
                    <li><a href="left-sidebar.jsp">Left Sidebar</a></li>
                    <li><a href="login.jsp">Login</a></li>
                    <li><a href="register.jsp">Register</a></li>
                    <li><a href="contact.jsp">Contact</a></li>
                  </ul>
                </li>
                <li><a href="#">Shop</a>
                  <ul class="dropdown">
                    <li><a href="digital-download.jsp">Products Page</a></li>
                    <li><a href="single-product.jsp">Single Product</a></li>
                    <li><a href="checkout.jsp">Checkout</a></li>
                    <li><a href="account.jsp">Account Page</a></li>
                    <li><a href="support.jsp">Support Center</a></li>
                  </ul>
                </li>
                <li><a href="#">Portfolio</a>
                  <ul class="dropdown">
                    <li><a href="portfolio-2.jsp">Portfolio (2 Columns)</a></li>
                    <li><a href="portfolio-3.jsp">Portfolio (3 Columns)</a></li>
                  </ul>
                </li>
                <li><a href="#">Blog</a>
                  <ul class="dropdown">
                    <li><a href="single-with-sidebar.jsp">Single with Sidebar</a></li>
                  </ul>
                </li>
              </ul>
            </div>
          </div>
          <!-- nav -->
        </div>
        <!-- title area -->
      </div>
      <!-- site header -->
    </div>
    <!-- end container -->
  </header>
  <!-- end header -->

  <section class="section1">
    <div class="container clearfix">
      <div class="content col-lg-12 col-md-12 col-sm-12 clearfix">
        <div class="col-lg-6 col-md-6 col-sm-6">
        <!-- 고객문의 폼 -->
          <h4 class="title">Contact Form</h4>
          <div id="message"></div>
          <form class="contact-form php-mail-form" role="form" action="contactform/contactform.php" method="POST">

            <div class="form-group">
              <input type="text" name="customerId" class="form-control" id="customerId" readonly="readonly">
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
              <textarea class="form-control text-center" name="qnaAnswer" id="qnaAnswer" rows="5" data-rule="required" data-msg="Please write something message" readonly="readonly">답변이 등록되지 않았습니다.</textarea>
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

  <footer class="footer">
    <div class="container">
      <div class="widget col-lg-3 col-md-3 col-sm-12">
        <h4 class="title">About us</h4>
        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry"s standard dummy text ever since the 1500s..</p>
        <a class="button small" href="#">read more</a>
      </div>
      <!-- end widget -->
      <div class="widget col-lg-3 col-md-3 col-sm-12">
        <h4 class="title">Recent Posts</h4>
        <ul class="recent_posts">
          <li>
            <a href="home1.jsp#">
						<img src="view/img/recent_post_01.png" alt="" />Our New Dashboard Is Here</a>
            <a class="readmore" href="#">read more</a>
          </li>
          <li>
            <a href="home1.jsp#">
						<img src="view/img/recent_post_02.png" alt="" />Design Is In The Air</a>
            <a class="readmore" href="#">read more</a>
          </li>
        </ul>
        <!-- recent posts -->
      </div>
      <!-- end widget -->
      <div class="widget col-lg-3 col-md-3 col-sm-12">
        <h4 class="title">Get In Touch</h4>
        <ul class="contact_details">
          <li><i class="fa fa-envelope-o"></i> info@yoursite.com</li>
          <li><i class="fa fa-phone-square"></i> +34 5565 6555</li>
          <li><i class="fa fa-home"></i> Some Fine Address, 887, Madrid, Spain.</li>
          <li><a href="#"><i class="fa fa-map-marker"></i> View large map</a></li>
        </ul>
        <!-- contact_details -->
      </div>
      <!-- end widget -->
      <div class="widget col-lg-3 col-md-3 col-sm-12">
        <h4 class="title">Flickr Stream</h4>
        <ul class="flickr">
          <li><a href="#"><img alt="" src="view/img/flickr_01.jpg"></a></li>
          <li><a href="#"><img alt="" src="view/img/flickr_02.jpg"></a></li>
          <li><a href="#"><img alt="" src="view/img/flickr_03.jpg"></a></li>
          <li><a href="#"><img alt="" src="view/img/flickr_04.jpg"></a></li>
          <li><a href="#"><img alt="" src="view/img/flickr_05.jpg"></a></li>
          <li><a href="#"><img alt="" src="view/img/flickr_06.jpg"></a></li>
          <li><a href="#"><img alt="" src="view/img/flickr_07.jpg"></a></li>
          <li><a href="#"><img alt="" src="view/img/flickr_08.jpg"></a></li>
        </ul>
      </div>
      <!-- end widget -->
    </div>
    <!-- end container -->

    <div class="copyrights">
      <div class="container">
        <div class="col-lg-6 col-md-6 col-sm-12 columns footer-left">
          <p>Copyright © 2014 - All rights reserved.</p>
          <div class="credits">
            <!--
              You are NOT allowed to delete the credit link to TemplateMag with free version.
              You can delete the credit link only if you bought the pro version.
              Buy the pro version with working PHP/AJAX contact form: https://templatemag.com/maxibiz-bootstrap-business-template/
              Licensing information: https://templatemag.com/license/
            -->
            Created with MaxiBiz template by <a href="https://templatemag.com/">TemplateMag</a>
          </div>
        </div>
        <!-- end widget -->
        <div class="col-lg-6 col-md-6 col-sm-12 columns text-right">
          <div class="footer-menu right">
            <ul class="menu">
              <li><a href="index.jsp">Home</a></li>
              <li><a href="about.jsp">About</a></li>
              <li><a href="#">Sitemap</a></li>
              <li><a href="#">Site Terms</a></li>
              <li><a href="contact">Contact</a></li>
            </ul>
          </div>
        </div>
        <!-- end large-6 -->
      </div>
      <!-- end container -->
    </div>
    <!-- end copyrights -->
  </footer>
  <!-- end footer -->
  <div class="dmtop">Scroll to Top</div>

  <!-- JavaScript Libraries -->
  <script src="view/lib/jquery/jquery.min.js"></script>
  <script src="view/lib/bootstrap/js/bootstrap.min.js"></script>
  <script src="view/lib/php-mail-form/validate.js"></script>
  <script src="view/lib/prettyphoto/js/prettyphoto.js"></script>
  <script src="view/lib/isotope/isotope.min.js"></script>
  <script src="view/lib/hover/hoverdir.js"></script>
  <script src="view/lib/hover/hoverex.min.js"></script>
  <script src="view/lib/unveil-effects/unveil-effects.js"></script>
  <script src="view/lib/owl-carousel/owl-carousel.js"></script>
  <script src="view/lib/jetmenu/jetmenu.js"></script>
  <script src="view/lib/animate-enhanced/animate-enhanced.min.js"></script>
  <script src="view/lib/jigowatt/jigowatt.js"></script>
  <script src="view/lib/easypiechart/easypiechart.min.js"></script>

  <!-- Template Main Javascript File -->
  <script src="view/js/main.js"></script>
</body>
</html>