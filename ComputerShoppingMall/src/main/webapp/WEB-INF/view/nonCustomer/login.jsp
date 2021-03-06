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
<link href="${pageContext.request.contextPath}/img/apple-touch-icon.png" rel="icon">
<link href="${pageContext.request.contextPath}/img/apple-touch-icon.png" rel="icon">

<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Ruda:400,900,700" rel="stylesheet">

<!-- Bootstrap CSS File -->
<link href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Libraries CSS Files -->
<link href="${pageContext.request.contextPath}/lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/lib/prettyphoto/css/prettyphoto.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/lib/hover/hoverex-all.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/lib/jetmenu/jetmenu.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/lib/owl-carousel/owl-carousel.css" rel="stylesheet">

<!-- Main Stylesheet File -->
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/colors/blue.css">

<!-- =======================================================
    Template Name: MaxiBiz
    Template URL: https://templatemag.com/maxibiz-bootstrap-business-template/
    Author: TemplateMag.com
    License: https://templatemag.com/license/
  ======================================================= -->
</head>
<body>
	<!-- header적용 -->
	<c:choose> 
		<c:when test="${sessionAdminId != null }">
			<jsp:include page="/WEB-INF/view/banner/adminHeader.jsp"></jsp:include>
		</c:when>
		<c:otherwise>
			<jsp:include page="/WEB-INF/view/banner/header.jsp"></jsp:include>
		</c:otherwise>
	</c:choose>

	<section class="post-wrapper-top">
		<div class="container">
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<ul class="breadcrumb">
					<li><a href="index.jsp">Home</a></li>
					<li>Login</li>
				</ul>
				<h2>LOGIN</h2>
			</div>
		</div>
	</section>
	<!-- end post-wrapper-top -->

	<section class="section1">
		<div class="container clearfix">
			<div class="content col-lg-12 col-md-12 col-sm-12 clearfix">
				<div class="col-lg-3 col-md-6 col-sm-12"></div>
				<div class="col-lg-6 col-md-6 col-sm-12">
					<h4 class="title">
						<span>Login Form</span>
					</h4>
					<form id="loginform" method="post" name="loginform" action="${pageContext.request.contextPath}/LoginController">
						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user"></i></span>
								<input type="text" id="id" size="15" name="customerId" class="form-control" value="guest" placeholder="Username">
							</div>
						</div>
						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-lock"></i></span>
								<input type="password" id="pw" name="customerPw" class="form-control" value="0000" placeholder="Password"> 
							</div>
						</div>
						<div class="form-group">
							<div class="checkbox">
								<label> <input type="checkbox"> Remember me </label> 
								<div class="text-danger">
									[고객] 로그인 버튼 (아이디:guest 비밀번호:0000)
									<br>
									[관리자] 아이디: admin123 비밀번호:1234
								</div>
							</div>
						</div>
						<div class="form-group">
							<button type="button" id="login" class="button" onclick="Login()" >로그인</button>
							<a href="${pageContext.request.contextPath}/InsertMemberController" class="button" style="background-color: rgb(11, 201, 4);">회원가입</a>
						</div>
					</form>
				</div>
				<!-- end login -->
			</div>
			<!-- end content -->
		</div>
		<!-- end container -->
	</section>
	<!-- end section -->

	<!-- footer적용 -->
	<jsp:include page="/WEB-INF/view/banner/footer.jsp"></jsp:include>
	
	<!-- JavaScript Libraries -->
	<script src="${pageContext.request.contextPath}/lib/jquery/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/lib/php-mail-form/validate.js"></script>
	<script src="${pageContext.request.contextPath}/lib/prettyphoto/js/prettyphoto.js"></script>
	<script src="${pageContext.request.contextPath}/lib/isotope/isotope.min.js"></script>
	<script src="${pageContext.request.contextPath}/lib/hover/hoverdir.js"></script>
	<script src="${pageContext.request.contextPath}/lib/hover/hoverex.min.js"></script>
	<script src="${pageContext.request.contextPath}/lib/unveil-effects/unveil-effects.js"></script>
	<script src="${pageContext.request.contextPath}/lib/owl-carousel/owl-carousel.js"></script>
	<script src="${pageContext.request.contextPath}/lib/jetmenu/jetmenu.js"></script>
	<script src="${pageContext.request.contextPath}/lib/animate-enhanced/animate-enhanced.min.js"></script>
	<script src="${pageContext.request.contextPath}/lib/jigowatt/jigowatt.js"></script>
	<script src="${pageContext.request.contextPath}/lib/easypiechart/easypiechart.min.js"></script>

	<!-- Template Main Javascript File -->
 	<script src="${pageContext.request.contextPath}/js/main.js"></script>
 	
	<script src="/cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script type="text/javascript">
	
	<!-- 아이디 검사 -->
	 function Login()
	   {
	           var form = document.loginform;
	           
	           // 아이디에서 입력 필수 조건문
				if (form.id.value == "")
				{	
					form.id.focus();//포커스를 id박스로 이동.
			        Swal.fire({
	    			 	icon : 'error',
	    			 	text : '아이디를 입력해야 합니다!'
	    			 });
			        return;
				}
				// 아이디 입력 문자수를 4~12자로 제한하는 조건문
				
				if (form.id.value.length < 4 || form.id.value.length > 12)
				{
					form.id.select();// 입력한 문자를 선택 상태로 만듬.
					Swal.fire({
	    			 	icon : 'error',
	    			 	text : '아이디는 4자 이상 입력 가능합니다!'
	    			 });
				 	return;
				}
	       <!-- 패스워드 검사 -->

	            if (form.pw.value == "")
	            {
	            	 form.pw.focus();//포커스를 Password박스로 이동.
	                 Swal.fire({
		    			 	icon : 'error',
		    			 	text : '패스워드를 입력 해야 합니다!'
		    			 });
	                 
	                 return;
	                 
	            }
	            if (form.pw.value.length < 4 || form.pw.value.length > 12)
	            {
	            	form.pw.select();
	            	 Swal.fire({
	    			 	icon : 'error',
	    			 	text : '비밀번호는 4~12자 이내로 입력 가능 합니다!'
	    			 });

	                 return;
	            }
	            
	            loginform.submit();
	   }
	</script>
</body>
</html>