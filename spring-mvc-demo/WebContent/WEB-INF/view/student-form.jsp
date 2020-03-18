<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
<title> Student Registration Form</title>
</head>
<body>
<form:form action="processForm" modelAttribute="student" method="GET">

	First name: <form:input path="firstName" />
	
	<br><br>
	Last Name: <form:input path="lastName"/>
	
	Country: 
	<form:select path="country">
	<form:options items="${student.countryOptions}" />
	</form:select>
	
	<br><br>
	Favorite Language:
	
		<form:radiobuttons path="favoriteLanguage" items="${student.languageList}"/>

	<br><br>
	Operating Systems:
	
		Linux<form:checkbox path="operatingSystems" value="Linux"/>
		Mac<form:checkbox path="operatingSystems" value="Mac"/>
		Windows<form:checkbox path="operatingSystems" value="MS-Windows"/>
		
		<br><br>
	
	
	<input type="submit" value="submit">
</form:form>
</body>

</html>