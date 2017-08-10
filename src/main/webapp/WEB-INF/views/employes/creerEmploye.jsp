<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Paie</title>
<link rel="stylesheet" href="<c:url value ='/bootstrap-3.3.7-dist/css/bootstrap.css'></c:url>">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>

	<c:import url="../menu.jsp"></c:import>

	<h1 class="text-center">Ajouter un employé</h1>

	<form class="form-horizontal" method="post">
		<fieldset>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="matricule">Matricule</label>
				<div class="col-md-4">
					<input id="matricule" name="matricule" placeholder=""
						class="form-control input-md" required type="text">
				</div>
			</div>

			<!-- Select Basic -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="entreprise">Entreprise</label>
				<div class="col-md-4">
					<select id="entreprise" name="entreprise" class="form-control">
						<c:forEach var="entreprise" items="${entreprises}">
							<option value="${entreprise.denomination}">${entreprise.denomination}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<!-- Select Basic -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="profil">Profil</label>
				<div class="col-md-4">
					<select id="profil" name="profil" class="form-control">
						<c:forEach var="profil" items="${profils}">
							<option value="${profil.code}">${profil.code}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<!-- Select Basic -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="grade">Grade</label>
				<div class="col-md-4">
					<select id="grade" name="grade" class="form-control">
						<c:forEach var="grade" items="${grades}">
							<option value="${grade.code}">${grade.code}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<!-- Button -->
			<div class="form-group text-right">
				<label class="col-md-4 control-label" for="ajouter"></label>
				<div class="col-md-4">
					<button id="ajouter" name="ajouter" class="btn btn-default">Ajouter</button>
				</div>
			</div>

		</fieldset>
	</form>
</body>
</html>