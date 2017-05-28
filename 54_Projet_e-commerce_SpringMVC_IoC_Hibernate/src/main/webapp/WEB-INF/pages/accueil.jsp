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

<title>Sith-e commerce - Accueil</title>

</head>

<body>
	<%@ include file="/WEB-INF/templates/header.jsp"%>
	<%@ include file="/WEB-INF/templates/nav.jsp"%>
	<div
		style="background-image:url(<c:url value='/resources/images/background7.jpg' />)">
		<h1 style="color: red; text-align: center">${msg1}</h1>
		<h1 style="color: red; text-align: center">${msg2}</h1>
		<br />




		<div align="center">
			<table width="100%" cellpadding="6">
				<tr
					style="background-color: grey; color: white; text-align: center;">
					<th>Nom des catégories</th>
					<th>Photo des catégories</th>
					<th>Description des catégories</th>

					<table>
						<c:forEach items="${categoriesListe}" var="categorie">
							<tr>
								<td><a href="produitsByCat?idCat=${categorie.idCategorie}">
										${categorie.nomCategorie} </a></td>
							</tr>
						</c:forEach>
					</table>

					<div>
						<form action="produitsByKW">
							<table>
								<tr>
									<td><input type="text" name="m" value="${m}"></td>
									<td><input type="submit" value="Rechercher un produit"></td>
								</tr>

								<c:forEach var="categorie" items="${categoriesListe}">
									<tr>
										<td>${categorie.nomCategorie}</td>
										<td><img
											src="photoCategorie?catId=${categorie.idCategorie}"></td>
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
							</form>
					</div>
			</table>
			
		</div>

		<div align="center">
			<table width="100%" cellpadding="6">
				<tr
					style="background-color: grey; color: white; text-align: center;">
					<th>Designation des produits</th>
					<th>Description des produits</th>
					<th>Prix</th>
					<th>Quantité</th>
					<th>Sélectionné</th>
					<th>Photo</th>


					<div style="display: none">
						<c:if test="${panier.size!=0}">
							<table>
								<tr>
									<th>ID</th>
									<th>Désignation</th>
									<th>Prix</
									<th>Quantité</th>
									<th>Montant</th>
								</tr>

								<c:forEach var="produit" items="${produitsListe}">
									<tr>
										<td>${produit.description}</td>
										<td>${produit.designation}</td>
										<td>${produit.prix}</td>
										<td>${produit.quantite}</td>
										<td>${produit.selectionne}</td>
										<td><img src="photoProduit?proId=${produit.idProduit}"></td>
									</tr>
								</c:forEach>

								<c:forEach items="${panier.items}" var="items">
									<tr>
										<td>${items.produit.idProduit}</td>
										<td>${items.produit.designation}</td>
										<td>${items.produit.prix}</td>
										<td>${items.quantite}</td>
										<td>${items.quantite*items.produit.prix}</td>
									</tr>
									<tr>
										<td colspan="4">Total</td>
										<td>${panier.total}</td>
									</tr>
								</c:forEach>
							</table>
						</c:if>
					</div>

					<!-- 						<td><a -->
					<%-- 							href="${pageContext.request.contextPath}/produits/deleteProduit/${produit.idProduit}">Supprimer</a> --%>
					<!-- 							| <a -->
					<%-- 							href="${pageContext.request.contextPath}/produits/updateProduit?proId=${produit.idProduit}">Modifier</a></td> --%>
					<!-- 						point d'int pour dire parametre de la requete url -->
					<!-- 						pour faire la différence entre le slash et le point d'id, pour le slah c'est une ressource on va utiliser atPathVariable pour le point d'int c'est un param donc atRequestParam -->

					<%-- 				</c:forEach> --%>
					<!-- 			</table> -->
					<!-- 		</div> -->
					<!-- 	</div> -->

					<div>
						<c:forEach items="${produitsListe}" var="produit">
							<div>
								<table>
									<tr>
										<td colspan="2"><img alt=""
											src="photoProduit?idP=${produit.idProduit}"></td>
									</tr>
									<tr>
										<td>Désignation</td>
										<td>${produit.designation}</td>
									</tr>
									<tr>
										<td>Prix</td>
										<td>${produit.prix}</td>
									</tr>
									<tr>
										<td>Quantité</td>
										<td>${produit.quantite}</td>
									</tr>
									<tr>
										<td>Description</td>
										<td>${produit.description}</td>
									</tr>
									<tr>
										<td colspan="2">
											<form action="ajouterPanier">
												<input type="hidden" value="${produit.idProduit}"
													name="idProduit"> <input type="text" value="1"
													name="quantite"> <input type="submit"
													value="Ajouter au panier">
											</form>
										<td>
									</tr>
								</table>
							</div>

						</c:forEach>
					</div>
				</tr>
			</table>
		</div>
	</div>

	<%@ include file="/WEB-INF/templates/footer.jsp"%>
</body>
</html>

