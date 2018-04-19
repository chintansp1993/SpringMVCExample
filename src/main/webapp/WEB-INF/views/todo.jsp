<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring-form"%>
<html>
<head>
<title>Yahoo!!</title>
<link href="webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
<h1>Todo</h1>
<h3>Hi ${name}</h3>
<br/>

	
		<spring-form:form class="form-inline" method="POST" commandName="todo">
			<spring-form:hidden path="id"/>
			
			<div class="form-group">		
					<spring-form:label path="description">Description</spring-form:label>
					<spring-form:input path="description" class="form-control" type="text" required="required"/>
					<spring-form:errors path="description" cssClass="text-warning"></spring-form:errors>
			</div>
			
			<div class="form-group">		
					<spring-form:label path="date">Date</spring-form:label>
					<spring-form:input path="date" class="form-control" type="text" required="required"/>
					
					<spring-form:errors path="date" cssClass="text-warning"></spring-form:errors>
			</div>
			
			<input class="btn btn-success" type="submit" value="Submit"><br/>
		</spring-form:form>
			

</div>
<script src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>