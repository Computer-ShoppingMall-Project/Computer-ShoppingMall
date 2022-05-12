<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ page import ="vo.Customer"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>delete member form</title>
</head>
<body>
<%
	// request controller
	Customer customer = (Customer)request.getAttribute("customer");
	// error 메세지 값 받기 코드
	String msg = ""; 
	if(request.getParameter("msg") != null){
		if(request.getParameter("msg").equals("wrongPw")) {
			msg = "Existing passwords do not match.";
		}
	}
%>
	<h1>회원탈퇴</h1>
	<!-- 오류 메세지 출력 -->
	<h2><%=msg %></h2>
	<form method="post" action="<%=request.getContextPath()%>/DeleteMemberController">
		<div>
			<table border="1">
				<tr>
					<td>ID</td>
					<td>
						<input type="text" name="customerId" readonly="readonly" value="<%=request.getAttribute("customerId")%>">
					</td>
				</tr>
				<tr>
					<td>탈퇴하려면 비밀번호 처</td>
					<td>
						<input type="password" name="customerPw" required>
						<div>비밀번호 입력시, 회원 탈퇴~</div>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<button type ="submit">삭제</button>
					</td>
				</tr>
			</table>
		</div>
	</form>
		<a  href="<%=request.getContextPath()%>/SelectMemberOneController" type ="button">이전</a>
		<a  href="<%=request.getContextPath()%>/IndexController" type ="button">index</a>
</body>
</html> 