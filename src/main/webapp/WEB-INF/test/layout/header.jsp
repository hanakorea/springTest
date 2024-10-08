<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
</head>
<body>
	<nav>
		<P>네비바 영역</P>
		<a href="/">index</a>
		<a href="/signup">회원가입</a>
		<c:if test="${sessionScope.principal == null}"> <!-- 같은 정보를 담는 종류가 많아 충돌방지를 위해 -->
		<a href="/login">로그인</a>
		</c:if>
		<c:if test="${sessionScope.principal != null}"> <!-- 같은 정보를 담는 종류가 많아 충돌방지를 위해 -->
		<a href="/logout">로그아웃</a>
		</c:if>
	</nav>
