<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Customer</title>

<link type = "text/css"
		rel = "stylesheet"
		href="${pageContext.request.contextPath}/resources/css/Style.css"/>
</head>
<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Management</h2> 
		</div>
	</div>

	<div id = "container">
		<div id ="content">
			<input type="button" value="AddCustomer"
				onClick="window.location.href='FormForAdd';return false;"
					class="add-button"/>
		
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var = "temp" items="${lst}">
					
					<c:url var="updateLink" value="/customer/FormForUpdate">
						<c:param name="customerID" value="${temp.id}"/>
					</c:url>
					
					<c:url var="deleteLink" value="/customer/FormForDelete">
						<c:param name="customerID" value="${temp.id}"/>
					</c:url>
					
					<tr>
						<td>${temp.firstName}</td>
						<td>${temp.lastName}</td>
						<td>${temp.email}</td>
						<td><a href="${updateLink}">Update</a>
						|
						<a href="${deleteLink}"
							onClick = "if(!(confirm('Do you want to delete record?')))return false">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>