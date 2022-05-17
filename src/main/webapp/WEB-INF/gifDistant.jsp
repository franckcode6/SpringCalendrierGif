<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Placer un gif distant</title>
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
	<h1>Nouveau Gif distant</h1>
	

	<form action="" method="post">
		<input type="text" name="URL" placeholder="URL"> <br> <input
			type="text" name="LEGENDE" placeholder="Légende"> <br> <input
			class="button" type="submit" value="Placer">
	</form>
</body>
</html>