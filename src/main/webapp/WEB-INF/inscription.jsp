<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
    <style type="text/css">
<%@include file="style/themeJ.css"%>
</style>
</head>
<body>
    <h1>Inscription</h1>
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
</body>
</html>