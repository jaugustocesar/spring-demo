<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<title>CRM - Gerenciador de Pipeiros</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/style.css" />
</head>

<body>

	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<div class="header row">
					<div class="col-sm-12">
						<h2>CRM - Formul�rio de Pipeiro</h2>
					</div>
				</div>
				
				<form:form action="save-truck-driver" modelAttribute="truckDriver" method="POST">
				
					<form:hidden path="id" />
					
					<div class="form-group">
						<label class="form-control-label" for="nameInput">Nome</label>
						<form:input path="name" class="form-control" id="nameInput" />
						<form:errors path="name" cssClass="error" />
					</div>
					
					<div class="form-group">
						<label class="form-control-label" for="documentIDInput">CPF</label>
						<form:input path="documentID" class="form-control" id="documentIDInput" />
						<form:errors path="documentID" cssClass="error" />
					</div>
					
					<div class="form-group">
						<label class="form-control-label" for="emailInput">E-mail</label>
						<form:input path="email" class="form-control" id="emailInput" type="email" />
						<form:errors path="email" cssClass="error" />
					</div>
					
					<div class="form-group">
						<label class="form-control-label" for="plateInput">Placa do caminh�o</label>
						<form:input path="licencePlate" class="form-control" id="plateInput" />
						<form:errors path="licencePlate" cssClass="error" />
					</div>
					
					<div class="form-group">
						<label class="form-control-label" for="phoneInput">Fone</label>
						<form:input path="phoneNumber" class="form-control" id="phoneInput" type="tel" />
						<form:errors path="phoneNumber" cssClass="error" />
					</div>
					
					<button type="submit" class="btn btn-primary">Salvar</button>
					<button class="btn btn-secondary" onclick="window.location.href='list'; return false;">Voltar</button>
					
				</form:form>
				
			</div>
		</div>
	</div>

</body>
</html>