<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>

	<div align="center">

		<h1>Company Home Page</h1>
		<br/>
		<hr>
		<h3>Welcome to the Test company home page!!!!</h3>
		<hr>
		
		<p>
			User: <security:authentication property="principal.username"/>
			<br><br>
			Role(s): <security:authentication property="principal.authorities"/>
		</p>
		
		<!-- Only for Managers -->
		
		<security:authorize access="hasRole('MANAGER')">
		
		<hr>
		
		<p>
			<a href="${pageContext.request.contextPath }/leaders">Leadership Meeting</a>
			(Only for Manager)
		</p> 
		</security:authorize>
		
		<!-- Only for ADMIN -->
		
		<security:authorize access="hasRole('ADMIN')">
		
		<hr>
		
		<p>
			<a href="${pageContext.request.contextPath }/systems">IT Systems Meeting</a>
			(Only for Admin)
		<p>
		</security:authorize>
		
		<hr>
		
		<form:form action="${pageContext.request.contextPath }/logout" method="post">
			<input type="submit" value="Logout"/>	
		</form:form>
	</div>

</body>
</html>