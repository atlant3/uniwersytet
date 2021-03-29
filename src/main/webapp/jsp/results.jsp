<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="Maksym Bilozir" content="">

<title>My results</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link type="text/css" href="style/style.css" rel="stylesheet">
</head>

<body>
	<div class="container-fluid">
		<br>
		<h1 class="text-center white-text"><spring:message code='results.title' /></h1>
		<br> <input class="form-control" id="myInput" type="text"
			placeholder="<spring:message code='results.search' />"> <br>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Id</th>
					<th><spring:message code='results.subject' /></th>
					<th><spring:message code='results.amount' /></th>
					<th><spring:message code='results.edit' /></th>
				</tr>
			</thead>
			<tbody id="myTable">
				<c:forEach var="result" items="${results}">
					<tr>
						<td>${result.id}</td>
						<td>${result.subject.name}</td>
						<td>${result.amount}</td>

						<td><a id="myForm" href="setResult?id=${result.id}"><spring:message code='results.edit' /></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<p class="text-center back">
			<a href="/home"><spring:message code='results.back' /></a>
		<p>
	</div>


	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
		integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
		integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="js/jqueryTable.js"></script>

</body>
</html>