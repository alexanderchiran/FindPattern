<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Boot</title>
</head>
<body>
 <h1>Haciendo Crawling a páginas web</h1>
	<hr>

	<div class="form">
		<form action="validate" method="post" onsubmit="return validate()">
			<div class="col-lg-3" th:object="${test}">
				<select class="form-control" id="testOrder" name="testOrder">
					<option value="">Select Test Order</option>
					<option th:each="test : ${tests}" th:value="${test.id}"
						th:text="${test.value}+' : '+${test.description}"></option>
				</select>
			</div>
		</form>
	</div>

</body>
</html>