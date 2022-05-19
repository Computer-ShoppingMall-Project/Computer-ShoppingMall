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
<link href="${pageContext.request.contextPath}/img/favicon.png" rel="icon">
<link href="${pageContext.request.contextPath}/img/apple-touch-icon.png" rel="apple-touch-icon">
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

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- =======================================================
    Template Name: MaxiBiz
    Template URL: https://templatemag.com/maxibiz-bootstrap-business-template/
    Author: TemplateMag.com
    License: https://templatemag.com/license/
  ======================================================= -->
</head>
<body>
	<!-- header적용. -->
	<jsp:include page="/WEB-INF/view/banner/adminHeader.jsp"></jsp:include>
	<section class="post-wrapper-top">
		<div class="container">
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<ul class="breadcrumb">
					<li><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
					<li>Register</li>
				</ul>
				<h2>REGISTER</h2>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<!-- search -->
				<div class="search-bar">
					<form action="" method="get">
						<fieldset>
							<input type="image" src="${pageContext.request.contextPath}/img/pixel.gif" class="searchsubmit"
								alt="" /> <input type="text" class="search_text showtextback"
								name="s" id="s" value="Search..." />
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
					<h4 class="title">
						<span>Why Join Us?</span>
					</h4>
					<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry"s standard dummy text ever since the 1500s..</p>
					<p>It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-12">
					<h4 class="title">
						<span>Benefits</span>
					</h4>
					<ul class="check">
						<li><a href="#">5+ homepage style (check features menu)</a></li>
						<li><a href="#">Compatible any eCommerce solutions</a></li>
						<li><a href="#">Limitless color combinations</a></li>
						<li><a href="#">Limitless page templates (15+ custom pages)</a></li>
						<li><a href="#">100% responsive layout design</a></li>
						<li><a href="#">Awesome slideshows for your contents</a></li>
						<li><a href="#">Super awesome portfolio sections</a></li>
						<li><a href="#">700+ custom font icons included</a></li>
					</ul>
				</div>
				<!-- end login -->
				<div class="col-lg-4 col-md-4 col-sm-12">
					<h4 class="title">
						<span>Register Form</span>
					</h4>
					<form id="registerform" method="post" name="registerform"
						action="${pageContext.request.contextPath}/InsertMemberController">
						<div class="form-group">
							<!-- 4자이상 : blur이벤트 발생시 체크 -->
							<input type="text" id="id" name="customerId" class="form-control" placeholder="ID"> <span id="idHelper" class="helper"></span>
						</div>
						<div class="form-group">
							<input type="password" id="pw" name="customerPw1" class="form-control" placeholder="Password"> 
							<span id="pwHelper" class="helper"></span>
						</div>
						<div class="form-group">
							<input type="password" id="pwConfirm" name="customerPw2" class="form-control" placeholder="Re-enter password">
						</div>
						<div class="form-group">
							<input type="text" id="name" name="name" class="form-control" placeholder="Name">
							<span id="nameHelper" class="helper"></span>
						</div>
						<div class="form-group">
							<input type="text" id="nickname" name="nickName" class="form-control" placeholder="Nickname">
							<span id="nicknameHelper" class="helper"></span>
						</div>
						<div class="form-group">
							<input type="email" id="email" name="email" class="form-control" placeholder="Email">
							<span id="emailHelper" class="helper"></span>
						</div>
						<div class="form-group">
							<input type="number" id="phone" name="phone" class="form-control" placeholder="Phone number">
							<span id="phoneHelper" class="helper"></span>
						</div>
						<div class="form-group">
							<input type="number" id="zipcode" name="zipCode" readonly="readonly" onclick="execDaumPostcode()" class="form-control" placeholder="zip code">
							<span id="zipcodeHelper" class="helper"></span>
						</div>
						<div class="form-group">
							<input type="text" id="roadAddress" readonly="readonly" name="roadAddress" class="form-control" placeholder="Road address">
							<span id="roadHelper" class="helper"></span>
						</div>
						<div class="form-group">
							<input type="text" id="detailAddress" name="detailAddress" class="form-control" placeholder="Detail address">
							<span id="detailHelper" class="helper"></span>
						</div>
						<div class="form-group">
							<button type="button" id="signup">Register</button>
						</div>
					</form>
				</div>
				<!-- end register -->
			</div>
			<!-- end content -->
		</div>
		<!-- end container -->
	</section>
	<!-- end section -->
	<!-- footer적용 -->
	<jsp:include page="/WEB-INF/view/banner/footer.jsp"></jsp:include>

	<div class="dmtop">Scroll to Top</div>
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
	<script type="text/javascript">
		$('#id').focus();

		$('#id').blur(function() {
			if ($('#id').val().length < 4) {
				$('#idHelper').text('id는 4자이상');
				$('#id').focus();
			} else {
				$('#idHelper').text('');
			}
		});

		$('#pwConfirm').blur(function() {
			if ($('#pw').val().length < 4) {
				$('#pwHelper').text('pw는 4자이상');
				$('#pw').focus();
			} else if ($('#pw').val() != $('#pwConfirm').val()) {
				$('#pwHelper').text('pw가 일치하지 않습니다');
				$('#pw').focus();
			} else {
				$('#pwHelper').text('');
			}
		});

		$('#name').blur(function() {
			if ($('#name').val().length == 0) {
				$('#nameHelper').text('이름을 입력하세요');
				$('#name').focus();
			} else {
				$('#nameHelper').text('');
			}
		});

		$('#nickname').blur(function() {
			if ($('#nickname').val().length == 0) {
				$('#nicknameHelper').text('닉네임을 입력하세요');
				$('#nickname').focus();
			} else {
				$('#nicknameHelper').text('');
			}
		});

		$('#email').blur(function() {
			if ($('#email').val().length == 0) {
				$('#emailHelper').text('이메일을 입력하세요');
				$('#email').focus();
			} else {
				$('#email').text('');
			}
		});

		$('#phone').blur(function() {
			if ($('#phone').val().length == 0) {
				$('#phoneHelper').text('번호를 입력하세요');
				$('#phone').focus();
			} else {
				$('#phone').text('');
			}
		});

		$('#zipcode').blur(function() {
			if ($('#zipcode').val().length == 0) {
				$('#zipcodeHelper').text('우편번호를 입력하세요');
				$('#zipcode').focus();
			} else {
				$('#zipcode').text('');
			}
		});

		$('#roadAddress').blur(function() {
			if ($('#roadAddress').val().length == 0) {
				$('roadHelper').text('도로명 주소를 입력하세요');
				$('#roadAddress').focus();
			} else {
				$('#roadAddress').text('');
			}
		});

		$('#detailAddress').blur(function() {
			if ($('#detailAddress').val().length == 0) {
				$('detailHelper').text('상세 주소를 입력하세요');
				$('#detailAddress').focus();
			} else {
				$('#detailAddress').text('');
			}
		});

		$('#signup').click(function() {
			if ($('#id').val() == '') {
				$('#idHelper').text('id는 4자이상');

				$('#id').focus();
			} else if ($('#pw').val() == '') {
				$('#idHelper').text('');

				$('#pwHelper').text('pw는 4자이상');
				$('#pw').focus();
			} else if ($('#name').val() == '') {
				$('#pwHelper').text('');

				$('#nameHelper').text('이름을 입력하세요');
				$('#name').focus();
			} else if ($('#nickname').val() == '') {
				$('#nameHelper').text('');

				$('#nicknameHelper').text('닉네임을 입력하세요');
				$('#nickname').focus();
			} else if ($('#email').val() == '') {
				$('#nicknameHelper').text('');

				$('#emailHelper').text('이메일을 입력하세요');
				$('#email').focus();
			} else if ($('#phone').val() == '') {
				$('#emailHelper').text('');

				$('#phoneHelper').text('번호을 입력하세요');
				$('#phone').focus();
			} else if ($('#zipcode').val() == '') {
				$('#phoneHelper').text('');

				$('#zipcodeHelper').text('우편번호를 입력하세요');
				$('#zipcode').focus();
			} else if ($('#roadAddress').val() == '') {
				$('#zipcodeHelper').text('');

				$('#roadAddresssHelper').text('도로명 주소를 입력하세요');
				$('#roadAddress').focus();
			} else if ($('#detailAddress').val() == '') {
				$('#roadHelper').text('');

				$('#detailAddresssHelper').text('상세주소을 입력하세요');
				$('#detailAddress').focus();
			} else {
				$('#registerform').submit();
			}
		});
	</script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
		// 카카오 주소api
		function execDaumPostcode() {
			new daum.Postcode({
				oncomplete : function(data) {
					var roadAddr = data.roadAddress; // 도로명 주소 
					var extraRoadAddr = ''; // 참고 항목
					// 법정동명이 있을 경우 추가한다. (법정리는 제외)
					// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
					if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
						extraRoadAddr += data.bname;
					}
					// 건물명이 있고, 공동주택일 경우 추가한다.
					if (data.buildingName !== '' && data.apartment === 'Y') {
						extraRoadAddr += (extraRoadAddr !== '' ? ', '
								+ data.buildingName : data.buildingName);
					}
					// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
					if (extraRoadAddr !== '') {
						extraRoadAddr = ' (' + extraRoadAddr + ')';
					}
					// 우편번호와 주소 정보를 해당 필드에 넣는다.
					document.getElementById('zipcode').value = data.zonecode;
					document.getElementById('roadAddress').value = roadAddr;
				}
			}).open();
		}
	</script>
</body>
</html>
