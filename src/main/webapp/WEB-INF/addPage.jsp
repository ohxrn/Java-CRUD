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
	<title>Create a course</title>

</head>
<body>
<div>

	

	<a href="/home">back to classes</a>

	<div>
		<form:form action="/theClass" modelAttribute="theClass" method="post">
		
			<div>
			 	<form:errors path="className"/>
				<form:label for="className" path="className">Class name:</form:label>
				<form:input type="className" path="className" />
			</div>
			
			<div>
				<form:errors path="instructor"/>
				<form:label for="instructor" path="instructor">Instructor:</form:label>
				<form:input type="text" path="instructor"/>
			</div>
			
			<div>
				<form:errors path="weekday"/>
				<form:label for="weekday" path="weekday">Weekday</form:label>
				<form:input path="weekday"/>
			</div>
			
			<div>
				<form:errors path="price"/>
				<form:label for="price" path="price">Price</form:label>
				<form:input type="float" path="price"/>
			</div>
				<div>
				<form:errors path="description"/>
				<form:label for="description" path="description">Description</form:label>
				<form:input type="text" path="description"/>
			</div>
			
			
		
			
			
			<div >
				<form:errors path="user"/>
				<form:input type="hidden" path="user" value="${user.id}"/>
			</div>
			
			
			<div >
				<input type="submit" value="Submit" />
			</div>
			
		</form:form>
	</div>



</div>

</body>
</html>