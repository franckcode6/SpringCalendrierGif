<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Calendrier GIF: les émotions</h1>
<c:forEach items="${emotions}" var="emotion">
	<li> ${emotion.code} : ${emotion.nom}</li>
</c:forEach>
</body>
</html>