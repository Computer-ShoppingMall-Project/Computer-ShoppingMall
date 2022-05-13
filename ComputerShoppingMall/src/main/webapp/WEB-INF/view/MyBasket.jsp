<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="vo.Basket"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>My Basket</title>
</head>
<body>
<%
	Basket basket = (Basket)request.getAttribute("basket");
%>
<h1>My 장바구니 test form </h1>
	<table border="1">
		<tr>
			<td>장바구니 번호</td>
			<td><%=basket.getBasketNo()%></td>
		</tr>
		<tr>
			<td>고객 ID</td>
			<td><%=basket.getCustomerId()%></td>
		</tr>
		<tr>
			<td>카테고리 이름</td>
			<td><%=basket.getCategoryName()%></td>
		</tr>
		<tr>
			<td>카테고리 No</td>
			<td><%=basket.getCategoryNumber()%></td>
		</tr>
		<tr>
			<td>가격</td>
			<td><%=basket.getPrice()%></td>
		</tr>
		<tr>
			<td>수량</td>
			<td><%=basket.getQuantity()%></td>
		</tr>
		<tr>
			<td>주문일</td>
			<td><%=basket.getCreateDate()%></td>
		</tr>
		<tr>
			<td>주문일(갱신)</td>
			<td><%=basket.getUpdateDate()%></td>
		</tr>
	</table>
	<a href="<%=request.getContextPath()%>/CheckoutController" type="button">결제</a>
</body>
</html>