<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="UTF-8">
<title>List Customers</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css " />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style" />
	<script >
	
			function remove(id, element) {
				$.ajax({
				    url: "/web-customer-tracker/customer/deleteCustomer",
				    method: "POST",
				    data: {customerId: id},				
				    datatype: "json",
				    success: deleted(element)
				});
			}
				function deleted(element) {
					$(element).closest("tr").hide();
					alert("Cliente removido do sistema ");
				}
				
	</script>
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
						<th>Action</th>
					</tr>
				</thead>
				
				<tbody>
					
					<c:forEach items="${customers}" var="customer">
						
						<!-- Construct an update link with customer id -->
						<c:url var="updateCustomer" value="/customer/updateCustomerForm" >
							<c:param name="customerId" value="${customer.id}" />
						</c:url>	
						
						<tr>
							<td>${customer.firstName}</td> 	
							<td>${customer.lastName}</td> 	
							<td>${customer.email}</td> 	
							<td><a href="${updateCustomer }">Update</a>
								|<a href="#"
									onclick="if (confirm('Are you sure you want to delete this customer?')) remove(${customer.id}, this);">Delete</a>
							</td> 	
						</tr>
					</c:forEach>
					
				</tbody>

			</table>

		</div>
	</div>
</body>
</html>