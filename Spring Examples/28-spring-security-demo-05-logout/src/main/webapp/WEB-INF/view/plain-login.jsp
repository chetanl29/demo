<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Custom Login Page</title>

<style>
.failed {
	color: red;
}
</style>
</head>
<body>

	<div align="center">

		<c:if test="${param.error != null }">
			<i class="failed">Sorry Username/Password is
				incorrect.....</i>
		</c:if>
		<h1>Custom Login Page</h1>
		<form
			action="${pageContext.request.contextPath}/authenticateTheUser"
			method="post">

			<p>
				User Name: <input type="text" name="username" />
			</p>

			<p>
				Password: &nbsp;&nbsp;&nbsp;&nbsp;<input type="password"
					name="password" />
			</p>

			<input type="submit" value="Login" />

		</form>

	</div>

</body>
</html>