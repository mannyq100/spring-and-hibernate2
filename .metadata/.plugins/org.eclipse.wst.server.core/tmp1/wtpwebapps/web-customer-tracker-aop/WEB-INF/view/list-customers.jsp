<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
<title>List Customers</title>

<!-- reference style sheet -->
<link type="text/css"
	  rel="stylesheet"
	  href="${pageContext.request.contextPath}/resources/css/style.css" />
		
</head>

<body>

<div id="wrapper">
	<div id="header">
		<h2>CRM - Customer Relationship Manager</h2>
	</div>
</div>

<div id="container">
	<div id="content">
	
	<input type="button" value="Add Customer" class="add-button"
			onClick="window.location.href='showFormForAdd'; return false;"/>
	
	<table>
	<tr>
		<th>FirstName<th/>
		<th>LastName<th/>
		<th>Email<th/>
		<th>Action</th>
	</tr>	
	
	<c:forEach var="tempCustomer" items="${customers}">
	
	<c:url var="updateLink" value="showUpdateForm"> 
	<c:param name="customerId" value="${tempCustomer.id }"></c:param>
	</c:url>
	
	<c:url var="deleteLink" value="delete">
	<c:param name="customerId" value="${tempCustomer.id}"></c:param>
	</c:url>
	

	<tr>
		<td> ${tempCustomer.firstName}</td>
		<td> ${tempCustomer.lastName}</td>
		<td> ${tempCustomer.email}</td>
		<td><a href="${updateLink}">Update</a></td>
		<td><a href="${deleteLink }"
		onClick="if(!(confirm('Are you dure you want to delete this customer?'))) return false">| Delete</a></td>
	
	</tr>
	
	</c:forEach>

</table>
	
	</div>
</div >


</body>

</html>