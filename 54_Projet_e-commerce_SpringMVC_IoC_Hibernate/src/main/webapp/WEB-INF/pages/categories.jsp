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

<title>Sith-e commerce - Categories</title>

</head>

<body>
	<%@ include file="/WEB-INF/templates/header.jsp"%>
	<%@ include file="/WEB-INF/templates/nav.jsp"%>

	<a href="${pageContext.request.contextPath}/categories/formulaireAdd">Ajouter
		une catégorie</a>

	<br />

	<div align="center">
		<table class="table table-hover">
			<tr style="background-color: grey; color: white; text-align: center;">
				<th>Nom des catégories</th>
				<th>Photo des catégories</th>
				<th>Description des catégories</th>
				<th>Opérations</th>
			</tr>
			<c:forEach var="categorie" items="${categoriesListe}">
				<tr>
					<td>${categorie.nomCategorie}</td>
					<td><img src="photoCategorie?catId=${categorie.idCategorie}"></td>
					<td>${categorie.description}</td>
					<td><a
						href="${pageContext.request.contextPath}/categories/deleteCategorie/${categorie.idCategorie}">Supprimer</a>
						| <a
						href="${pageContext.request.contextPath}/categories/updateCategorie?catId=${categorie.idCategorie}">Modifier</a></td>
					<!-- point d'int pour dire parametre de la requete url -->
					<!-- pour faire la différence entre le slash et le point d'id, pour le slah c'est une ressource on va utiliser atPathVariable pour le point d'int c'est un param donc atRequestParam-->
				</tr>
			</c:forEach>
		</table>
	</div>

	<%@ include file="/WEB-INF/templates/footer.jsp"%>

</body>
</html>

