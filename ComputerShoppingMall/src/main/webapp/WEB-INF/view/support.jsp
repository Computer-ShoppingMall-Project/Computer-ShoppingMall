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
  <link href="css/colors/blue.css" rel="stylesheet">
  <link href="css/bbpress.css" rel="stylesheet">

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
          <li><a href="index.jsp">Home</a></li>
          <li>Support Center</li>
        </ul>
        <h2>SUPPORT CENTER</h2>
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
          <div class="dmbox">
            <div class="service-icon">
              <div class="dm-icon-effect-1" data-effect="slide-bottom">
                <a class="" href="#"><i class="dm-icon fa fa-question fa-3x"></i></a>
              </div>
            </div>
            <h4>1. Knowledge-Base</h4>
            <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
          </div>
        </div>
        <!-- end dmbox -->

        <div class="col-lg-4 col-md-4 col-sm-12">
          <div class="dmbox">
            <div class="service-icon">
              <div class="dm-icon-effect-1" data-effect="slide-bottom">
                <a class="" href="#"><i class="dm-icon fa fa-envelope-o fa-3x"></i></a>
              </div>
            </div>
            <h4>2. Report a Bug</h4>
            <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
          </div>
        </div>
        <!-- end dmbox -->

        <div class="col-lg-4 col-md-4 col-sm-12">
          <div class="dmbox">
            <div class="service-icon">
              <div class="dm-icon-effect-1" data-effect="slide-bottom">
                <a class="" href="#"><i class="dm-icon fa fa-random fa-3x"></i></a>
              </div>
            </div>
            <h4>3. Submit a Ticket</h4>
            <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
          </div>
        </div>
        <!-- end dmbox -->

        <div class="clearfix"></div>
        <div class="divider"></div>

        <div class="general-title text-center">
          <h3>Support Forum</h3>
          <p>We are here to help you with everything regarding your product.</p>
          <hr>
        </div>

        <div class="text-center">
          <form id="bbsearch" class="form-inline">
            <input type="text" class="form-control" placeholder="Search on support forums">
            <button type="submit" class="btn btn-primary">Search</button>
          </form>
        </div>

        <div class="clearfix"></div>
        <div class="divider"></div>

        <div id="bbpress-forums">
          <ul class="bbp-forums">
            <li class="bbp-header">
              <ul class="forum-titles">
                <li class="bbp-forum-info">Forums</li>
                <li class="bbp-forum-topic-count">Topics</li>
                <li class="bbp-forum-reply-count">Posts</li>
                <li class="bbp-forum-freshness">Freshness</li>
              </ul>
            </li>
            <!-- .bbp-header -->

            <li class="bbp-body">
              <ul class="forum type-forum status-publish hentry loop-item-0 odd bbp-forum-status-open bbp-forum-visibility-publish">
                <li class="bbp-forum-info">
                  <a class="bbp-forum-title" href="support.jsp#" title="General">General Forums</a>
                  <div class="bbp-forum-content">Lorem Ipsum is simply dummy text of the printing and typesetting industry.</div>
                </li>
                <li class="bbp-forum-topic-count">18</li>
                <li class="bbp-forum-reply-count">190</li>
                <li class="bbp-forum-freshness">
                  <a href="#" title="Reply To: Please NOTIFY YOUR CUSTOMERS of UPDATES">2 days, 7 hours ago</a>
                  <p class="bbp-topic-meta">
                    <span class="bbp-topic-freshness-author">
                                            <a href="#" title="View admin profile" class="bbp-author-avatar" rel="nofollow">
                                                <img alt="" src="http://0.gravatar.com/avatar/0d91c692acdcc514b006840d870dd4a6?s=14&d=http://0.gravatar.com/avatar/ad516503a11cd5ca435acc9bb6523536?s=14&r=G" class="avatar" height="20" width="20" />
                                            </a>&nbsp;<a href="#" title="View admin profile" class="bbp-author-name" rel="nofollow">Matt Stinson</a>
                                        </span>
                  </p>
                </li>
              </ul>
              <!-- end bbp forums -->
            </li>

            <li class="bbp-body">
              <ul class="forum type-forum status-publish hentry loop-item-0 odd bbp-forum-status-open bbp-forum-visibility-publish">
                <li class="bbp-forum-info">
                  <a class="bbp-forum-title" href="support.jsp#" title="General">Site Feedback</a>
                  <div class="bbp-forum-content">Lorem Ipsum is simply dummy text of the printing and typesetting industry.</div>
                </li>
                <li class="bbp-forum-topic-count">55</li>
                <li class="bbp-forum-reply-count">2,997</li>
                <li class="bbp-forum-freshness">
                  <a href="support.jsp#" title="Reply To: Please NOTIFY YOUR CUSTOMERS of UPDATES">2 days, 7 hours ago</a>
                  <p class="bbp-topic-meta">
                    <span class="bbp-topic-freshness-author">
                                            <a href="#" title="View admin profile" class="bbp-author-avatar" rel="nofollow">
                                                <img alt="" src="http://0.gravatar.com/avatar/0d91c692acdcc514b006840d870dd4a6?s=14&d=http://0.gravatar.com/avatar/ad516503a11cd5ca435acc9bb6523536?s=14&r=G" class="avatar" height="20" width="20" />
                                            </a>&nbsp;<a href="#" title="View admin profile" class="bbp-author-name" rel="nofollow">Matt Stinson</a>
                                        </span>
                  </p>
                </li>
              </ul>
              <!-- end bbp forums -->
            </li>

            <li class="bbp-body">
              <ul class="forum type-forum status-publish hentry loop-item-0 odd bbp-forum-status-open bbp-forum-visibility-publish">
                <li class="bbp-forum-info">
                  <a class="bbp-forum-title" href="support.jsp#" title="General">Pre-Sale Questions</a>
                  <div class="bbp-forum-content">Lorem Ipsum is simply dummy text of the printing and typesetting industry.</div>
                </li>
                <li class="bbp-forum-topic-count">75</li>
                <li class="bbp-forum-reply-count">2,188</li>
                <li class="bbp-forum-freshness">
                  <a href="support.jsp#" title="Reply To: Please NOTIFY YOUR CUSTOMERS of UPDATES">2 days, 7 hours ago</a>
                  <p class="bbp-topic-meta">
                    <span class="bbp-topic-freshness-author">
                                            <a href="#" title="View admin profile" class="bbp-author-avatar" rel="nofollow">
                                                <img alt="" src="http://0.gravatar.com/avatar/0d91c692acdcc514b006840d870dd4a6?s=14&d=http://0.gravatar.com/avatar/ad516503a11cd5ca435acc9bb6523536?s=14&r=G" class="avatar" height="20" width="20" />
                                            </a>&nbsp;<a href="#" title="View admin profile" class="bbp-author-name" rel="nofollow">Matt Stinson</a>
                                        </span>
                  </p>
                </li>
              </ul>
              <!-- end bbp forums -->
            </li>

            <li class="bbp-body">
              <ul class="forum type-forum status-publish hentry loop-item-0 odd bbp-forum-status-open bbp-forum-visibility-publish">
                <li class="bbp-forum-info">
                  <a class="bbp-forum-title" href="support.jsp#" title="General">Item Support</a>
                  <div class="bbp-forum-content">Lorem Ipsum is simply dummy text of the printing and typesetting industry.</div>
                </li>
                <li class="bbp-forum-topic-count">1287</li>
                <li class="bbp-forum-reply-count">8,553</li>
                <li class="bbp-forum-freshness">
                  <a href="support.jsp#" title="Reply To: Please NOTIFY YOUR CUSTOMERS of UPDATES">2 days, 7 hours ago</a>
                  <p class="bbp-topic-meta">
                    <span class="bbp-topic-freshness-author">
                                            <a href="#" title="View admin profile" class="bbp-author-avatar" rel="nofollow">
                                                <img alt="" src="http://0.gravatar.com/avatar/0d91c692acdcc514b006840d870dd4a6?s=14&d=http://0.gravatar.com/avatar/ad516503a11cd5ca435acc9bb6523536?s=14&r=G" class="avatar" height="20" width="20" />
                                            </a>&nbsp;<a href="#" title="View admin profile" class="bbp-author-name" rel="nofollow">Matt Stinson</a>
                                        </span>
                  </p>
                </li>
              </ul>
              <!-- end bbp forums -->
            </li>

            <li class="bbp-body">
              <ul class="forum type-forum status-publish hentry loop-item-0 odd bbp-forum-status-open bbp-forum-visibility-publish">
                <li class="bbp-forum-info">
                  <a class="bbp-forum-title" href="support.jsp#" title="General">Global off topic</a>
                  <div class="bbp-forum-content">Lorem Ipsum is simply dummy text of the printing and typesetting industry.</div>
                </li>
                <li class="bbp-forum-topic-count">214</li>
                <li class="bbp-forum-reply-count">2,698</li>
                <li class="bbp-forum-freshness">
                  <a href="support.jsp#" title="Reply To: Please NOTIFY YOUR CUSTOMERS of UPDATES">2 days, 7 hours ago</a>
                  <p class="bbp-topic-meta">
                    <span class="bbp-topic-freshness-author">
                                            <a href="#" title="View admin profile" class="bbp-author-avatar" rel="nofollow">
                                                <img alt="" src="http://0.gravatar.com/avatar/0d91c692acdcc514b006840d870dd4a6?s=14&d=http://0.gravatar.com/avatar/ad516503a11cd5ca435acc9bb6523536?s=14&r=G" class="avatar" height="20" width="20" />
                                            </a>&nbsp;<a href="#" title="View admin profile" class="bbp-author-name" rel="nofollow">Matt Stinson</a>
                                        </span>
                  </p>
                </li>
              </ul>
              <!-- end bbp forums -->
            </li>
          </ul>
          <!-- .forums-directory -->
        </div>
        <!-- /bbpress -->

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