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

<title>Sith-e commerce - Accueil</title>

</head>

<body>
	<%@ include file="/WEB-INF/templates/header.jsp"%>
	<%@ include file="/WEB-INF/templates/nav.jsp"%>
	<div
		style="background-image:url(<c:url value='/resources/images/background7.jpg' />)">
		<h1 style="color: red; text-align: center">${msg1}</h1>
		<h1 style="color: red; text-align: center">${msg2}</h1>
		<br />


		<div>
			<form action="produitsByKW">
				<table>
					<tr>
						<td><input type="text" name="m" value="${m}"></td>
						<td><input type="submit" value="Rechercher un produit"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>

	<%@ include file="/WEB-INF/templates/footer.jsp"%>
</body>
</html>

