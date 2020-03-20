<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Confirmation</title>
</head>
<body>

<div align="center">

<h1>The student is confirmed</h1>
<h4>${student.firstName } ${student.lastName }</h4>
<h4>Country : ${student.country }</h4>
<h4>Favourite Language : ${student.favouriteLanguage }</h4>
<h4>Operating Systems:</h4>
<ul>
	<c:forEach var="temp" items="${student.operatingSystems }">
	<li>${temp }</li>
	</c:forEach>
</ul>

</div>
</body>
</html>