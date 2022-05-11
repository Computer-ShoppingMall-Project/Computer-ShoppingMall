<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="vo.Customer"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Member One</title>
</head>
<body>
<%
	Customer customer = (Customer)request.getAttribute("customer");
%>
<h1>회원정보 상세보기</h1>
	<table border="1">
	<tr>
		<td>ID</td>
		<td><%=customer.getCustomerId()%></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><%=customer.getName()%></td>
	</tr>
	<tr>
		<td>닉네임</td>
		<td><%=customer.getNickname()%></td>
	</tr>
	<tr>
		<td>Email</td>
		<td><%=customer.getEmail()%></td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td><%=customer.getPhone()%></td>
	</tr>
	<tr>
		<td>주소</td>
		<td><%=customer.getAddressId()%></td>
	</tr>
	<tr>
		<td>상세번호</td>
		<td><%=customer.getDetailAddress()%></td>
	</tr>
	<tr>
		<td>가입일</td>
		<td><%=customer.getCreateDate() %></td>
	</tr>
	</table>
		<a  href="<%=request.getContextPath()%>/UpdateMemberController" type="button">정보수정</a>
		<a  href="<%=request.getContextPath()%>/DeleteMemberController" type="button">탈퇴</a>
		<a  href="<%=request.getContextPath()%>/IndexController" type="button">index</a>
</body>
</html>