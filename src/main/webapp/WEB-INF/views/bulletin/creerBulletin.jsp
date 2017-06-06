<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../header.jsp"%>

<form class="form-horizontal col-sm-10" method="POST" action="creer">
	<fieldset>
		<!-- Form Name -->
		<legend>Créer Bulletin de Salaire</legend>



		<!-- Select Basic -->
		<div class="form-group">
			<label class="col-md-4 col-sm-6 control-label" for="selectPériode">Période</label>
			<div class="col-md-4 col-sm-6">
				<select id="periode" name="periode" class="form-control">
					<c:forEach items="${listePeriode}" var="periode">					
						<option>De ${periode.dateDebut} à ${periode.dateFin}</option>
					</c:forEach>
				</select>
			</div>
		</div>

		<!-- Select Basic -->
		<div class="form-group">
			<label class="col-md-4 col-sm-6 control-label" for="selectMatricule">Matricule</label>
			<div class="col-md-4 col-sm-6">
				<select id="matricule" name="matricule" class="form-control">
					<c:forEach items="${listeBulletin}" var="bulletin">					
						<option>${bulletin.remunerationEmploye.matricule}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 col-sm-6 control-label" for="textinput">Prime exceptionnelle</label>
			<div class="col-md-4 col-sm-6">
				<input id="primeExceptionnelle" name="primeExceptionnelle" type="text" placeholder=""
					class="form-control input-md" required="">

			</div>
		</div>
		<!-- Select Basic -->
<!-- 		<div class="form-group"> -->
<!-- 			<label class="col-md-4 col-sm-6 control-label" for="selectGrade">Grade</label> -->
<!-- 			<div class="col-md-4 col-sm-6"> -->
<!-- 				<select id="grade" name="grade" class="form-control"> -->
<%-- 					<c:forEach items="${listeGrade}" var="grade">					 --%>
<%-- 						<option value="${grade.id}">${grade.code}</option> --%>
<%-- 					</c:forEach> --%>
<!-- 				</select> -->
<!-- 			</div> -->
<!-- 		</div> -->

		<!-- Button -->
		<div class="form-group">
			<label class="col-md-4 col-sm-6 control-label" for="btnAjouter"></label>
			<div class="col-md-4 col-sm-6">
				<button id="btnAjouter" type="submit" name="btnAjouter" class="btn btn-primary">Ajouter</button>
			</div>
		</div>

	</fieldset>
</form>
