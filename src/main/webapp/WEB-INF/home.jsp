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
	<title>Project Manager Dashboard</title>


</head>
<body>

	<div>
		<h1>Namaste, <c:out value="${user.userName}"/></h1>
		
		<h3>All Classes:</h3>
		<a href="/logout">logout</a>
		<a href="/addPage">+ Add a class</a>
		
		<table>
		
			<tr>
				<th>Class Name</th>
				<th>Instructor</th>
				<th>Weekday</th>
				<th>Price</th>
				<th>Actions</th>
			</tr>
			
			

			
			
			
			
			<c:forEach var="theClass" items="${theClass}">
				

					<tr>
						<td><a href="theClass/${theClass.id}"><c:out value="${theClass.className}"/></a></td>
						<td><c:out value="${theClass.instructor}"/></td>
						<td><c:out value="${theClass.weekday}"/></td>
						<td>$<c:out value="${theClass.price}"/></td>
		
					
					
							<c:if test="${user.id==theClass.user.id}">
						
						
							<td><a href="theClass/${theClass.id}/edit">edit</a> <a href="theClass/${theClass.id}/delete">delete</a></td>
					</c:if>
						
					</tr>
					
		
				
				
			</c:forEach>
		
		</table>
		

		
	</div>

</body>
</html>