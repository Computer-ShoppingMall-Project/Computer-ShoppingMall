<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ page import ="vo.Customer"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>update member form</title>
</head>
<body>
<%
	// receive controller
	Customer customer = (Customer)request.getAttribute("customer");
%>
	<h1>회원정보 수정</h1>
	<form method="post" action="<%=request.getContextPath()%>/UpdateMemberController">
		<div>
		<!-- 값넘기기 -->
			<input type="hidden" name="customerId" readonly="readonly" value="<%=customer.getCustomerId()%>">
		</div>
		<div>
			<table border="1">
				<tr>
					<td>이름 수정</td>
					<td>
						<input type="text" name="name" value="<%=customer.getName()%>" required>
					</td>
				</tr>
				<tr>
					<td>닉네임 수정</td>
					<td>
						<input type="text" name="nickName" value="<%=customer.getNickName()%>" required>
					</td>
				</tr>
				<tr>
					<td>이메일 수정</td>
					<td>
						<input type="text" name="email" value="<%=customer.getEmail()%>" required>
					</td>
				</tr>
				<tr>
					<td>번호 수정</td>
					<td>
						<input type="text" name="phone" value="<%=customer.getPhone()%>" required>
					</td>
				</tr>
				<tr>
					<td>주소 수정</td>
					<td>
						<input type="number" name="addressId" value="<%=customer.getAddressId()%>" required>
					</td>
				</tr>
				<tr>
					<td>상세 주소 수정</td>
					<td>
						<input type="text" name="detailAddress" value="<%=customer.getDetailAddress()%>" required>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="submit">회원 정보 수정</button>
					</td>
				</tr>
			</table>
		</div>
	</form>
		<a  href="<%=request.getContextPath()%>/SelectMemberOneController" type="button">이전</a>
		<a  href="<%=request.getContextPath()%>/IndexController" type="button">index</a>
</body>
</html> 