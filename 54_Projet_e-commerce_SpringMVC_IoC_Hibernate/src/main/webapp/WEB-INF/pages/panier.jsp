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

<title>Sith-e commerce - panier</title>

</head>

<body>
	<%@ include file="/WEB-INF/templates/header.jsp"%>
	<%@ include file="/WEB-INF/templates/nav.jsp"%>

	<div align="center">
		<table class="table table-hover">
			<tr style="background-color: grey; color: white; text-align: center;">
				<th></th>
				<th>Designation des produits</th>
				<th>Prix</th>
				<th>Quantité</th>
				<th>Photo</th>
				<th>Quantité</th>
				<th>Action</th>

			</tr>
			<c:forEach var="panier" items="${pListe}">
				<tr>
					<td>${pListe.indexOf(panier)}</td>
					<td>${panier.produit.designation}</td>
					<td>${(panier.produit.prix*panier.quantite)}</td>
					<td>${panier.quantite}</td>

					<td><img
						src="${pageContext.request.contextPath}/sith-e-commerce/photoProduit?proId=${produit.idProduit}">
					<td class="text-right">
						<button type="button" title="Add"
							class="btn btn-success btn-simple btn-xs"
							onclick="location.href='${pageContext.request.contextPath}/sith-e-commerce/panier/q+?Id=${pListe.indexOf(panier)}'">
							<i class="material-icons">+</i>
						</button>
						<button type="button" title="Remove"
							class="btn btn-warning btn-simple btn-xs"
							onclick="location.href='${pageContext.request.contextPath}/sith-e-commerce/panier/q-?Id=${pListe.indexOf(panier)}'">
							<i class="material-icons">-</i>
						</button>
						<button type="button" title="Delete"
							class="btn btn-danger btn-simple btn-xs"
							onclick="location.href='${pageContext.request.contextPath}/sith-e-commerce/panier/delete?Id=${pListe.indexOf(panier)}'">
							<i class="material-icons">Supprimer du panier</i>
						</button>
					</td>



				</tr>
			</c:forEach>
		</table>
	</div>


	<%@ include file="/WEB-INF/templates/footer.jsp"%>

</body>
</html>