<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calendrier Gif</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.2/font/bootstrap-icons.css">
<link href="style/style1.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="hautDePage.jsp"></jsp:include>
	<main class="container">
		<c:if test="${param.notification ne null}">
			<h2>${param.notification}</h2>
		</c:if>

		<form class="mb-3" action="" method="post">
			<div class="mb-3">
				<label class="form-label" for="email">Email</label> <input
					class="form-control" type="email" name="EMAIL" placeHolder="Email"
					required>
			</div>

			<div class="mb-3">
				<label class="form-label" for="mot_de_passe">Mot de passe</label> <input
					class="form-control" type="password" name="MOT_DE_PASSE"
					placeHolder="Mot de Passe" required>
			</div>
			<div class="d-flex justify-content-between">
				<input class="btn btn-success" type="submit" value="Connexion">
				<a class="btn btn-dark" href="inscription">S'inscrire</a>
			</div>
		</form>

		<!-- 	<a href="inscription">S'inscrire</a> -->
		<h2>Utilisateurs ayant réagi au moins 5 fois</h2>
		<ul>
			<c:forEach items="${utilisateurs}" var="utilisateur">
				<li>${utilisateur.prenom}</li>
			</c:forEach>
		</ul>
		<h2>Nb d'inscrits par année et par mois</h2>
		<c:forEach items="${nbInscrits}" var="nbInscrit">
	${nbInscrit.annee}/${nbInscrit.mois} : ${nbInscrit.nbInscrits}<br>
		</c:forEach>
		Nombre d'inscrits : ${nbTotalInscrits}
	</main>

	<jsp:include page="piedDePage.jsp"></jsp:include>
</body>
</html>