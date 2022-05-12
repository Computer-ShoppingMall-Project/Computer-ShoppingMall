<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="vo.Customer"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>update member password form</title>
</head>
<body>
<%
	// receive controller
	Customer customer = (Customer)request.getAttribute("customer");
	// error 메세지
	String msg = "";
	if(request.getParameter("msg") != null){
		if(request.getParameter("msg").equals("wrongPw")) {
			msg = "Existing password does not match";
		}
		else if(request.getParameter("msg").equals("notMatch")) {
			msg = "Please check your password again";
		}
	}
%>
	<h1>회원정보 수정</h1>
	<!-- 오류 메세지 출력 -->
	<h2><%=msg%></h2>
	<form method="post" action="<%=request.getContextPath()%>/UpdateMemberPwController">
		<div>
			<!-- 값넘기기 -->
			<input type="hidden" name="customerId" readonly="readonly" value="<%=customer.getCustomerId()%>">
			<input type="hidden" name="name" value="<%=customer.getName()%>" required>
			<input type="hidden" name="nickName" value="<%=customer.getNickName()%>" required>
			<input type="hidden" name="email" value="<%=customer.getEmail()%>" required>
			<input type="hidden" name="phone" value="<%=customer.getPhone()%>" required>
			<input type="hidden" name="addressId" value="<%=customer.getAddressId()%>" required>
			<input type="hidden" name="detailAddress" value="<%=customer.getDetailAddress()%>" required>
		</div>
		<div>
			<table border="1">
				<td>현재 비밀번호 입력</td>
					<td>
						<input type="password" name="customerPw" required>
					</td>
				</tr>
				<tr>
					<td>새 비밀번호 입력</td>
					<td>
						<input type = "password" name ="newCustomerPw1" value="" required>
					</td>
				</tr>
				<tr>
					<td>새 비밀번호 확인</td>
					<td>
						<input type = "password" name ="newCustomerPw2"  value="" required>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="submit">비밀번호 수정</button>
					</td>
				</tr>
			</table>
		</div>
	</form>
		<a  href="<%=request.getContextPath()%>/SelectMemberOneController" type ="button">이전</a>
		<a  href="<%=request.getContextPath()%>/IndexController" type="button">index</a>
</body>
</html> 