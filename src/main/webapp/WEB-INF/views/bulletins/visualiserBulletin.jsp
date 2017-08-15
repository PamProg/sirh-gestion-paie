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
		<p>${bulletin.periode.dateDebut} - ${bulletin.periode.dateFin}</p>
	</div>
	
	<div class="text-left">
		<h4>Entreprise</h4>
		<p>${bulletin.remunerationEmploye.entreprise.denomination}</p>
		<p>SIRET : ${bulletin.remunerationEmploye.entreprise.siret}</p>
	</div>
	
	<div class="text-right">
		<p>Matricule : </p>
	</div>
	
	<h4>Salaire</h4>
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
					<td>A faire</td>
					<td>A faire</td>
					<td>A faire</td>
					<td>A faire</td>
					<td>A faire</td>
					<td>A faire</td>
				</tr>
<%-- 			</c:forEach> --%>
		</tbody>		
	</table>
	
	<h4>Cotisations</h4>
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
					<td>A faire</td>
					<td>A faire</td>
					<td>A faire</td>
					<td>A faire</td>
					<td>A faire</td>
					<td>A faire</td>
				</tr>
<%-- 			</c:forEach> --%>
		</tbody>		
	</table>
	
	<h4>NET Imposables : </h4>
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
					<td>A faire</td>
					<td>A faire</td>
					<td>A faire</td>
					<td>A faire</td>
					<td>A faire</td>
					<td>A faire</td>
				</tr>
<%-- 			</c:forEach> --%>
		</tbody>		
	</table>

</body>
</html>