<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

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

<title>Denied</title>
</head>
<body>

	<%@ include file="/WEB-INF/templates/header.jsp"%>
	<%@ include file="/WEB-INF/templates/nav.jsp"%>


	<h1 style="color: red; text-align: center;">Accès refusé, vous
		n'avez pas la permission, seul Dieu a la permission</h1>
	<a href="${pageContext.request.contextPath}/login">Try again</a>

	<%@ include file="/WEB-INF/templates/footer.jsp"%>


</body>
</html>