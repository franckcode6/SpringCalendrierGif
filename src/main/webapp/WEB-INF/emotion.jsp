<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajout emotion</title>
</head>
<body>
<h1>Ajouter une nouvelle émotion</h1>
<form action="emotion" method="post">
<label>Nom</label><input type="text" name="NOM"><br>
<label>Code</label><input type="text" name="CODE"><br>
<input type="submit" value="Ajouter">
</form>
<jsp:include page="piedDePage.jsp"></jsp:include>
</body>
</html>