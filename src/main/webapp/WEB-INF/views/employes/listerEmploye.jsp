<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../header.jsp"%>

<%@ include file="../footer.jsp"%>

<div class="container">
  <h2>Liste des employ�s</h2>
             
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Date/heure cr�ation</th>
        <th>Matricule</th>
        <th>Grade</th>
        <th>Net Imposable</th>
        <th>Net A Payer</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
	    <c:forEach items="${listeRemEmpl}" var="liste">					
			<tr>
				<td>${liste.matricule}</td>
				<td>${liste.matricule}</td>
				<td>${liste.matricule}</td>
				<td>${liste.matricule}</td>
				<td>${liste.matricule}</td>
				<td> <a href="visualiser">Visualiser</a></td>
			</tr>
		</c:forEach>
    </tbody>
  </table>
</div>
