<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Formulaire Ajouter des Catégories</title>

</head>

<body>

	<h1 style="color: red; text-align: center">Ajouter des catéGORILLE</h1>

	<form:form action="addCategorie" method="POST"
		modelAttribute="mCategorie">
		<form:input path="hidden" path="idCategorie" />
		<br />
		Nom : <form:input path="nomCategorie" />
		<form:errors path="nomCategorie" cssStyle="color:red" />
		<br />
		Photo : <form:input path="photo" />
		<form:errors path="photo" cssStyle="color:red" />
		<br />
		Description  :<form:input path="description" />
		<form:errors path="description" cssStyle="color:red" />
		<br />
		<input type="submit" value="Ajouter la catégorie">
	</form:form>

	<br />
	<a href="accueil">Retourner à l'accueil</a>
	<a href="<c:url value="/j_spring_security_logout"/>">Se déconnecter</a>

</body>
</html>