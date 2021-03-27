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

<title>List of Students</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link type="text/css" href="style/style.css" rel="stylesheet">
</head>

<body>
	<div class="container-fluid">
		<br>
		<h1 class="text-center white-text">List of Students</h1>
		<br> <input class="form-control" id="myInput" type="text"
			placeholder="Search.."> <br>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>
					<th>Faculty</th>
					<th>Amount</th>
					<th>Delete</th>
					<th>Accept</th>
					<th>More</th>
				</tr>
			</thead>
			<tbody id="myTable">
				<c:forEach var="student" items="${students}">
					<tr>
						<td>${student.id}</td>
						<td>${student.firstName}</td>
						<td>${student.lastName}</td>
						<td>${student.age}</td>
						<td>${student.faculty.name}</td>
						<td>${student.amount}</td>

						<td><a href="deleteStudent?id=${student.id}">X</a></td>
						<td><a href="acceptStudent?id=${student.id}">V</a></td>
						<td><a href="resultsByStudent?id=${student.id}">More</a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<p class="text-center back">
			<a class="" href="/admin">BACK</a>
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
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="js/jqueryTable.js"></script>

</body>
</html>