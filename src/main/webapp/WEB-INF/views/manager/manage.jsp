<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Managing Page</h2>
	<h3>logout worked well</h3>
	<form method="post" action="/member/logout">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<a href="/member/logout"><button class="btn">Logout</button></a>
	</form>
	<a href="/"><button class="btn">빠꾸</button></a>
</body>
</html>