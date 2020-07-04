<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
<form:form method="post" action="${pageContext.request.contextPath }/customer/save">
<p>
Customer Name: <input type="text" name="sCustomerName"/>
</p>
<p>
Customer Age: <input type="text" name="customerAge"/>
</p>
<input type="submit" value="SUBMIT"/>
</form:form>
</body>
</html>