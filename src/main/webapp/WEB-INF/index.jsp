<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calendrier Gif</title>
<style type="text/css">
<%@include file="style/themeJ.css"%>
</style>
</head>
<body>
<h1>Calendrier Gif</h1>
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