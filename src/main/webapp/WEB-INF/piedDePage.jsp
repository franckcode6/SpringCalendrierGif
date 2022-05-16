<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="dateFin" class="java.util.Date"/>
<c:set var="msFin" value="${dateFin.getTime()}" scope="page" />
<footer class="fixed-bottom text-white text-center bg-secondary bg-gradient">
<p class="container py-1 my-0">Page générée en ${msFin - msDepart} ms</p>
</footer>