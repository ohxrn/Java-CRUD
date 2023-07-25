<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Exam</title>

</head>
<body>

<div>

	<h1>Welcome</h1>

	<h2>Register</h2>

	<div>
		<form:form action="/register" modelAttribute="newUser">
		
			<div>
			 	<form:errors path="userName"/>
				<form:label for="userName" path="userName">User Name:</form:label>
				<form:input type="text" path="userName" />
			</div>
			
			<div>
				<form:errors path="email"/>
				<form:label for="email" path="email">Email:</form:label>
				<form:input type="text" path="email"/>
			</div>
			
			<div>
				<form:errors path="password"/>
				<form:label for="password" path="password">Password:</form:label>
				<form:input type="text" path="password" />
			</div>
			
			<div>
				<form:errors path="confirm"/>
				<form:label for="" path="confirm">Confirm:</form:label>
				<form:input type="text" path="confirm" />
			</div>
			
			<div>
				<input type="submit" value="Submit" />
			</div>
			
		</form:form>
	</div>
	
	<h2>Log In</h2>

	<div>
		<form:form action="/login" modelAttribute="newLogin">
			<div>
				<form:errors path="email"/>
				<form:label for="email" path="email">Email:</form:label>
				<form:input type="text" path="email"/>
			</div>
			
			<div>
				<form:errors path="password"/>
				<form:label for="password" path="password">Password:</form:label>
				<form:input type="text" path="password"/>
			</div>
			
			<div>
				<input type="submit" value="Submit"/>
			</div>
		
		</form:form>
	</div>

</div>

</body>
</html>