<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Paie</title>
<link rel="stylesheet" href="<c:url value ='/css/bootstrap-3.3.7-dist/css/bootstrap.css'></c:url>">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>

	<c:import url="../menu.jsp"></c:import>

	<h1 class="text-center">Bulletin de salaire</h1>
	
	<div class="text-right">
		<h4>Période</h4>
		<p>${bulletin.periode}</p>
	</div>
	
	<div class="text-left">
		<h4>Entreprise</h4>
<%-- 		<p>${entreprise.periode}</p> --%>
<%-- 		<p>${entreprise.periode}</p> --%>
	</div>
	
	<div class="text-right">
		<h4>Matricule</h4>
		<p>${bulletin.remunerationEmploye.matricule}</p>
	</div>
	
	<h3>Salaire</h3>
	<table class="table table-bordered table-striped">
		<thead>
			<tr>
				<th>Rubriques</th>
				<th>Base</th>
				<th>Taux salarial</th>
				<th>Montant salarial</th>
				<th>Taux patronal</th>
				<th>Cotisations patronales</th>
			</tr>
		</thead>
		<tbody>
<%-- 			<c:forEach var="bulletin" items="${bulletins}" varStatus="status"> --%>
				<tr>
<%-- 					<td>${bulletin.periode.dateDebut} - ${bulletin.periode.dateFin}</td> --%>
<%-- 					<td>${bulletin.remunerationEmploye.matricule}</td> --%>
<%-- 					<td>${resultats[status.index].salaireBrut}</td> --%>
<%-- 					<td>${resultats[status.index].netImposable}</td> --%>
<%-- 					<td>${resultats[status.index].netAPayer}</td> --%>
<%-- 					<td><a href="/${bulletin.id}">Visualiser</a></td> --%>
				</tr>
<%-- 			</c:forEach> --%>
		</tbody>		
	</table>

</body>
</html>