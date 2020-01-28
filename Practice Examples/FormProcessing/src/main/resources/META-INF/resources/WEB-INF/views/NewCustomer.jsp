<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<sf:form action="save" modelAttribute="customer" method="post">
		<div align="center">
			<table border="1">
				<tr>
					<th><label for="user_full_name">Customer Name</label></th>
					<td><sf:input path="customerName" id="user_full_name"
							size="20" />
						<sf:errors path="customerName" delimiter=", "></sf:errors><</td>
				</tr>

				<tr>
					<th><label for="user_state">Customer State</label></th>
					<td><sf:input path="customerState" id="user_state" />
						<sf:errors path="customerState" delimiter=", "></sf:errors></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" value="submit" /></td>
				</tr>

			</table>
		</div>


	</sf:form>

</body>
</html>