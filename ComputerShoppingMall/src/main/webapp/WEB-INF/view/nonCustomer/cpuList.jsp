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
<style type="text/css">
	#productMenu {
		margin: 0;
		padding: 0;
	}
	
	#productMenu li {
		float: left;
		list-style: none;
		margin: 1px;
	}
	
	#productMenu li a {
		display: block;
		width: 135px;
		height: 40px;
		border: 1px #3498DB solid;
		color: #3498DB;
		text-align: center;
		padding-top: 10px;
		text-decoration: none;
	}
	
	#productMenu li a span {
		display: block;
	}
	
	#productMenu li a:hover {
		background: #3498DB;
		color: #FFFFFF;
		text-decoration: none;
	}
</style>
<!-- 
<script type="text/javascript">
	function listView(cpuNo){
	    let f = document.createElement('form');
	    
	    let obj;
	    obj = document.createElement('input');
	    obj.setAttribute('type', 'hidden');
	    obj.setAttribute('name', 'userid');
	    obj.setAttribute('value', userid);
	    
	    f.appendChild(obj);
	    f.setAttribute('method', 'post');
	    f.setAttribute('action', 'view.do');
	    document.body.appendChild(f);
	    f.submit();
	}
</script>
 -->
<script type="text/javascript">
	function plus(index) {
		if (confirm('장바구니에 담으시겠습니까?')) {
			console.log('index',index)
			document.getElementsByClassName('btn')[index].click();
		}
	}
	function del(index) {
		if (confirm('상품을 삭제 하겠습니까?')) {
			document.getElementsByClassName('btn')[index].click();
		}
	}
</script>
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
					<li><a href="${pageContext.request.contextPath}/IndexController">Home</a></li>
					<li>CPU</li>
				</ul>
				<h2>CPU</h2>
			</div>
		<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
		</div>
		</div>
	</section>
	<!-- end post-wrapper-top -->

	<section class="section1">
		<div class="container clearfix">
			<div class=" col-lg-12 col-md-12 col-sm-12 clearfix">
				<div class="divider"></div>
				<div id="productMenu" style="align-center">
					<ul>
						<li><a href="${pageContext.request.contextPath}/CpuListController">CPU</a></li>
						<li><a href="${pageContext.request.contextPath}/MainboardListController">MAINBOARD</a></li>
						<li><a href="${pageContext.request.contextPath}/RamListController">RAM</a></li>
						<li><a href="${pageContext.request.contextPath}/GpuListController">GPU</a></li>
						<li><a href="${pageContext.request.contextPath}/StorageListController">STORAGE</a></li>
						<li><a href="${pageContext.request.contextPath}/CaseListController">CASE</a></li>
						<li><a href="${pageContext.request.contextPath}/PowerListController">POWER</a></li>
						<li><a href="${pageContext.request.contextPath}/CoolerListController">COOLER</a></li>
					</ul>
				</div> <br><br><br>
			<!-- 후에 일정 개수마다 줄바꿈 적용시키기 -->
			<!-- CPU 상세검색 체크박스 테이블 // 체크박스 유지 추가 -->
			<h4>CPU 상세검색</h4>
			<form method="post" action="${pageContext.request.contextPath}/CpuListController">
				<table class="table table-bordered">
					<tr>
						<th style="width: 20%" class="bg-info text-light text-center">COMPANY</th>
						<td>
							<c:forEach var="c" items="${companyList}">
								<input type="checkbox" name="companyName" value="${c}" 
								<c:forEach  var="c1" items="${companyName}">
									<c:if test="${c1 eq c}">
										checked="checked"
									</c:if>
								</c:forEach>><span>&nbsp;${c}&nbsp;</span>
							</c:forEach>
						</td>
					</tr>
					<tr>
						<th class="bg-info text-center">SOCKET SIZE</th>
						<td>
							<c:forEach var="c" items="${socketSizeList}">
								<input type="checkbox" name="socketSize" value="${c}" 
								<c:forEach  var="c1" items="${socketSize}">
									<c:if test="${c1 eq c}">
										checked="checked"
									</c:if>
								</c:forEach>><span>&nbsp;${c}&nbsp;</span>
							</c:forEach>
						</td>
					</tr>
					<tr>
						<th class="bg-info text-center">CORE</th>
						<td>
							<c:forEach var="c" items="${coreList}">
								<input type="checkbox" name="core" value="${c}" 
								<c:forEach  var="c1" items="${core}">
									<c:if test="${c1 eq c}">
										checked="checked"
									</c:if>
								</c:forEach>><span>&nbsp;${c}&nbsp;</span>
							</c:forEach>
						</td>
					</tr>
					<tr>
						<th class="bg-info text-center">THREAD</th>
						<td>
							<c:forEach var="c" items="${threadList}">
								<input type="checkbox" name="thread" value="${c}" 
								<c:forEach  var="c1" items="${thread}">
									<c:if test="${c1 eq c}">
										checked="checked"
									</c:if>
								</c:forEach>><span>&nbsp;${c}&nbsp;</span>
							</c:forEach>
						</td>
					</tr>
					<tr>
						<th class="bg-info text-center">SEARCH</th>
						<td><input type="text" name="search" class="form-control" value="${search}" placeholder="검색어를 입력해주세요"></td>
					</tr>
				</table>
				<div>
					<c:if test="${sessionAdminId != null}">
						<a href="${pageContext.request.contextPath}/InsertCpuController" class="button" style="background-color: LightSkyBlue;" ><i class="fa fa-plus"></i>CPU 등록</a>
					</c:if>
					<button type="submit" style="float: right; margin-rigth: 20px">Search</button>
					<a href="${pageContext.request.contextPath}/CpuListController" class="btn btn-link" style="float: right; margin-rigth: 20px">Reset</a>
				</div>
			</form> <br>
			<!-- 상품 리스트 -->
			<h4 class="title">CPU(<span class="text-primary">${count}</span>)</h4>
			<!-- 조건에 해당하는 상품이 없을 경우 해당 상품이 존재하지 않다는 문구 안내 -->
			<c:if test="${count==0}">
				<h4 class="text-primary text-center">해당 조건의 상품의 존재하지 않습니다</h4>
			</c:if>
			<div class="portfolio-centered">
				<div class="recentitems portfolio">
					<div class="recentitems portfolio isotope" style="position: relative; overflow: hidden; height: 764px;">
						<c:forEach var="c" items="${cpuList}" varStatus="s">
							<div class="portfolio-item col-lg-4 col-md-4 col-sm-4 col-xs-12 web-design graphic-design">
								<div class="he-wrap tpl6 market-item">
										<img src="${pageContext.request.contextPath}/image/${c.cpuImageName}" alt="">   <!-- 이미지 후에 셋팅 -->
									<div class="he-view">
										<div class="bg a0" data-animate="fadeIn">
											<h3 class="big a1" data-animate="fadeInDown"></h3>
													<c:choose>
														<c:when test="${sessionAdminId != null }">
															<a href="${pageContext.request.contextPath}/UpdateCpuController?cpuNo=${c.cpuNo}" class="dmbutton a2" data-animate="bounceInRight"><i class="fa fa-gear">Update</i></a>
															<a hidden="hidden" style="display: none;" class="btn" href="${pageContext.request.contextPath}/DeleteCpuController?cpuNo=${c.cpuNo}" class="dmbutton a2" data-animate="bounceInRight"></a>
															<a href="#" class="dmbutton a2" data-animate="bounceInRight" onclick="del();"><i class="fa fa-minus">Delete</i></a>
															<a href="${pageContext.request.contextPath}/CartAddCpuController?cpuNo=${c.cpuNo}" class="dmbutton a2" data-animate="bounceInRight"><i class="fa fa-search">Detail</i></a>
														</c:when>
														<c:otherwise>
															<a href="${pageContext.request.contextPath}/CartAddCpuController?cpuNo=${c.cpuNo}" class="dmbutton a2" data-animate="bounceInRight"><i class="fa fa-search">Detail</i></a>
															<a hidden="hidden" style="display: none;" class="btn" href="${pageContext.request.contextPath}/MyBasketController?productNumber=${c.cpuNo}&&productName=${c.cpuName}&&price=${c.price}&&categoryName=${c.categoryName}" class="dmbutton a2" data-animate="bounceInRight"></a>
															<a href="#" class="dmbutton a2" data-animate="bounceInRight" onclick="plus(${s.index});"><i class="fa fa-cart-plus">Add</i></a>
														</c:otherwise>
													</c:choose>		
											<div class="portfolio_category text-center a2" data-animate="fadeIn"></div>
											<!-- portfolio_category -->
										</div>
										<!-- he bg -->
									 </div>
									<!-- he view -->
								</div>
								<!-- he wrap -->
								<h3 class="title">${c.cpuName}</h3>
								<p>
									<span class="text-info">price</span>&nbsp; ${c.price}
								</p>
							</div>
						</c:forEach>
					<!-- end col-4 -->
					</div>
				</div>
			<!--  container -->
			<div class="divider"></div>
		</div>
	</div>
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
</body>
</html>