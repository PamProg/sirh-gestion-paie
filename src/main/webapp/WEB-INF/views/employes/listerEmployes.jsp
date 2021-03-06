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

	<h1 class="text-center">Liste des employés</h1>
	
	<div class="text-right">
		<a href="/paie/mvc/employes/creer" class="btn btn-default">Ajouter un employé</a>
	</div>
	
	<table class="table table-bordered table-striped">
		<thead>
			<tr>
				<th>Date/heure création</th>
				<th>Matricule</th>
				<th>Grade</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="employe" items="${employes}">
				<tr>
					<td>
						${employe.dateHeureCreation.dayOfMonth}/${employe.dateHeureCreation.monthValue}/${employe.dateHeureCreation.year}
						${employe.dateHeureCreation.hour}:${employe.dateHeureCreation.minute}:${employe.dateHeureCreation.second}
					</td>
					
					<td>${employe.matricule}</td>
					<td>${employe.grade.code}</td>
				</tr>
			</c:forEach>
		</tbody>		
	</table>

</body>
</html>