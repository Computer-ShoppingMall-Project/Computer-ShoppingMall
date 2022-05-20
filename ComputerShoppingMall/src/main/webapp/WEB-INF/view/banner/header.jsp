<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="topbar clearfix">
   <div class="container">
      <div class="col-lg-10 text-right">
         <div class="social_buttons">
            <c:choose>
               <c:when test="${sessionCustomerId == null}">
                  <a href="${pageContext.request.contextPath}/LoginController" data-toggle="tooltip" data-placement="bottom">Login</a>
               </c:when>
               <c:otherwise>
                  <a href="${pageContext.request.contextPath}/LogoutController" data-toggle="tooltip" data-placement="bottom">Logout</a>
               </c:otherwise>
            </c:choose>
         </div>
      </div>
      <div class="col-lg-1 text-right"></div>
      <div class="social_buttons">
         <a href="${pageContext.request.contextPath}/SelectMemberOneController" data-toggle="tooltip" data-placement="bottom">${sessionCustomerId}</a>
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
               <a href="${pageContext.request.contextPath}/IndexController" title="">
                  <h4>
                  Red<span>Velvet</span>
                  </h4>
               </a>
            </div>
         </div>
         <!-- title area -->
         <div class="col-lg-9 col-md-12 col-sm-12">
            <div id="nav" class="right">
               <div class="container clearfix">
                  <ul id="jetmenu" class="jetmenu blue">
                     <li><a href="${pageContext.request.contextPath}/IndexController">홈</a></li>
                     <li><a href="#">Pages</a>
                        <ul class="dropdown">
                           <li>
                           <c:choose>
                              <c:when test="${sessionCustomerId == null}">
                                 <a href="${pageContext.request.contextPath}/LoginController">Login</a>
                              </c:when>
                              <c:otherwise>
                                 <a href="${pageContext.request.contextPath}/LogoutController">Logout</a>
                              </c:otherwise>
                           </c:choose>
                           <li><a href="${pageContext.request.contextPath}/RegisterController">Register</a></li>
                           <li><a href="${pageContext.request.contextPath}/QnaListController">QNA</a></li>
                        </ul>
                     </li>
                     <li><a href="#">Shop</a>
                        <ul class="dropdown">
                           <li><a href="${pageContext.request.contextPath}/DigitalDownloadController">Products Page</a></li>
                           <li><a href="${pageContext.request.contextPath}/SingleProductController">Single Product</a></li>
                           <li><a href="${pageContext.request.contextPath}/CheckoutController">Checkout</a></li>
                           <li><a href="${pageContext.request.contextPath}/AccountController">Account Page</a></li>
                           <li><a href="${pageContext.request.contextPath}/SupportController">Support Center</a></li>
                           <li><a href="${pageContext.request.contextPath}/MyBasketController">MyBasket</a></li>
                        </ul>
                     </li>
                     <li><a href="#">ProductList</a>
                        <ul class="dropdown">
                           <li><a href="${pageContext.request.contextPath}/CpuListController">Cpu List</a></li>
                           <li><a href="${pageContext.request.contextPath}/GpuListController">Gpu List</a></li>
                           <li><a href="${pageContext.request.contextPath}/MainboardListController">Mainboard List</a></li>
                           <li><a href="${pageContext.request.contextPath}/CaseListController">Case List</a></li>
                           <li><a href="${pageContext.request.contextPath}/RamListController">Ram List</a></li>
                           <li><a href="${pageContext.request.contextPath}/CoolerListController">Cooler List</a></li>
                           <li><a href="${pageContext.request.contextPath}/PowerListController">Power List</a></li>
                           <li><a href="${pageContext.request.contextPath}/StorageListController">Storage List</a></li>
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