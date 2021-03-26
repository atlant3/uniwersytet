<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Home page</title>
<link type="text/css" href="login.css" rel="stylesheet">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<style>
.1 {
	color: red;
}
</style>
</head>

<body>

	<a href="/admin">ADMIN PANEL</a>

	<div class="container form">
		<h1>Your profile</h1>
		<img width="300px" src="data:image/jpg;base64, ${user.encodedImage}"
			alt="My image"> <br>
		<h3>Last Name: ${user.lastName}</h3>
		<h3>First Name: ${user.firstName}</h3>
		<h4>Faculty: ${user.faculty.name}</h4>
		<h4>Amount: ${user.amount}</h4>
		<c:choose>
			<c:when test="${user.status=='0'}">
				<h4>Status: Please send results</h4>
				<br />
			</c:when>
			<c:when test="${user.status=='1'}">
				<h4>Status: Please wait</h4>
				<br />
			</c:when>
			<c:when test="${user.status=='2'}">
				<h4>Status: OK</h4>
				<br />
			</c:when>
			<c:when test="${user.status=='3'}">
				<h4>Status: Sorry</h4>
				<br />
			</c:when>
		</c:choose>
		<c:set var="inputDisplay" value="${user.status}" />
		<!-- This same as your request attribute -->
		<c:choose>
			<c:when test="${inputDisplay == 0}">
				<br>
				<a class="btn btn-lg btn-primary btn-block"
					href="results?id=${user.id}">My results</a>
				<br>
				<a class="btn btn-lg btn-primary btn-block"
					href="sendResults?id=${user.id}">Send My results</a>
			</c:when>
			<c:otherwise>
				<br>
				<a style="display: none;" class="btn btn-lg btn-primary btn-block"
					href="results?id=${user.id}">My results</a>
				<br>
				<a style="display: none;" class="btn btn-lg btn-primary btn-block"
					href="sendResults?id=${user.id}">Send My results</a>
			</c:otherwise>
		</c:choose>

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
	<!-- 
	<script src="login.js"></script> -->

</body>
</html>