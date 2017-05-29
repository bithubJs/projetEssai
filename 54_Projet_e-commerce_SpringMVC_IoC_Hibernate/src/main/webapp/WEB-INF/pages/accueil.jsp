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

<title>Sith-e commerce - Accueil</title>

</head>

<body>
	<%@ include file="/WEB-INF/templates/header.jsp"%>
	<%@ include file="/WEB-INF/templates/nav.jsp"%>



	<br />


	<div class="dropdown">
		<button class="btn btn-default dropdown-toggle" type="button"
			id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
			aria-expanded="true">
			SELECTIONNE UNE CATEGORIE <span class="caret"></span>
		</button>
		<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
			<c:forEach items="${categoriesListe}" var="cat">
				<li><a
					href="${pageContext.request.contextPath}/sith-e-commerce/produitsByCat/${cat.idCategorie}">${cat.nomCategorie}
				</a></li>
			</c:forEach>
		</ul>
	</div>


	<div align="center">
		<table class="table table-hover">
			<tr style="background-color: grey; color: white; text-align: center;">
				<th>Designation des produits</th>
				<th>Description des produits</th>
				<th>Prix</th>
				<th>Quantit�</th>
				<th>Photo</th>

			</tr>
			<c:forEach var="produit" items="${produitsListe}">
				<tr>
					<td>${produit.description}</td>
					<td>${produit.designation}</td>
					<td>${produit.prix}</td>
					<td>${produit.quantite}</td>
					<td><img src="photoProduit?proId=${produit.idProduit}"></td>
			</c:forEach>
		</table>
	</div>

	<%@ include file="/WEB-INF/templates/footer.jsp"%>
</body>
</html>

