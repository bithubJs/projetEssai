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
	<div class="row">
		<c:forEach items="${categoriesListe}" var="cat">
		<div class="col-sm-6 col-md-4">
			<div class="thumbnail">
				<img src="photoCategorie?catId=${cat.idCategorie}"
					alt="${cat.nomCategorie}">
				<div class="caption">
					<h3>${cat.nomCategorie }</h3>
					<p>${cat.description}</p>
					<p>
						<a href="${pageContext.request.contextPath}/sith-e-commerce/produitsByCat/${cat.idCategorie}" class="btn btn-primary" role="button">Aller voir</a>
					</p>
				</div>
			</div>
		</div>

		<!-- <div class="col-sm-6 col-md-4">
			<div class="thumbnail">
				<img src="<c:url value="/resources/images/hightech.jpg" />"
					alt="hightech">
				<div class="caption">
					<h3>High Tech</h3>
					<p>Pour rester à la pointe de la technologie, on a tout ce
						qu'il vous faut et en bonne qualité, que ce soit du neuf ou même
						tombé du camion (tout est stocké dans nos caves-entrepôts à Lille
						Sud). Non sérieusement, High Tech est l'une de notre meilleure
						catégorille.. &#128586;</p>
					<p>
						<a href="#" class="btn btn-primary" role="button">Aller voir</a>
					</p>
				</div>
			</div>
		</div>

		<div class="col-sm-6 col-md-4">
			<div class="thumbnail">
				<img src="<c:url value="/resources/images/electromenager.jpg" />"
					alt="electromenager">
				<div class="caption">
					<h3>Electroménager</h3>
					<p>Fête des mères, journée de la femme, Saint Valentin, ...,
						offrez à votre conjointe un magnifique appareil pour la cuisine ou
						votre linge sale ! Ces longues heures de plaisir pour elle où vous
						pourrez profiter de votre liberté.. &#128536;</p>
					<p>
						<a href="#" class="btn btn-primary" role="button">Aller voir</a>
					</p>
				</div>
			</div>
		</div>

		<div class="col-sm-6 col-md-4">
			<div class="thumbnail">
				<img src="<c:url value="/resources/images/informatique.jpg" />"
					alt="informatique">
				<div class="caption">
					<h3>Informatique</h3>
					<p>Vous avez une liste d'exos sur JPA à faire pour demain ? Un
						(petit) projet Spring MVC de 4 jours à faire pour lundi ?? Vous
						trouverez ici tout ce qu'il vous faut afin de réussir et faire
						plaisir à votre formateur JAVA &#128518;</p>
					<p>
						<a href="#" class="btn btn-primary" role="button">Aller voir</a>
					</p>
				</div>
			</div>
		</div>

		<div class="col-sm-6 col-md-4">
			<div class="thumbnail">
				<img src="<c:url value="/resources/images/jardin.jpg" />"
					alt="jardin">
				<div class="caption">
					<h3>Jardin</h3>
					<p>Quoi de mieux pour cet été, après être passé dans la
						catégorie informatique, après 3 mois de formation, que de profiter
						du beau temps et de la chaleur pour vous reposer (enfin) dans nos
						somptueux spas gonflables, suivi d'un bon barbecue près de la
						piscine !? &#128704;</p>
					<p>
						<a href="#" class="btn btn-primary" role="button">Aller voir</a>
					</p>
				</div>
			</div>
		</div>-->
		</c:forEach>
	</div>



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
				<th>Quantité</th>
				<th>Photo</th>

			</tr>
			<c:forEach var="produit" items="${produitsListe}">
				<tr>
					<td>${produit.description}</td>
					<td>${produit.designation}</td>
					<td>${produit.prix}</td>
					<td>${produit.quantite}</td>
					<td><img src="photoProduit?proId=${produit.idProduit}"></td>

					<td class="text-right">
						<form
							action="${pageContext.request.contextPath}/sith-e-commerce/panier/add/${produit.idProduit}"
							method="GET">
							<div class="form-group">
								<input type="number" name="qt" value="1" min="0" max="5000"
									placeholder="0" class="form-control" />
							</div>

							<button type="submit" title="Edit"
								class="btn btn-success btn-simple btn-xs">
								<i class="material-icons">Ajouter au panier</i>
							</button>
						</form>
					</td>

				</tr>
			</c:forEach>
		</table>
	</div>

	<%@ include file="/WEB-INF/templates/footer.jsp"%>
</body>
</html>

