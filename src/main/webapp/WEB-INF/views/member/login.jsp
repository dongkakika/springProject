<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h1>LOGIN</h1>
	<form action="/member/login" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		
		<c:if test="${param.ng!=null}">
			<p> error : <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/> </p>
		</c:if>
		
		USER : <input type="text" name="username"><br>
		PASSWORD : <input type="password" name="password"><br>
		<input type="submit" value="Login">
	</form>
	<a href="/"><button class="btn">빠꾸</button></a>
</body>
</html>