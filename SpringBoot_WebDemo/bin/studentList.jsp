<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<DOCTYPE html>
<html lang="en">
  <head> 
     <title>Student List</title>
  </head>
   <body>
	<h1>Student List</h1>
	<ul>
		<c:forEach items="${students}" var="aStudent">
		  <li>${aStudent.name}</li>
		</c:forEach>
	</ul> 
   </body>
</html>