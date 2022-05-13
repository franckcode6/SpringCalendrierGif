<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Emotions</title>
</head>
<body>
	<h1>Calendrier GIF: les émotions</h1>
	<ul>
		<c:forEach items="${emotions}" var="emotion">
			<li>${emotion.code}:${emotion.nom}</li>
			<a href="emotion?ID=${emotion.id}"> Modifer/Supprimer</a>
		</c:forEach>
	</ul>
	<a href="emotion"><button>Ajouter une émotion</button> </a>
	<jsp:include page="piedDePage.jsp"></jsp:include>
</body>
</html>