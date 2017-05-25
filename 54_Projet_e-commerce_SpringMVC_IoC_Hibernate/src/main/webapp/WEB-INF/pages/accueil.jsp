<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Sith-e commerce - Accueil</title>

</head>

<body>
	<%@ include file="header.jsp"%>

	<h1 style="color: red; text-align: center">${msg1}</h1>
	<h1 style="color: red; text-align: center">${msg2}</h1>
	<h1 style="color: red; text-align: center">${msg3}</h1>
	<br />

	<div align="center">
		<table width="100%" cellpadding="6">
			<tr style="background-color: grey; color: white; text-align: center;">
				<th>ID</th>
				<th>Nom des catégories</th>
				<th>Photo des catégories</th>
				<th>Descritpion des catégories</th>
			</tr>
			<c:forEach var="accueil" items="${categoriesListe}">
				<tr>
					<td>${categorie.idCategorie}</td>
					<td>${categorie.nomCategorie}</td>
					<td>${categorie.photo}</td>
					<td>${categorie.descritpion}</td>
					<td><a
						href="${pageContext.request.contextPath}/accueil/deleteCategorie/${categorie.idCategorie}">Supprimer</a>
						| <a
						href="${pageContext.request.contextPath}/accueil/updateCategorie?idCategorie=${categorie.idCategorie}">Modifier</a></td>
					<!-- point d'int pour dire parametre de la requete url -->
					<!-- pour faire la différence entre le slash et le point d'id, pour le slah c'est une ressource on va utiliser atPathVariable pour le point d'int c'est un param donc atRequestParam-->
				</tr>
			</c:forEach>
		</table>

		<%@ include file="footer.jsp"%>
</body>
</html>

