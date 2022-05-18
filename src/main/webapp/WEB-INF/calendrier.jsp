<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
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
<link rel="stylesheet"
    href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.2/font/bootstrap-icons.css"/>
<meta charset="ISO-8859-1">
<title>Calendrier Gif</title>
<body>
	<header>
		<h1>Calendrier Gif</h1>
		<!-- Affichage des informations utilisateur -->
		<h2>
			Utilisateur·rice : ${sessionScope.utilisateur.prenom} - solde :
			${sessionScope.utilisateur.nbPoints} points <a href="deconnexion">Déconnexion</a>
		</h2>
	</header>
	<main>
		<table>
			<thead>
				<tr>
					<th><a href="calendrier?sort=date,asc"> Jour </a></th>
					<th colspan="5"><a href="calendrier?sort=nbPoints,desc">
							Gif </a> <a href="calendrier?sort=nbPoints,asc"> <i
							class="bi bi-arrow-down-short"></i>
					</a></th>
					<th colspan="3">Utilisateur·rice</th>
					<th colspan="3">Reactions</th>
				</tr>
			</thead>
			<tbody>
				<!-- Creation d'une boucle pour chaque jour dans mon tableau jours (cf CalendrierServlet)
			On renvoie une ligne du tableau pour chaque ï¿½lï¿½ment -->
				<c:forEach items="${pageDeJours.content}" var="jour">
					<tr class="tableRow">
						<td>${jour}</td>
						<td colspan="5"><c:choose>
								<c:when test="${jour.gif eq null}">
									<p>${jour.nbPoints}points</p>
									<ul>
										<li><a href="gifdistant?date=${jour.date}">Placer
												un gif distant</a></li>
										<li><a href="gifteleverse?date=${jour.date}">Placer
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
										<img src="images/${jour.gif.nomFichierOriginal}" height="200"
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
									<li><a href="reaction?gif_id=${jour.gif.id}">Réaction</a></li>
								</ul>
							</c:if></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h2 id="pagination">
			<c:if test="${!pageDeJours.first}">
				<a href="calendrier?page=0&sort=${sort}">&#x23EE;</a>
				<a href="calendrier?page=${pageDeJours.number-1}&sort=${sort}">&#x23EA;</a>
			</c:if>
			Page ${pageDeJours.getNumber()+1}
			<c:if test="${!pageDeJours.last}">
				<a href="calendrier?page=${pageDeJours.number+1}&sort=${sort}">&#x23E9;</a>
				<a href="calendrier?page=${pageDeJours.totalPages - 1}&sort=${sort}">&#x23ED;</a>
			</c:if>
		</h2>
	</main>
</body>
</html>