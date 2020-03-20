<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div align="center">

		<form:form action="processForm" method="get" modelAttribute="student">
			First Name: <form:input path="firstName" />
			<br>
			<br>
			Last Name: <form:input path="lastName" />
			<br>
			<br>
			Country:
			<form:select path="country">
				<%-- <form:option value="Brazil" label="Brazil" />
				<form:option value="India" label="India" />
				<form:option value="Germany" label="Germany" />
				<form:option value="France" label="France" /> --%>

				<form:options items="${student.countryOptions }" />
			</form:select>
			<br>
			<br>
			Favourite Language:
			<%-- Java<form:radiobutton path="favouriteLanguage" value="Java" />
			C#<form:radiobutton path="favouriteLanguage" value="C#" />
			PHP<form:radiobutton path="favouriteLanguage" value="PHP" />
			Ruby<form:radiobutton path="favouriteLanguage" value="Ruby" /> --%>
			
			<form:radiobuttons path="favouriteLanguage" items="${student.favouriteLanguageOptions }"/>
			<br>
			<br>
			Operating Systems:
			Windows<form:checkbox path="operatingSystems" value="Windows"/>
			Linux<form:checkbox path="operatingSystems" value="Linux"/>
			Mac OS<form:checkbox path="operatingSystems" value="Mac OS"/>
			<br>
			<br>
			<input type="submit" value="Submit" />
		</form:form>
	</div>

</body>
</html>