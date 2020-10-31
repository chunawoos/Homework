<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="root"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<title>상품목록</title>
</head>
<%-- productList.jsp --%>
<body>
 <h3>상품목록</h3>
 <table>
   <tr>
      <th>상품번호</th>
      <th>상품명</th>
      <th>상품가격</th>
   </tr>
 <c:forEach items="${list }" var="product">
   <tr>
      <td>${product.id}</td>
      <td><a href="${root }/read?id=${product.id}">${product.name}</a></td>
      <td>${product.price}</td>
   </tr>
 </c:forEach>
 </table>
   <br>
   <a href='${root}/form'>상품입력하기</a>  
</body>
</html>