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
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="Maksym Bilozir" content="">

<title>Log in with your account</title>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link type="text/css" href="style/style.css" rel="stylesheet">

</head>

<body>
	<div class="login-page">
		<div class="form conteiner">
			<h1>
				<spring:message code="login.title" />
			</h1>
			<div>
				<fieldset>
					<label><spring:message code="login.choose_language" /></label> <select
						id="locales">
						<option value="en"><spring:message code='login.english' /></option>
						<option value="ua"><spring:message code='login.ukrainian' /></option>

					</select>
				</fieldset>
			</div>
			<br>
			<form accept-charset=utf-8 class="login-form" method="POST"
				action="${contextPath}/index">
				<h2 class="form-heading"></h2>

				<div class="form-group ${error != null ? 'has-error' : ''}">
					<span>${message}</span> <input name="userName"
						placeholder="<spring:message code='login.email'/>" type="text"
						class="fadeIn second" autofocus="true" /> <input
						placeholder="<spring:message code='login.password'/>"
						name="password" type="password" class="fadeIn third " /> <span>${error}</span>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />

					<button class="btn btn-lg btn-primary btn-block" type="submit">
						<spring:message code='login.signin' />
					</button>
				</div>

				<p class="message">
					<a href="/registration"><spring:message
							code='login.create_account' /></a>
				</p>

			</form>

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
	<script type="text/javascript">
		$(document).ready(function() {
			var selItem = localStorage.getItem("locales");
			$('#locales').val(selItem ? selItem : 'en');
			$("#locales").change(function() {
				var selectedOption = $('#locales').val();
				if (selectedOption) {
					window.location.replace('?lang=' + selectedOption);
					localStorage.setItem("locales", selectedOption);
				}
			});
		});
	</script>
</body>
</html>