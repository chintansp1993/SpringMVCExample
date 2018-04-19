<%@ include file = "commons/header.jspf" %>
<%@ include file = "commons/navbar.jspf" %>

<div class="container">
<h1>Todo</h1>
<h3>Hi!!!!, ${name}</h3>
<br/>

<table class="table">
	<caption>Todos</caption>
	<thead>
		<tr>
			<th>Description</th>
			<th>Date</th>
			<th>Status</th>
		</tr>		
	</thead>	
		<tbody>
			<jstl:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.description}</td>
					<td><fmt:formatDate pattern = "MM/dd/yyyy" value = "${todo.date}"/></td> 					
					<td>${todo.status}</td>	
					<td>
						<a href="/todo-edit?id=${todo.id}" class="btn btn-success">Edit</a>
						<a href="/todo-remove?id=${todo.id}" class="btn btn-danger">Remove</a></td>	
				</tr>
			</jstl:forEach>
		</tbody>
</table>
<div>
<a class="btn btn-success" href="/todo-add">Add</a>
</div>
</div>
<script src="webjars/jquery/2.1.4/jquery.min.js"></script>
<script src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>