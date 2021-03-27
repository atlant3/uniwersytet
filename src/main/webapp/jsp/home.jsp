<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="" content="">
<meta name="Maksym Bilozir" content="">

<title>Home page</title>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link type="text/css" href="style/style.css" rel="stylesheet">
</head>

<body>
	<security:authorize access="hasRole('ROLE_ADMIN')">
		<div class="container d-flex h-100">

			<div class="helloAdmin form">
				<h2>Hello, ${user.userName}</h2>
				<a class="btn btn-lg btn-primary btn-block" href="/admin">ADMIN
					PANEL</a>
			</div>
		</div>
	</security:authorize>
	<security:authorize access="hasRole('ROLE_USER')">
		<div class="container profile">
			<h1>Your profile</h1>
			<img width="300px" src="data:image/jpg;base64, ${user.encodedImage}"
				alt="My image"> <br>
			<h3>Last Name: ${user.lastName}</h3>
			<h3>First Name: ${user.firstName}</h3>
			<h4>Faculty: ${user.faculty.name}</h4>
			<h4>Result: ${user.amount}</h4>
			<c:choose>
				<c:when test="${user.status=='0'}">
					<h4>
						Status: <span>Please send results</span>
					</h4>
					<br />
				</c:when>
				<c:when test="${user.status=='1'}">
					<h4>
						Status: <span>Please wait</span>
					</h4>
					<br />
				</c:when>
				<c:when test="${user.status=='2'}">
					<h4>
						Status: <span>OK</span>
					</h4>
					<br />
				</c:when>
				<c:when test="${user.status=='3'}">
					<h4>
						Status: <span>Sorry</span>
					</h4>
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
			<br> <a onclick="document.forms['logoutForm'].submit()"
				class="btn btn-lg btn-primary btn-block"><span
				class="white-text">Logout</span></a>


			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<form id="logoutForm" method="POST" action="${contextPath}/logout">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form>
			</c:if>
		</div>
	</security:authorize>

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

</body>
</html>