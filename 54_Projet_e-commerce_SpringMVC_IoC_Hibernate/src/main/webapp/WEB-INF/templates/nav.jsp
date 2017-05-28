<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width-device-width, initial-scale-1">

<title>Insert title here</title>
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
				<a class="navbar-brand"
					href="${pageContext.request.contextPath}/sith-e-commerce/accueil">Accueil</a>
				<a class="navbar-brand"
					href="${pageContext.request.contextPath}/categories/formulaireAdd">Catégories</a>
				<a class="navbar-brand"
					href="${pageContext.request.contextPath}/produits/formulaireAddPro">Produits</a>
			</div>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/loginPage">Login</a></li>
				<li><a href="<c:url value="/j_spring_security_logout"/>">Logout</a></li>
			</ul>
		</div>
	</nav>

</body>
</html>