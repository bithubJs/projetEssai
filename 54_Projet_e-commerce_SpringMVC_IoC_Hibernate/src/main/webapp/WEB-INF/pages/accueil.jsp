<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%> --%>


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

	<h1 style="color: red; text-align: center">${msg1}</h1>
	<h1 style="color: red; text-align: center">${msg2}</h1>
	<br />


	<div align="center">
		<table width="100%" cellpadding="6">
			<tr style="background-color: grey; color: white; text-align: center;">
				<th>Nom des catégories</th>
				<th>Photo des catégories</th>
				<th>Description des catégories</th>
			</tr>
			<c:forEach var="categorie" items="${categoriesListe}">
				<tr>
					<td>${categorie.nomCategorie}</td>
					<td><img src="photoCategorie?catId=${categorie.idCategorie}"></td>
					<td>${categorie.description}</td>
					<td><a
						href="${pageContext.request.contextPath}/sith-e-commerce/deleteCategorie/${categorie.idCategorie}">Supprimer</a>
						| <a
						href="${pageContext.request.contextPath}/sith-e-commerce/updateCategorie?catId=${categorie.idCategorie}">Modifier</a></td>
					<!-- point d'int pour dire parametre de la requete url -->
					<!-- pour faire la différence entre le slash et le point d'id, pour le slah c'est une ressource on va utiliser atPathVariable pour le point d'int c'est un param donc atRequestParam-->
				</tr>
			</c:forEach>
		</table>
	</div>

	<div align="center">
		<table width="100%" cellpadding="6">
			<tr style="background-color: grey; color: white; text-align: center;">
				<th>Designation des produits</th>
				<th>Description des produits</th>
				<th>Prix</th>
				<th>Quantité</th>
				<th>Sélectionné</th>
				<th>Photo</th>

			</tr>
			<c:forEach var="produit" items="${produitsListe}">
				<tr>
					<td>${produit.description}</td>
					<td>${produit.designation}</td>
					<td>${produit.prix}</td>
					<td>${produit.quantite}</td>
					<td>${produit.selectionne}</td>
					<td><img src="photoProduit?proId=${produit.idProduit}"></td>

					<td><a
						href="${pageContext.request.contextPath}/produits/deleteProduit/${produit.idProduit}">Supprimer</a>
						| <a
						href="${pageContext.request.contextPath}/produits/updateProduit?proId=${produit.idProduit}">Modifier</a></td>
					<!-- point d'int pour dire parametre de la requete url -->
					<!-- pour faire la différence entre le slash et le point d'id, pour le slah c'est une ressource on va utiliser atPathVariable pour le point d'int c'est un param donc atRequestParam-->
				</tr>
			</c:forEach>
		</table>
	</div>

	<%@ include file="/WEB-INF/templates/footer.jsp"%>
</body>
</html>

