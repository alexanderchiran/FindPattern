<html>
<head>
<title>Welcome</title>
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<link href="css/custom.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<table class="table table-striped">
			<caption>Your todos are</caption>
			<thead>
				<tr>
					<th>Description</th>
					<th>Target Date</th>
					<th>Is it Done?</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Todo 1</td>
					<td>10/12/2017</td>
					<td>No</td>
					<td><a class="btn btn-warning" href="/iniciar">Edit Todo</a></td>
					<td><a class="btn btn-warning" href="/iniciar">Delete Todo</a></td>
				</tr>
			</tbody>
		</table>
		<div>
			<a class="btn btn-default" href="/add-todo">Add a Todo</a>

		</div>

		<script src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>

	</div>
</body>
</html>
