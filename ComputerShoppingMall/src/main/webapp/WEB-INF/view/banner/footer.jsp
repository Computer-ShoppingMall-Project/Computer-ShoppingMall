<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <footer class="footer">
    <div class="container">
      <div class="widget col-lg-3 col-md-3 col-sm-12">
        <h4 class="title">About us</h4>
        <p>Redvelvet Team project @Since By 2022.05 </p>
        <a class="button small" href="https://github.com/Computer-ShoppingMall-Project"> Git Site</a>
      </div>
      <!-- end widget -->
      <div class="widget col-lg-3 col-md-3 col-sm-12">
        <h4 class="title">Recent Posts</h4>
        <ul class="recent_posts">
          <li>
            <a href="${pageContext.request.contextPath}/image/cpuNo01.JPG">
						<img src="${pageContext.request.contextPath}/image/cpuNo01.JPG" alt="" />Our New CPU Is Here</a>
            <a class="readmore" href="${pageContext.request.contextPath}/CpuListController">read more</a>
          </li>
          <li>
            <a href="${pageContext.request.contextPath}/image/gpuNo01.JPG">
						<img src="${pageContext.request.contextPath}/image/gpuNo01.JPG" alt="" />Our New GPU Is Here</a>
            <a class="readmore" href="${pageContext.request.contextPath}/GpuListController">read more</a>
          </li>
        </ul>
        <!-- recent posts -->
      </div>
      <!-- end widget -->
      <div class="widget col-lg-3 col-md-3 col-sm-12">
        <h4 class="title">Get In Touch</h4>
        <ul class="contact_details">
          <li><i class="fa fa-envelope-o"></i><a href="https://github.com/Computer-ShoppingMall-Project"> RedVelvet Github</a></li>
          <li><i class="fa fa-phone-square"></i> 010 1234 5678</li>
          <li><i class="fa fa-home"></i> Korea RedVelvet</li>
          <li><i class="fa fa-map-marker"></i><a href="https://github.com/Computer-ShoppingMall-Project"> View RedVelvet Github</a></li>
        </ul>
        <!-- contact_details -->
      </div>
      <!-- end widget -->
      <div class="widget col-lg-3 col-md-3 col-sm-12">
        <h4 class="title">Flickr Stream</h4>
        <ul class="flickr">
          <li><a href="${pageContext.request.contextPath}/CaseListController"><img alt="" src="${pageContext.request.contextPath}/image/caseNo01.JPG"></a></li>
          <li><a href="${pageContext.request.contextPath}/CaseListController"><img alt="" src="${pageContext.request.contextPath}/image/caseNo02.JPG"></a></li>
          <li><a href="${pageContext.request.contextPath}/CaseListController"><img alt="" src="${pageContext.request.contextPath}/image/caseNo03.JPG"></a></li>
          <li><a href="${pageContext.request.contextPath}/CaseListController"><img alt="" src="${pageContext.request.contextPath}/image/caseNo04.JPG"></a></li>
          <li><a href="${pageContext.request.contextPath}/CaseListController"><img alt="" src="${pageContext.request.contextPath}/image/caseNo05.JPG"></a></li>
          <li><a href="${pageContext.request.contextPath}/CaseListController"><img alt="" src="${pageContext.request.contextPath}/image/caseNo06.JPG"></a></li>
          <li><a href="${pageContext.request.contextPath}/CaseListController"><img alt="" src="${pageContext.request.contextPath}/image/caseNo07.JPG"></a></li>
          <li><a href="${pageContext.request.contextPath}/CaseListController"><img alt="" src="${pageContext.request.contextPath}/image/caseNo08.JPG"></a></li>
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
          <div>
				<p>Since 2022.05 HomePage Made By<a href="https://github.com/Computer-ShoppingMall-Project"> RedVelvet Github</a></p>
          </div>
        </div>
        <!-- end widget -->
        <div class="col-lg-6 col-md-6 col-sm-12 columns text-right">
          <div class="footer-menu right">
            <ul class="menu">
              <li><a href="${pageContext.request.contextPath}/IndexController">Home</a></li>
              <li><a href="${pageContext.request.contextPath}/MyBasketController">MyBasket</a></li>
              <li><a href="${pageContext.request.contextPath}/QnaListController">Q&A List</a></li>
              <li><a href="${pageContext.request.contextPath}/InsertQnaController">Q&A Write</a></li>
              <li><a href="${pageContext.request.contextPath}/SelectMemberOneController">Member</a></li>
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