<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Formulaire Ajouter des Produits</title>

</head>

<body>

	<h1 style="color: red; text-align: center">Ajouter des Produits</h1>

	<form:form action="addProduit" method="POST" modelAttribute="mProduit">
		<form:input path="hidden" path="idProduit" />
		<br />
		Categorie : <form:input path="categorie.idCategorie"
			items="${categories}" itemLabel="nomCategorie"
			itemValue="idCategorie" />
		<form:errors path="categorie.idCategorie" cssStyle="color:red" />
		<br />
		Description : <form:input path="description" />
		<form:errors path="description" cssStyle="color:red" />
		<br />
		Designation  :<form:input path="designation" />
		<form:errors path="designation" cssStyle="color:red" />
		<br />
		Prix  :<form:input path="prix" />
		<form:errors path="prix" cssStyle="color:red" />
		<br />
		Quantite  :<form:input path="quantite" />
		<form:errors path="quantite" cssStyle="color:red" />
		<br />
		Selectionne  :<form:input path="selectionne" />
		<form:errors path="selectionne" cssStyle="color:red" />
		<br />
		Photo  :<c:if test="${produit.idProduit!=null}">
			<form:input type="hidden" path="photo" />
			<img alt=""
				src="<%=request.getContextPath()%>/photoProduit?idP=${produit.idProduit}">
			<form:errors path="photo" cssStyle="color:red" />
			<br />
		</c:if>
		<form:input type="file" name="file"></form:input>
		<form:errors path="file" cssStyle="color:red" />
		<input type="submit" value="Ajouter le produit">
	</form:form>



	<br />
	<a href="accueil">Retourner à l'accueil</a>
	<a href="<c:url value="/j_spring_security_logout"/>">Se déconnecter</a>

</body>
</html>