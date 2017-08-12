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

	<h1 class="text-center">Liste des bulletins</h1>
	
	<div class="text-right">
		<a href="/paie/mvc/bulletins/creer" class="btn btn-default">Créer un nouveau bulletin</a>
	</div>
	
	<table class="table table-bordered table-striped">
		<thead>
			<tr>
				<th>Date/heure création</th>
				<th>Période</th>
				<th>Matricule</th>
				<th>Salaire brut</th>
				<th>Net imposable</th>
				<th>Net à payer</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="bulletin" items="${bulletins}">
				<tr>
					<td>
						${bulletin.dateHeureCreation.dayOfMonth}/${bulletin.dateHeureCreation.monthValue}/${bulletin.dateHeureCreation.year}
						${bulletin.dateHeureCreation.hour}:${bulletin.dateHeureCreation.minute}:${bulletin.dateHeureCreation.second}
					</td>
					
					<td>${bulletin.periode.dateDebut} - ${bulletin.periode.dateFin}</td>
					<td>${bulletin.remunerationEmploye.matricule}</td>
					<td>A faire</td>
					<td>A faire</td>
					<td>A faire</td>
					<td>Visualiser - a faire</td>
				</tr>
			</c:forEach>
		</tbody>		
	</table>

</body>
</html>