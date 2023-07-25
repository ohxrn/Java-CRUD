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
	<title>Insert title here</title>
	
</head>
<body>

	<div>
		<h1><c:out value="${theClass.className}"/> with ${theClass.instructor }</h1>
		
		<h3>Day: <c:out value="${theClass.weekday}"/></h3>
		<h3>Cost: $<c:out value="${theClass.price}"/></h3>
		


		
		
		<div>
			<h4>Here are <c:out value="${theClass.instructor}"/>'s thoughts:</h4>
			<hr />
			
			<p><c:out value="${theClass.description}"/></p>
			<hr />
		
		</div>
		
	</div>

</body>
</html>