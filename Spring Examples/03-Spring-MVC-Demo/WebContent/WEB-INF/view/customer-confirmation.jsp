<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Confirmation</title>
</head>
<body>
<div align="center">

<h1>Customer Information</h1>

<!-- <h4>Customer is confirmed</h4> -->
<h4>${customer.firstName } ${customer.lastName }</h4>
<h4>Free Passes: ${customer.freePasses}</h4>
<h4>Postal Code:${customer.postalCode }</h4>
<h4>Course Code: ${customer.courseCode }</h4>
</div>
</body>
</html>