<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.2/font/bootstrap-icons.css">
<title>Inscription</title>
<style type="text/css">
</style>
</head>
<body>
	<jsp:include page="hautDePage.jsp"></jsp:include>
	<main class="container">
		<form action="inscription" method="post">
			<div class="mb-3">
				<label class="form-label" for="nom">Nom</label> 
				<input class="form-control" name="NOM">
			</div>
			
			<div class="mb-3">
			<label class="form-label" for="prenom">Prénom</label>
			<input class="form-control" name="PRENOM">
			</div>
			
			<div class="mb-3">
			<label class="form-label" for="email">Email</label>
			<input class="form-control" type="email" name="EMAIL">
			</div>
			
			<div class="mb-3">
			<label class="form-label" for="mot_de_passe">Mot de passe</label>
			<input class="form-control"  type="password" name="MOT_DE_PASSE">
			</div>
			
			<div class="mb-3">
			<label class="form-label" for="theme">Theme</label>
			<select class="form-select" name="THEME_ID">
				<option value="0">Merci de choisir un thème</option>
				<c:forEach items="${themes}" var="theme">
					<option class="form-control" value="${theme.id}">${theme.nom}</option>
				</c:forEach>
			</select>
			</div>

			<input class="btn btn-success" type="submit" value="Inscription">
		</form>
	</main>

	<jsp:include page="piedDePage.jsp"></jsp:include>
</body>
</html>