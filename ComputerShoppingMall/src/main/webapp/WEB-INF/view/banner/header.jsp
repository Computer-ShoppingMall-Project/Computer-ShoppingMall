<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="topbar clearfix">
   <div class="container">
      <div class="col-lg-1 text-right"></div>
      <div class="social_buttons">
        <div class="social_buttons text-right text-align-center">
	      	<c:choose>
				<c:when test="${sessionCustomerId != null}">
					<a href="${pageContext.request.contextPath}/SelectMemberOneController" data-toggle="tooltip" data-placement="bottom" style=" vertical-align: middle;"><span>[${sessionCustomerId}]님 환영합니다</span> &nbsp; </a>
	            </c:when>
	            <c:when test="${sessionAdminId != null }">
	            	<a href="${pageContext.request.contextPath}/AdminIndexController" data-toggle="tooltip" data-placement="bottom">[${sessionAdminId}]님 환영합니다 &nbsp;</a>
	            </c:when>
	        </c:choose>
	        <c:choose>
	          <c:when test="${sessionCustomerId == null && sessionAdminId == null}">
	             <a href="${pageContext.request.contextPath}/LoginController" data-toggle="tooltip" data-placement="bottom" class="btn">Login</a>
	          </c:when>
	          <c:otherwise>
	             <a href="${pageContext.request.contextPath}/LogoutController" data-toggle="tooltip" data-placement="bottom" class="btn">Logout</a>
	          </c:otherwise>
	       </c:choose>
        </div>
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
                     <li><a href="#">조립PC</a>
                        <ul class="dropdown">
                           <li><a href="${pageContext.request.contextPath}/CpuListController">CPU</a></li>
                           <li><a href="${pageContext.request.contextPath}/MainboardListController">메인보드</a></li>
                           <li><a href="${pageContext.request.contextPath}/RamListController">RAM</a></li>
                           <li><a href="${pageContext.request.contextPath}/GpuListController">그래픽카드</a></li>
                           <li><a href="${pageContext.request.contextPath}/StorageListController">SSD/HDD</a></li>
                           <li><a href="${pageContext.request.contextPath}/CaseListController">케이스</a></li>
                           <li><a href="${pageContext.request.contextPath}/PowerListController">파워</a></li>
                           <li><a href="${pageContext.request.contextPath}/CoolerListController">쿨러</a></li>
                        </ul>
                     </li>
                     <li><a href="#">주문</a>
                        <ul class="dropdown">
                           <li><a href="${pageContext.request.contextPath}/MyBasketController">장바구니</a></li>
                           <li><a href="${pageContext.request.contextPath}/MyPaymentController">주문내역</a></li>
                        </ul>
                     </li>
                     <li><a href="#">고객센터</a>
                        <ul class="dropdown">
							 <li><a href="${pageContext.request.contextPath}/QnaListController">QNA 목록</a></li>
							 <li><a href="${pageContext.request.contextPath}/InsertQnaController">QNA 등록</a></li>
                        </ul>
                     </li>
                     <li><a href="#">마이페이지</a>
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
                           <li><a href="${pageContext.request.contextPath}/SelectMemberOneController">회원 정보 상세보기</a></li>
                           <li><a href="${pageContext.request.contextPath}/UpdateMemberController">회원정보 수정</a></li>
                           <li><a href="${pageContext.request.contextPath}/UpdateMemberPwController">비밀번호 수정</a></li>
                        </ul>
                     </li>
                  </ul>
                  <div style="float:right;">
                  	<a href="${pageContext.request.contextPath}/MyBasketController">
                      	<span class="label label-danger" style="z-index:999; position: absolute; top:25px; color:#FFFFFF; font-size:10pt; font-weight:200;">
      						15 <!-- 후에 장바구니 카운트로 변경 -->
    					</span>
     				 <img src="${pageContext.request.contextPath}/img/shopping-cart.png" style="width:40px; position: absolute; right:23px;">
    				</a>
    			</div>
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