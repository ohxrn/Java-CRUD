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
	<title>Edit</title>

</head>
<body>
<div>

	<h1>Change your Entry</h1>

	<a href="/home">back to shelves</a>


	<div>
		<form:form action="/theClass/${theClass.id}/edit" modelAttribute="theClass" method="put">
		
			<div>
			 	<form:errors path="className"/>
				<form:label for="className" path="className">Title:</form:label>
				<form:input type="text" path="className" />
			</div>
			
			<div>
				<form:errors path="instructor" />
				<form:label for="instructor" path="instructor">Author:</form:label>
				<form:input type="text" path="instructor"/>
			</div>
			
			<div>
				<form:errors path="weekday"/>
				<form:label for="weekday" path="weekday">Thoughts:</form:label>
				<form:textarea path="weekday"/>
			</div>
			<div>
				<form:errors path="price"/>
				<form:label for="price" path="price">Thoughts:</form:label>
				<form:input type="float" path="price"/>
			</div>
			<div>
				<form:errors path="description"/>
				<form:label for="description" path="description">Description:</form:label>
				<form:input type="text" path="description"/>
			</div>
			
			<div>
				<form:errors path="user"/>
				<form:input type="hidden" path="user" value="${user.id}"/>
			</div>
			
			<div>
				<input type="submit" value="Submit"/>
			</div>
			
		</form:form>
		
		<button><a href="/theClass/${theClass.id}/delete">delete entry</a></button>
	</div>



</div>

</body>
</html>