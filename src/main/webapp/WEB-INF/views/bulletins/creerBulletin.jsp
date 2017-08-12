<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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

	<h1 class="text-center">Créer un bulletin de salaire</h1>

	<form class="form-horizontal" method="post">
		<fieldset>

			<!-- Select Basic -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="periode">Période</label>
				<div class="col-md-4">
					<select id="periode" name="periode" class="form-control">
						<c:forEach var="periode" items="${periodes}">
							<option value="${periode.dateDebut} - ${periode.dateFin}">
								${periode.dateDebut} - ${periode.dateFin}
							</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<!-- Select Basic -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="matricule">Matricule</label>
				<div class="col-md-4">
					<select id="matricule" name="matricule" class="form-control">
						<c:forEach var="matricule" items="${matricules}">
							<option value="${matricule}">${matricule}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="prime">Prime exceptionnelle</label>
				<div class="col-md-4">
					<input id="prime" name="prime" placeholder=""
						class="form-control input-md" required type="text">
				</div>
			</div>
			
			<!-- Button -->
			<div class="form-group text-right">
				<label class="col-md-4 control-label" for="creer"></label>
				<div class="col-md-4">
					<button id="creer" name="creer" class="btn btn-default">Créer</button>
					<sec:csrfInput/>
				</div>
			</div>

		</fieldset>
	</form>
</body>
</html>