<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>CRM - Gerenciador de Pipeiros</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" />
</head>

<body>

	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<div class="row">
					<div class="col-sm-8">
						<h2>CRM - Gerenciador de Pipeiros</h2>
					</div>
					<div class="col-sm-4" style="text-align: right; margin-top: 24px;">
						<a class="btn btn-primary" href="driver-form" role="button">Cadastrar</a>
					</div>
				</div>
				<table class="table table-hover table-striped">
					<thead>
						<tr>
							<th>CPF</th>
							<th>Nome</th>
							<th>E-mail</th>
							<th>Placa</th>
							<th>Fone</th>
							<th>Última modificação</th>
							<th>Ações</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach var="truckDriver" items="${truckDrivers}">
							<c:url var="updateLink"
								value="/truckdriver/update-driver-form">
								<c:param name="id" value="${truckDriver.id}"></c:param>
							</c:url>
							
							<c:url var="deleteLink"
								value="/truckdriver/delete-driver">
								<c:param name="id" value="${truckDriver.id}"></c:param>
							</c:url>
							
							<tr>
								<td>${truckDriver.documentID}</td>
								<td>${truckDriver.name}</td>
								<td>${truckDriver.email}</td>
								<td>${truckDriver.licencePlate}</td>
								<td>${truckDriver.phoneNumber}</td>
								<td>${truckDriver.modified}</td>
								<td>
									<a href="${updateLink}" class="btn btn-primary btn-sm" style="line-height: 1.0;">Editar</a>
									<a href="${deleteLink}" onclick="if(!(confirm('Tem certeza que deseja remover este registro?'))) return false;"
										class="btn btn-danger btn-sm" style="line-height: 1.0;">Remover</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>