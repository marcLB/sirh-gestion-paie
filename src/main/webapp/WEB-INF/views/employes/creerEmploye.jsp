<%@ include file="../header.jsp"%>


<h1>Créer Employe</h1>
<p>Préfixe Matricule : ${prefixMatricule}</p>
<form class="form-horizontal">
	<fieldset>

		<!-- Form Name -->
		<legend>Ajouter un employé</legend>

		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">Matricule</label>
			<div class="col-md-4">
				<input id="textinput" name="textinput" type="text" placeholder=""
					class="form-control input-md" required="">

			</div>
		</div>

		<!-- Select Basic -->
		<div class="form-group">
			<label class="col-md-4 control-label" for="selectEntreprise">Entreprise</label>
			<div class="col-md-4">
				<select id="selectEntreprise" name="selectEntreprise"
					class="form-control">
					<option value="1">Option one</option>
					<option value="2">Option two</option>
				</select>
			</div>
		</div>

		<!-- Select Basic -->
		<div class="form-group">
			<label class="col-md-4 control-label" for="selectProfil">Profil</label>
			<div class="col-md-4">
				<select id="selectProfil" name="selectProfil" class="form-control">
					<option value="1">Option one</option>
					<option value="2">Option two</option>
				</select>
			</div>
		</div>

		<!-- Select Basic -->
		<div class="form-group">
			<label class="col-md-4 control-label" for="selectGrade">Grade</label>
			<div class="col-md-4">
				<select id="selectGrade" name="selectGrade" class="form-control">
					<option value="1">Option one</option>
					<option value="2">Option two</option>
				</select>
			</div>
		</div>

		<!-- Button -->
		<div class="form-group">
			<label class="col-md-4 control-label" for="btnAjouter"></label>
			<div class="col-md-4">
				<button id="btnAjouter" name="btnAjouter" class="btn btn-primary">Ajouter</button>
			</div>
		</div>

	</fieldset>
</form>
