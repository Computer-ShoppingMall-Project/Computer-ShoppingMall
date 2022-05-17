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
<link href="img/favicon.png" rel="icon">
<link href="img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Ruda:400,900,700"
	rel="stylesheet">

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

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- =======================================================
    Template Name: MaxiBiz
    Template URL: https://templatemag.com/maxibiz-bootstrap-business-template/
    Author: TemplateMag.com
    License: https://templatemag.com/license/
  ======================================================= -->
</head>
<body>
<%
   // 유효성 검사
   String msg = request.getParameter("msg");
   String code = " ";
   if("1".equals(msg)){
      code = "현재 비밀번호가 올바르지 않습니다.";
   }
%>
	<!-- header적용. -->
	<jsp:include page="header.jsp"></jsp:include>

	<section class="post-wrapper-top">
		<div class="container">
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<ul class="breadcrumb">
					<li><a href="index.jsp">Home</a></li>
					<li>Update Member Pw</li>
				</ul>
				<h2>Update Member Pw</h2>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<!-- search -->
				<div class="search-bar">
					<form action="" method="get">
						<fieldset>
							<input type="image" src="img/pixel.gif" class="searchsubmit" alt="" /> <input type="text" class="search_text showtextback" name="s" id="s" value="Search..." />
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
				<div class="col-lg-12 col-md-12 col-sm-12">
					<h4 class="title">
						<span>Update Member Pw</span>
					</h4>
					<form id="updateform" method="post" name="updateform" action="${pageContext.request.contextPath}/UpdateMemberPwController">
						<div>
							<!-- 값넘기기 -->
							<input type="hidden" name="customerId" class="form-control" value="${requestScope.customer.customerId}" required> 
							<input type="hidden" name="name" class="form-control" value="${requestScope.customer.name}" required> 
							<input type="hidden" name="nickName" class="form-control" value="${requestScope.customer.nickName}" required> 
							<input type="hidden" name="email" class="form-control" value="${requestScope.customer.email}" required> 
							<input type="hidden" name="phone" class="form-control" value="${requestScope.customer.phone}" required>
							<input type="hidden" name="zipCode" class="form-control" value="${requestScope.customer.zipCode}" required>
							<input type="hidden" name="roadAddress" class="form-control" value="${requestScope.customer.roadAddress}" required> 
							<input type="hidden" name="detailAddress" class="form-control" value="${requestScope.customer.detailAddress}" required>
						</div>
						<div class="form-group">
							<input type="password" id="currentPw" name="customerPw" class="form-control" value="${requestScope.customer.customerPw}" placeholder="Current Pw">
							<span id="currentHelper" class="helper"></span>
							<span style="color: red;"><%=code%></span>
						</div>
						<div class="form-group">
							<input type="password" id="pw" name="newCustomerPw1" class="form-control" placeholder="New Password">
							<span id="pwHelper" class="helper"></span>
						</div>
						<div class="form-group">
							<input type="password" id="pwConfirm" name="newCustomerPw2" class="form-control" placeholder="New Password check">
							<span id="pwConfirmHelper" class="helper"></span>
						</div>
						<div class="form-group">
							  <button type="button" id="update">Update</button>
						</div>	
					</form>
				</div>
				<div>
					<a href="${pageContext.request.contextPath}/SelectMemberOneController" type="button" class="btn btn-outline-info btn-sm">이전</a>
					<a href="${pageContext.request.contextPath}/IndexController" type="button" class="btn btn-outline-info btn-sm">index</a>
				</div>
			</div>
			<!-- end content -->
		</div>
		<!-- end container! -->
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
	<script type="text/javascript">
		$('#currentPw').focus();
		
		$('#currentPw').blur(function(){
			if($('#currentPw').val().length == 0) {
				$('#currentHelper').text('현재 비밀번호를 확인하세요');
				$('#currentPw').focus();
			} else {
				$('#currentHelper').text('');
			}
		});
		
		$('#pwConfirm').blur(function(){
			if($('#pw').val().length < 4) {
				$('#pwHelper').text('바꿀 비밀번호를 확인하세요, 비밀번호는 4자이상으로 설정해야합니다.');
				$('#pw').focus();
			} else if($('#pw').val() != $('#pwConfirm').val()) {
				$('#pwHelper').text('비밀번호 확인이 일치하지 않습니다');
				$('#pw').focus();
			} else {
				$('#pwHelper').text('');
			}
		});
		
		$('#update').click(function(){
			if($('#currentPw').val() == '') {
				$('#currentHelper').text('현재 비밀번호를 확인하세요');
				
				$('#id').focus(); 
			} else if($('#pw').val() == '') {
				$('#currentHelper').text('');
				
				$('#pwHelper').text('바꿀 비밀번호를 입력하세요');
				$('#pw').focus();
			} else if($('#pwConfirm').val() == '') {
				$('#pwHelper').text('');
				
				$('#pwConfirmHelper').text('비밀번호 확인란을 입력하세요');
				$('#pwConfirm').focus();
			} else {
				$('#updateform').submit();
			}
		});
</script>
	
</body>
</html>