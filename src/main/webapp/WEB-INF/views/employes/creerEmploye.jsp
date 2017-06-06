<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../header.jsp"%>

<form class="form-horizontal col-sm-10">
	<fieldset>

		<!-- Form Name -->
		<legend>Ajouter un employé</legend>

		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 col-sm-6 control-label" for="textinput">Matricule</label>
			<div class="col-md-4 col-sm-6">
				<input id="textinput" name="textinput" type="text" placeholder=""
					class="form-control input-md" required="">

			</div>
		</div>

		<!-- Select Basic -->
		<div class="form-group">
			<label class="col-md-4 col-sm-6 control-label" for="selectEntreprise">Entreprise</label>
			<div class="col-md-4 col-sm-6">
				<select id="selectEntreprise" name="selectEntreprise" class="form-control">
					<c:forEach items="${listeEntreprises}" var="entreprise">					
						<option>${entreprise.denomination}</option>
					</c:forEach>
				</select>
			</div>
		</div>

		<!-- Select Basic -->
		<div class="form-group">
			<label class="col-md-4 col-sm-6 control-label" for="selectProfil">Profil</label>
			<div class="col-md-4 col-sm-6">
				<select id="selectProfil" name="selectProfil" class="form-control">
					<c:forEach items="${listeProfil}" var="profil">					
						<option>${profil.code}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<!-- Select Basic -->
		<div class="form-group">
			<label class="col-md-4 col-sm-6 control-label" for="selectGrade">Grade</label>
			<div class="col-md-4 col-sm-6">
				<select id="selectGrade" name="selectGrade" class="form-control">
					<c:forEach items="${listeGrade}" var="grade">					
						<option>${grade.code}</option>
					</c:forEach>
				</select>
			</div>
		</div>

		<!-- Button -->
		<div class="form-group">
			<label class="col-md-4 col-sm-6 control-label" for="btnAjouter"></label>
			<div class="col-md-4 col-sm-6">
				<button id="btnAjouter" name="btnAjouter" class="btn btn-primary">Ajouter</button>
			</div>
		</div>

	</fieldset>
</form>
