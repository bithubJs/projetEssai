<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page du login</title>
</head>
<body>

	<div>

		<form action="j_spring_security_check" method="post">
			<table>
				<tr>
					<td>Login</td>
					<td><input type="text" name="j_username" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="j_password" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Login"></td>
				</tr>
			</table>
		</form>

		<c:if test="${not empty erreur}">
			<h1 style="color: red">Login ou password est incorrect</h1>
		</c:if>

	</div>


</body>
</html>