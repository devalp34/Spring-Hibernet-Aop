<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adding Customer</title>
<link type="text/css"
		rel = "stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css"/>

<link type="text/css"
		rel = "stylesheet"
		href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
</head>
<body>
<center>
<div id = "wrapper">
	<div id ="header">
		<h2>CRM tool ....Now Add New Customer!!</h2>
	</div>
</div>

<div id = "cotainer">
	<h3>Save Customer</h3>
		
		<form:form action="saveCustomer" modelAttribute="customer" method = "POST">
			
			<form:hidden path = "id"/>
			<table>
				<tbody>
					<tr>
						<td><label>First Name :</label>
						<td><form:input path= "firstName"/></td>
					</tr>
					<tr>
						<td><label>Last Name :</label>
						<td><form:input path= "lastName"/></td>
					</tr>
					<tr>
						<td><label>Email :</label>
						<td><form:input path= "email"/></td>
					</tr>
					<tr>
						<td><label>Submit</label>
						<td><input type="submit" value="Add"/></td>
					</tr>
				</tbody>
			</table>
		</form:form>	
	
		<div style="clear; both;">
			<p>
				<a href="${pageContext.request.contextPath}/customer/list">Go to List? :</a>
			</p>
		</div>
</div>
</center>
</body>
</html>