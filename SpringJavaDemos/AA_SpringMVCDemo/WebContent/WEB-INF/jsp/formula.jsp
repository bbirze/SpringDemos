<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Solve the Quadratic Formula</title>
</head>
<body>
	<h3>Solve the Quadratic Formula</h3>
	<form action="formula.html" method="post">
	  <table>
	  	<tr>
	  	  <td>Enter <i>a</i> value:</td>
	  	  <td><input type="text" name="a" value="${a}" /></td>
	  	</tr>
	  	<tr>
	  	  <td>Enter <i>b</i> value:</td>
	  	  <td><input type="text" name="b" value="${b}" /></td>
	  	</tr>
	  	<tr>
	  	  <td>Enter <i>c</i> value:</td>
	  	  <td><input type="text" name="c" value="${c}" /></td>
	  	</tr>
	  	<tr>
	  	  <td><input type="submit" value="Solve equation" /></td>
	  	</tr>
	  </table>
	</form>
</body>
</html>