<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <div class="topbar clearfix">
    <div class="container">
      <div class="col-lg-10 text-right">
        <div class="social_buttons">
          <a href="index.jsp" data-toggle="tooltip" data-placement="bottom">Login</a>
      </div>
    </div>
    <div class="col-lg-1 text-right">
    </div>
      <div class="social_buttons">
          <a href="<%=request.getContextPath()%>/SelectMemberOneController" data-toggle="tooltip" data-placement="bottom"><%=session.getAttribute("sessionCustomerId") %></a>
      </div>
    <!-- end container -->
  	</div>
  </div>
  <!-- end topbar -->
  <header class="header">
    <div class="container">
      <div class="site-header clearfix">
        <div class="col-lg-3 col-md-3 col-sm-14 title-area">
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
                <li><a href="IndexController">Home</a>
                </li>
                <li class="active"><a href="#">Pages</a>
                  <ul class="dropdown">
                    <li><a href="Controller404">404 Error</a></li>
                    <li><a href="leftSidebarController">Left Sidebar</a></li>
                    <li><a href="LoginController">Login</a></li>
                    <li><a href="RegisterController">Register</a></li>
                    <li><a href="QnaListController">QNA</a></li>
                  </ul>
                </li>
                <li><a href="#">Shop</a>
                  <ul class="dropdown">
                    <li><a href="DigitalDownloadController">Products Page</a></li>
                    <li><a href="SingleProductController">Single Product</a></li>
                    <li><a href="CheckoutController">Checkout</a></li>
                    <li><a href="AccountController">Account Page</a></li>
                    <li><a href="SupportController">Support Center</a></li>
                  </ul>
                </li>
                <li><a href="#">Portfolio</a>
                  <ul class="dropdown">
                    <li><a href="PortfolioController">Portfolio (2 Columns)</a></li>
                    <li><a href="PortfolioController">Portfolio (3 Columns)</a></li>
                  </ul>
                </li>
                <li><a href="#">Blog</a>
                  <ul class="dropdown">
                    <li><a href="single-with-sidebarController">Single with Sidebar</a></li>
                </li>
                  </ul>
                  <li><a href="#">ProductInsert</a>
                  <ul class="dropdown">
                    <li><a href="InsertCaseController">InsertCase</a></li>
                    <li><a href="InsertCoolerController">InsertCooler Product</a></li>
                    <li><a href="InsertCpuController">InsertCpu</a></li>
                    <li><a href="InsertGpuController">InsertGpu</a></li>
                    <li><a href="InsertMainBoardController">InsertMainBoard</a></li>
                    <li><a href="InsertPowerController">InsertPower</a></li>
                    <li><a href="InsertRamController">InsertRam</a></li>
                    <li><a href="InsertStorageController">InsertStorage</a></li>
                  </ul>
                  </li>
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