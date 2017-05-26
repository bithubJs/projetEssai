<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="Accueil.jsp">Accueil</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Client <span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<li><a href="CreateClient.jsp">Ajouter un client</a></li>
							<li><a href="UpdateClient.jsp">Modifier un client</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="GetByIdClient.jsp">Recup�rer un client par
									son ID</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="DeleteClient.jsp">Supprimer un client</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="AddCompteCourantClient.jsp">Attribuer un
									compte-courant � un client</a></li>
							<li><a href="AddCeToClient.jsp">Attribuer un
									compte-�pargne � un client</a></li>
						</ul></li>


					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Compte-Courant <span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<li><a href="getAllCompteCourant">Liste des
									comptes-courants</a></li>
							<li><a href="CreateCompteCourant.jsp">Ajouter un
									compte-courant</a></li>
							<li><a href="UpdateCompteCourant.jsp">Modifier un
									compte-courant</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="GetByIdCompteCourant.jsp">Recup�rer un
									compte-courant par son ID</a></li>
							<li><a href="GetByIdCompteCourantClient.jsp">Recup�rer
									un compte-courant par l'ID du client</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="DeleteCompteCourant.jsp">Supprimer un
									compte-courant</a></li>
						</ul></li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Compte-Epargne <span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<li><a href="getAllCompteEpargne">Liste des
									comptes-�pargnes</a></li>
							<li><a href="CreateCompteEpargne.jsp">Ajouter un
									compte-�pargne</a></li>
							<li><a href="UpdateCompteEpargne.jsp">Modifier un
									compte-�pargne</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="GetByIdCompteEpargne.jsp">Recup�rer un
									compte-�pargne par son ID</a></li>
							<li><a href="GetByIdCompteEpargneClient.jsp">Recup�rer
									un compte-�pargne par l'ID du client</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="DeleteCompteEpargne.jsp">Supprimer un
									compte-�pargne</a></li>
						</ul></li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Op�rations <span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<li><a href="DepositMoneyCompteCourant.jsp">D�poser de
									l'argent sur un compte-courant</a></li>
							<li><a href="WithdrawMoneyCompteCourant.jsp">Retirer de
									l'argent d'un compte-courant</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="DepositMoneyCompteEpargne.jsp">D�poser de
									l'argent sur un compte-�pargne</a></li>
							<li><a href="WithdrawMoneyCompteEpargne.jsp">Retirer de
									l'argent d'un compte-�pargne</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="TransfertCeToCc.jsp">Virement
									compte-�pargne vers compte-courant</a></li>
							<li><a href="TransfertCcToCe.jsp">Virement
									compte-courant vers compte-�pargne</a></li>
						</ul></li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li><a href="logout" class="btn btn-danger btn-lg"
						role="button">Logout</a></li>
				</ul>

				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</div>
	</nav>


</body>
</html>