<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

<title>Formulaire Ajouter des Catégories</title>

</head>

<body>

	<%@ include file="/WEB-INF/templates/header.jsp"%>
	<%@ include file="/WEB-INF/templates/nav.jsp"%>

	<div align="center">
		<h1 style="color: red">Ajouter des catéGORILLE</h1>
	</div>

	<form:form method="POST" action="addCategorie"
		modelAttribute="mCategorie" enctype="multipart/form-data">

		<table>
			<tr>
				<td><form:input type="hidden" path="idCategorie" /></td>
			</tr>
			<tr>
				<td>Nom Catégorie</td>
				<td><form:input path="nomCategorie" /></td>
				<td><form:errors path="nomCategorie" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td>Description Catégorie</td>
				<td><form:input path="description" /></td>
				<td><form:errors path="description" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td>Photo Catégorie</td>
				<td><input type="file" name="file"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Ajouter la catégorie"></td>
			</tr>
		</table>
	</form:form>

	<%@ include file="/WEB-INF/templates/footer.jsp"%>
</body>
</html>