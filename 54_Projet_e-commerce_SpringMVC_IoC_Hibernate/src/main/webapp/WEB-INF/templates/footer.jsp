<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width-device-width, initial-scale-1">


<style type="text/css">
.imageGauche {
	float: left;
	width: 10%;
}

.imageDroite {
	float: right;
	width: 10%;
}
</style>

<title>Insert title here</title>

</head>
<body>

	<div>
		<img class="imageGauche"
			src="<c:url value="/images/StormtrooperFooter.jpg" />" /> <img
			class="imageDroite"
			src="<c:url value="/images/StormtrooperFooter.jpg" />" />
	</div>
	<br />
	<div style="background-color: black; height: 40px">
		<div align="center">
			<table cellpadding="9" width="100%" style="text-align: center">
				<tr style="background-color: black; color: white">
					<td><b>Besoin d'aide</b></td>
					<td><b>Boutique à Lille</b></td>
					<td><b>Suivez-nous</b></td>
				</tr>
				<tr style="background-color: black; color: white">
					<td>Contactez-nous</td>
					<td>Client</td>
					<td>Facebook</td>
				</tr>
				<tr style="background-color: black; color: white">
					<td>Prix de livraison</td>
					<td>Avis</td>
					<td>Twitter</td>
				</tr>
				<tr style="background-color: black; color: white">
					<td>Suivez votre commande</td>
					<td>Heures d'ouvertures</td>
					<td>Notre boutique Ebay</td>
				</tr>
				<tr style="background-color: black; color: white">
					<td>Retours et remboursements</td>
					<td>Comment nous trouver</td>
					<td>Notre boutique Amazon</td>
				</tr>
			</table>
			<div style="background-color: black">
				<br /> <img cellpadding="12"
					src="<c:url value="/images/cardsaccepted.png" />" />
			</div>
		</div>
	</div>
</body>
</html>