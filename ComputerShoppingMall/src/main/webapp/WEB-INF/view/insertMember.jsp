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
  <link rel="stylesheet" href="css/colors/blue.css">

  <!-- =======================================================
    Template Name: MaxiBiz
    Template URL: https://templatemag.com/maxibiz-bootstrap-business-template/
    Author: TemplateMag.com
    License: https://templatemag.com/license/
  ======================================================= -->
</head>
<body>
  <!-- header적용. -->
  <jsp:include page="header.jsp"></jsp:include>

  <section class="post-wrapper-top">
    <div class="container">
      <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
        <ul class="breadcrumb">
          <li><a href="index.jsp">Home</a></li>
          <li>Update Member</li>
        </ul>
        <h2>Update Member</h2>
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
        <div class="col-lg-12 col-md-12 col-sm-12">
          <h4 class="title">
                       <span>Update Member</span>
          </h4>
             <form method="post" action="${pageContext.request.contextPath}/UpdateMemberController">
               <div>
               <!-- 값넘기기 -->
               <input type="hidden" name="customerId" readonly="readonly" value="${requestScope.customer.customerId}">
            </div>
      <div>
         <table class="table">
            <tr>
               <td>이름 수정</td>
               <td>
                  <input type="text" name="name" value="${requestScope.customer.name}" required>
               </td>
            </tr>
            <tr>
               <td>닉네임 수정</td>
               <td>
                  <input type="text" name="nickName" value="${requestScope.customer.nickName}" required>
               </td>
            </tr>
            <tr>
               <td>이메일 수정</td>
               <td>
                  <input type="text" style="width:300px;"   name="email" value="${requestScope.customer.email}" required>
               </td>
            </tr>
            <tr>
               <td>번호 수정</td>
               <td>
                  <input type="text" name="phone" value="${requestScope.customer.phone}" required>
               </td>
            </tr>
            <tr>
               <td>우편번호 수정</td>
               <td>
                  <input type="text" id="zipcode" name="zipcode" value="${requestScope.customer.addressId}" readonly="readonly" onclick="execDaumPostcode()" >
               </td>
            </tr>
            <tr>
               <td>도로명주소 수정</td>
               <td>
                  <input style="width:300px;" type="text" id="roadAddress" name="roadAddress" value="${requestScope.customer.detailAddress}" required>
               </td>
            </tr>
            <tr>
               <td>상세 주소 수정</td>
               <td>
                  <input type="text" id="detailAddress" name="detailAddress" value="${requestScope.customer.detailAddress}" required>
               </td>
            </tr>
            <tr>
               <td colspan="2">
                  <button type="submit" class="btn btn-outline-primary btn-sm">정보수정</button>
               </td>
            </tr>
         </table>
      </div>
   </form>
      <a href="${pageContext.request.contextPath}/SelectMemberOneController" type="button" class="btn btn-outline-info btn-sm">이전</a>
      <a href="${pageContext.request.contextPath}/UpdateMemberPwController" type="button" class="btn btn-outline-info btn-sm">비밀번호 수정</a>
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
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
// 카카오 주소api
function execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {

            var roadAddr = data.roadAddress; // 도로명 주소 
            var extraRoadAddr = ''; // 참고 항목

            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
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