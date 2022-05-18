<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Placer un gif televerse</title>
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
	<h1>Téléverser un nouveau gif</h1>

	<form action="" method="post" enctype="multipart/form-data">
		<input type="file" name="fichier" accept="image/gif" placeholder="URL">
		<br> <input type="text" name="legende" placeholder="Légende">
		<br> <input type="submit" class="button" value="Envoyer">
	</form>
</body>
</html>