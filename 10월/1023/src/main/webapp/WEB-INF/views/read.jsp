<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>상품상세보기</title>
		<style type="text/css">
			span{
			  display:inline-block;
			  width: 80px;
			  font-weight: bold;
			}
		</style>
	</head>
	<body>
		<h1>상품정보</h1>
		<span>상품 번호 : </span>${product.id }<br>
		<span>상 품 명 : </span>${product.name }<br>
		<span>상품 가격 : </span>${product.price }<br>
		<span>상품 설명 : </span>${product.description }<br><br>
		<a href="${root}/modify?id=${product.id}">상품 수정</a>
		<a href="${root}/remove?id=${product.id}">상품 삭제</a>
		<a href="${root}/list">상품 목록</a>
	</body>
</html>