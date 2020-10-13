<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Customers</title>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"></link>
<%-- <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"></link> --%>

</head>
<body>

	<div id="wrapper" align="center">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container" align="center">
		<div id="content">
		
		<input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd';return false;"
		class="add-button"/>

			<form:form action="search" method="post">
		
		Search Customer:<input type="text" name="theSearchName" />
				<input type="submit" value="Search" class="add-button" />
			</form:form>

			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<c:forEach items="${customers }" var="tempCustomer">
				
				<c:url var="updateLink" value="/customer/showFormForUpdate">
					<c:param name="customerId" value="${tempCustomer.id }"/>
				</c:url>
				
				<c:url var="deleteLink" value="/customer/delete">
					<c:param name="customerId" value="${tempCustomer.id }"/>
				</c:url>
				
					<tr>
						<td>${tempCustomer.firstName }</td>
						<td>${tempCustomer.lastName }</td>
						<td>${tempCustomer.email }</td>
						<td>
							<a href="${updateLink }">Update</a>
							|
							<a href="${deleteLink }"
							onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false"
							>Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>
</html>