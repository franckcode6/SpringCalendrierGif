<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%-- <c:choose> --%>
<%-- 	<c:when test="${sessionScope.utilisateur.theme.id eq 1}"> --%>
<!-- 		<style type="text/css"> -->
<%-- <%@include file="style/darksalmon.css"%> --%>
<!-- </style> -->
<%-- 	</c:when> --%>
<%-- 	<c:otherwise> --%>
<!-- 		<style type="text/css"> -->
<%-- <%@include file="style/dark.css"%> --%>
<!-- </style> -->
<%-- 	</c:otherwise> --%>
<%-- </c:choose> --%>
<meta charset="ISO-8859-1">
<title>Calendrier Gif</title>
<!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"> -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.2/font/bootstrap-icons.css">
</head>
<body>
	<jsp:include page="hautDePage.jsp"></jsp:include>
	<main class="container">
		<h2>
			Utilisateur : ${sessionScope.utilisateur.prenom} - solde :
			${sessionScope.utilisateur.nbPoints} points
		</h2>
		<table>
			<thead>
				<tr>
					<th>Jour</th>
					<th colspan="5">Gif</th>
					<th colspan="3">Utilisateur</th>
					<th colspan="3">Reactions</th>
				</tr>
			</thead>
			<tbody>
				<!-- Creation d'une boucle pour chaque jour dans mon tableau jours (cf CalendrierServlet)
			On renvoie une ligne du tableau pour chaque ï¿½lï¿½ment -->
				<c:forEach items="${jours}" var="jour">
					<tr class="tableRow">
						<td>${jour}</td>
						<td colspan="5"><c:choose>
								<c:when test="${jour.gif eq null}">
									<p>${jour.nbPoints}points</p>
									<ul>
										<li><a href="calendrier/gifdistant?date=${jour.date}">Placer
												un gif distant</a></li>
										<li><a href="calendrier/gifteleverse?date=${jour.date}">Placer
												un gif téléversé</a></li>
									</ul>
								</c:when>
								<c:otherwise>
									<c:if
										test="${jour.gif.legende ne null && jour.gif.legende ne ''}">
										<h2>${jour.gif.legende}</h2>
									</c:if>
									<c:if test="${jour.gif.getClass().simpleName eq 'GifDistant'}">
										<img src="${jour.gif.url}">
									</c:if>
									<c:if
										test="${jour.gif.getClass().simpleName eq 'GifTeleverse'}">
										<img src="img/${jour.gif.id}.gif" height="200"
											alt="${jour.gif.nomFichierOriginal}"
											title="${jour.gif.nomFichierOriginal}">
									</c:if>
								</c:otherwise>
							</c:choose></td>

						<td colspan="3">${jour.gif.utilisateur.prenom}
							${jour.gif.utilisateur.nom}</td>

						<td colspan="3"><c:if test="${jour.gif.id ne null}">
								<ul>
									<c:forEach items="${jour.gif.reactions}" var="reaction">
										<li>${reaction.emotion.code}
											${reaction.utilisateur.prenom} ${reaction.utilisateur.nom}</li>
									</c:forEach>
									<li><a href="calendrier/reaction?gif_id=${jour.gif.id}">Rï¿½agir</a></li>
								</ul>
							</c:if></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
</body>
</html>