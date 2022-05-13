<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.Basket"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>My Basket</title>
</head>
<body>
<%
	// request controller
	ArrayList<Basket> list = (ArrayList<Basket>)request.getAttribute("list");
%>
<h1>My 장바구니 test form </h1>
	<table border="1">
		<thead>
			<tr>
				<th>부품 이름</th>
				<th>부품 번호</th>
				<th>가격</th>
				<th>수량</th>
				<th>저장날짜</th>
				<th></th>
			</tr>
		</thead>
			<%
				for(Basket basket : list) {
			%>
		<tbody>
				<tr>
					<td><%=basket.getCategoryName()%></td>
					<td><%=basket.getCategoryNumber()%></td>
					<td><%=basket.getCategoryPrice()%></td>
					<td><%=basket.getCategoryQuantity()%></td>
					<td><%=basket.getCreateDate()%></td>
					<td><a href="<%=request.getContextPath()%>/DeleteMyBasketController?basketNo=?">삭제</a></td>
				</tr>
			<%
				}
			%>
				
		</tbody>
	</table>
	<a href="<%=request.getContextPath()%>/InsertMyBasketController" type="button">추가구매</a>
	<a href="<%=request.getContextPath()%>/CheckoutController" type="button">결제</a>
</body>
</html>