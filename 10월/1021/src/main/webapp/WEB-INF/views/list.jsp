<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="root"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			table{
				border-collapse:collapse;
			}
			table td,th{
				border: 1px solid black;
				padding: 5px 0px;
			}
			table th {
				text-align: center;
				background-color: lightgray;
			}
		</style>
	</head>
	<body>
		<h3>상품목록</h3>
		<table>
			<tr>
				<th>상품번호</th>
				<th>상품명</th>
				<th>상품가격</th>
			</tr>
			<c:forEach items="${list}" var="product">
			<tr>
				<td>${product.id}</td>
				<td>${product.name}</td>
				<td>${product.price}</td>
			</tr>
			</c:forEach>
		</table>
			<br>
			<a href='${root }/main/form'>상품입력하기</a>
	</body>
</html>