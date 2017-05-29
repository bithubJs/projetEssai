<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-3.2.1.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap.js" />"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap.css" />">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap-theme.css" />">

<title>Login</title>

</head>

<body>
	<%@ include file="/WEB-INF/templates/header.jsp"%>
	<%@ include file="/WEB-INF/templates/nav.jsp"%>

	<div>
		<form class="form-horizontal" action="j_spring_security_check"
			method="post">
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">Login</label>
				<div class="col-sm-10">
					<input type="text" name="j_username" class="form-control"
						id="inputEmail3" placeholder="Login">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
				<div class="col-sm-10">
					<input type="password" name="j_password" class="form-control"
						id="inputPassword3" placeholder="Password">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" value="login" class="btn btn-default">Sign
						in</button>
				</div>
			</div>
		</form>
		<c:if test="${not empty erreur}">
			<h1 style="color: red">Login ou password incorrect</h1>
		</c:if>
	</div>

	<%@ include file="/WEB-INF/templates/footer.jsp"%>

</body>
</html>