<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../header.jsp"%>

<%@ include file="../footer.jsp"%>

<div class="container">
  <h2>Liste des employés</h2>
             
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Date/heure création</th>
        <th>Matricule</th>
        <th>Grade</th>
        <th>Net Imposable</th>
        <th>Net A Payer</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
	    <c:forEach items="${listeEmpl}" var="liste">					
			<tr class="text-center">
				<td>${liste.dateCreation}</td>
				<td>${liste.matricule}</td>
				<td>${liste.grade.code}</td>
				<td>xxx</td>
				<td>xxx</td>
				<td>xxx</td>
				<td> <a href="visualiser">Visualiser</a></td>
			</tr>
		</c:forEach>
    </tbody>
  </table>
</div>
