<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="UTF-8">
<title>List Customers</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css " />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
		
		<!-- new button for add customer -->
		<input type="button" value="Add Customer"
				onclick="window.location.href='addCustomerForm'; return false;"
				class="add-button"
		/>
		
		<!-- customers table -->

			<table>
				<thead>
					<tr>
						<th>Fist Name</th>
						<th>Last Name</th>
						<th>Email</th>
					</tr>
				</thead>
				
				<tbody>
					
					<c:forEach items="${customers}" var="customer">
						<tr>
							<td>${customer.firstName}</td> 	
							<td>${customer.lastName}</td> 	
							<td>${customer.email}</td> 	
						</tr>
					</c:forEach>
					
				</tbody>

			</table>

		</div>
	</div>
</body>
</html>