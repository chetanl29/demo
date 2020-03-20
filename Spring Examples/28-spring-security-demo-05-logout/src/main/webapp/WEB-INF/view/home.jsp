<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<h3>Welcome to the Test company hame page!!!!</h3>
		<hr>
		
		<form:form action="${pageContext.request.contextPath }/logout" method="post">
			<input type="submit" value="Logout"/>	
		</form:form>
	</div>

</body>
</html>