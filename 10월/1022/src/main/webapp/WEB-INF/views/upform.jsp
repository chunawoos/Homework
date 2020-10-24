<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="root"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품수정</title>
  <style type="text/css">
     span{
       display:inline-block;
       width: 80px
     }
  </style>
</head>
<%-- upform.jsp --%>
<body>
  <h1>상품을 수정 해 주세요.</h1>
  <form method="post" action="${root}/modify">
    <span>상품 번호:</span><input type="text" name="id" value="${product.id}" readonly><br> 
    <span>상 품 명:</span><input type="text" name="name" value="${product.name}"><br> 
	<span>상품 가격:</span><input type="text" name="price" value="${product.price}"><br> 
	<span>상품 설명:</span><input type="text" name="description" value="${product.description}"><br><br>
    <button type="submit">저장</button>
    <button type="reset">취소</button>
  </form>
  <br>
  <a href='${root}/list'>상품목록보기</a> 
</body>
</html>