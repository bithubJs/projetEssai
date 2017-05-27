<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript" src="JS/jquery-3.2.1.js"></script>
<script type="text/javascript" src="JS/bootstrap.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/bootstrap-theme.css">

<title>Formulaire Ajouter des Catégories</title>

</head>

<body>

	<%@ include file="/WEB-INF/templates/header.jsp"%>
	<%@ include file="/WEB-INF/templates/nav.jsp"%>

	<div align="center">
		<h1 style="color: red">Ajouter des catéGORILLE</h1>
	</div>

	<form:form action="addCategorie" method="POST"
		modelAttribute="mCategorie">

		<table>
			<tr>
				<td>Id Catégorie</td>
				<td>${categorie.idCategorie}<form:input type="hidden"
						path="idCategorie" /></td>
				<td><form:errors path="idCategorie"></form:errors></td>
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
				<c:if test="${categorie.idCategorie!=null}">
					<td><img src="photoCategorie?catId=${categorie.idCategorie}"></td>
				</c:if>
				<td><input type="file" name="file"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Ajouter la catégorie"></td>
			</tr>
		</table>
	</form:form>

	<div align="center">
		<table width="100%" cellpadding="6">
			<tr style="background-color: grey; color: white; text-align: center;">
				<th>ID</th>
				<th>Nom des catégories</th>
				<th>Photo des catégories</th>
				<th>Description des catégories</th>
			</tr>
			<c:forEach var="accueil" items="${categoriesListe}">
				<tr>
					<td>${categorie.idCategorie}</td>
					<td>${categorie.nomCategorie}</td>
					<td><img src="photoCategorie?catId=${categorie.idCategorie}"></td>
					<td>${categorie.description}</td>
					<td><a
						href="${pageContext.request.contextPath}/sith-e-commerce/deleteCategorie/${categorie.idCategorie}">Supprimer</a>
						| <a
						href="${pageContext.request.contextPath}/sith-e-commerce/updateCategorie?idCategorie=${categorie.idCategorie}">Modifier</a></td>
					<!-- point d'int pour dire parametre de la requete url -->
					<!-- pour faire la différence entre le slash et le point d'id, pour le slah c'est une ressource on va utiliser atPathVariable pour le point d'int c'est un param donc atRequestParam-->
				</tr>
			</c:forEach>
		</table>
	</div>

	<%@ include file="/WEB-INF/templates/footer.jsp"%>
</body>
</html>