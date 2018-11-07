<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Customers List"/>
<%@include file="common/header.jspf"%>

<form method="GET" action="${formAction}" id="customerForm">
	<input type="text" id="name" name="name"/>
	<label for="Sort">Sort: </label>
	<select name="sortBy" form="customerForm">
  		<option value="first_name">First Name</option>
		<option value="last_name">Last Name</option>
		<option value="email">email</option>
	</select>

<input type="submit" value="Search" />
</form>

<table class="table">
<tr>
<th>Name</th>
<th>Email</th>
<th>Active</th>
</tr>
<c:forEach items="${customers}" var="customer">
<tr>
    <td><c:out value="${customer.firstName}"/>  <c:out value="${customer.lastName}"/></td>
    <td><c:out value="${customer.email}"/></td>
    <td><c:out value="${customer.active}"/></td>
</tr>
</c:forEach>
</table>
<%@include file="common/footer.jspf"%>