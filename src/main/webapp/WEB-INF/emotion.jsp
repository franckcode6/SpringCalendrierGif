<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajout emotion</title>
</head>
<body>
	<c:if test="${emotion eq null }">
	<h1>Ajouter une nouvelle émotion</h1>
	</c:if>
	<c:if test="${emotion ne null }">
	<h1>Modifier ou supprimer une émotion</h1>
	</c:if>
	<form action="emotion" method="post">
		<input type="hidden" name="ID" value="${emotion.id}"><br>
		 <label>Nom</label>
		 <input type="text" name="NOM" value="${emotion.nom}"><br> 
		 <label>Code</label>
		 <input type="text" name="CODE" value="${emotion.code}"><br>
		<c:if test="${emotion eq null}">
			<input type="submit" value="Ajouter">
		</c:if>
		<c:if test="${emotion ne null}">
			<input type="submit" value="Modifier">
		</c:if>
	</form>
	<c:if test="${emotion ne null}">
		<a href="supprimerEmotion?ID=${emotion.id}"><button>Supprimer</button> </a>
	</c:if>
	<jsp:include page="piedDePage.jsp"></jsp:include>
</body>
</html>