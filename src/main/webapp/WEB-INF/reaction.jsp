<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter une réaction</title>
<c:choose>
	<c:when test="${sessionScope.utilisateur.theme.id eq 1}">
		<style type="text/css">
<%@include file="style/darksalmon.css"%>
</style>
	</c:when>
	<c:otherwise>
		<style type="text/css">
<%@include file="style/dark.css"%>
</style>
	</c:otherwise>
</c:choose>
</head>

<body>
	<h1>Ajouter une réaction</h1>
	<c:if test="${gif.getClass().simpleName eq 'GifDistant'}">
		<img src="${gif.url}" height="200" alt="Super image du calendrier !">
	</c:if>
	<c:if test="${gif.getClass().simpleName eq 'GifTeleverse'}">
		<img src="../images/${gif.nomFichierOriginal}"
			height="200" alt="${gif.nomFichierOriginal}"
			title="${gif.nomFichierOriginal}">
	</c:if>
	<form action="" method="post">
		<label>Réaction</label> <select name="emotion_id">
			<option>Merci de choisir une réaction</option>
			<c:forEach items="${emotions}" var="emotion">
				<option value="${emotion.id}">${emotion.nom}:
					${emotion.code}</option>
			</c:forEach>
		</select><br> <input class="button" type="submit" value="Envoyer">
	</form>
</body>
</html>