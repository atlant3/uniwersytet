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

<title>Registration</title>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link type="text/css" href="style/style.css" rel="stylesheet">
</head>

<body>
	<div class="login-page">
		<div class="form conteiner">
			<form:form method="POST" modelAttribute="userForm"
				class="form-signin" enctype="multipart/form-data">
				<h2 class="form-signin-heading"><spring:message code='registration.title' /></h2>

				<spring:bind path="firstName">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:input type="text" path="firstName" class="form-control"
							placeholder="First name" autofocus="true"></form:input>
						<form:errors path="firstName"></form:errors>
					</div>
				</spring:bind>

				<spring:bind path="lastName">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:input type="text" path="lastName" class="form-control"
							placeholder="Last name" autofocus="true"></form:input>
						<form:errors path="lastName"></form:errors>
					</div>
				</spring:bind>


				<spring:bind path="userName">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:input type="text" path="userName" class="form-control"
							placeholder="Email" autofocus="true"></form:input>
						<form:errors path="userName"></form:errors>
					</div>
				</spring:bind>
				<spring:bind path="age">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:input type="text" path="age" class="form-control"
							placeholder="Age" value="Age" autofocus="true"></form:input>
						<form:errors path="age"></form:errors>
					</div>
				</spring:bind>

				<spring:bind path="faculty">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<select class="form-control" name="faculty">
							<c:forEach items="${faculty}" var="faculty">
								<option value="${faculty.id}">${faculty.name}</option>
							</c:forEach>
						</select>
					</div>
				</spring:bind>

				<spring:bind path="password">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:input type="password" path="password" class="form-control"
							placeholder="Password"></form:input>
						<form:errors path="password"></form:errors>
					</div>
				</spring:bind>
				<input type="file" name="imgFile" />
			
				<button class="btn btn-lg btn-primary btn-block" type="submit"><spring:message code='registration.submit' /></button>
				<p class="message">
					<spring:message code='registration.alreadeSingUp' /><a href="/login"><spring:message code='registration.singIn' /></a>
				</p>
			</form:form>


		</div>


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


</body>
</html>