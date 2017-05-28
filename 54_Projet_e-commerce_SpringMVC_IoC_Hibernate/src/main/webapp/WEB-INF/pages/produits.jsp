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

<title>Produits</title>

</head>

<body>

	<%@ include file="/WEB-INF/templates/header.jsp"%>
	<%@ include file="/WEB-INF/templates/nav.jsp"%>


	<div align="center">

		<table width="100%" cellpadding="6">
			<tr style="background-color: grey; color: white; text-align: center;">
				<th>Designation des produits</th>
				<th>Description des produits</th>
				<th>Prix</th>
				<th>Quantit�</th>
				<th>S�lectionn�</th>
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
					<!-- 					point d'int pour dire parametre de la requete url pour faire la -->
					<!-- 					diff�rence entre le slash et le point d'id, pour le slah c'est une -->
					<!-- 					ressource on va utiliser atPathVariable pour le point d'int c'est -->
					<!-- 					un param donc atRequestParam -->
				</tr>
			</c:forEach>
		</table>
	</div>

	<%@ include file="/WEB-INF/templates/footer.jsp"%>

</body>

</html>