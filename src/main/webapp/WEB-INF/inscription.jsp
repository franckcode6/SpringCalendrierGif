<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
		<form:form modelAttribute="utilisateur" action="inscription" method="post">
	<form:label class="form-label" path="nom">Nom</form:label>
	<form:input class="form-control" path="nom" />
	<form:errors path="nom" cssClass="erreur" /><br>
	<form:label class="form-label" path="prenom">Prénom</form:label>
	<form:input class="form-control" path="prenom" />
	<form:errors path="prenom" cssClass="erreur" /><br>
	<form:label class="form-label" path="email">Email</form:label>
	<form:input class="form-control" path="email" />
	<form:errors path="email" cssClass="erreur" /><br>
	<form:label class="form-label" path="motDePasse">Mot de passe</form:label>
	<form:password class="form-control" path="motDePasse" />
	<form:errors path="motDePasse" cssClass="erreur" /><br>
	<form:label class="form-label" path="theme">Thème</form:label>
	<form:select class="form-select" path="theme">
		<form:option value="0">Merci de choisir un thème</form:option>
		<form:options items="${theme}" itemValue="id" itemLabel="nom"/>
	</form:select>
	<form:errors path="theme" cssClass="erreur" /><br>
	<form:button class="btn btn-success">Inscription</form:button>
</form:form>
	</main>

	<jsp:include page="piedDePage.jsp"></jsp:include>
</body>
</html>