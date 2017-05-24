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

	<form action="j_spring_security_check" method="post">
		Login <input type="text" name="j_username" /> <br /> Password <input
			type="text" name="j_password" /> <br /> <input type="submit"
			value="Connection">
	</form>

	<c:if test="${not empty erreur}">
		<h1 style="color: red">Login ou password est incorrecte</h1>
	</c:if>

</body>
</html>