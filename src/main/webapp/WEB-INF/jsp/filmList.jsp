<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="Film List"/>

<%@include file="common/header.jspf"%>
<form method="GET" action="${formAction}" id="filmForm">
	<label for="MinimumLength">Minimum Length: </label>
	<input type="text" id="MinimumLength" name="MinimumLength"/>
	<label for="MaximumLength">Maximum Length: </label>
	<input type="text" id="MaximumLength" name="MaximumLength"/>

	<label>Genre:</label>
	
	<select name="MovieCategory" form="filmForm">
  		<option value="Action">Action</option>
		<option value="Animation">Animation</option>
		<option value="Children">Children</option>
		<option value="Classics">Classics</option>
		<option value="Comedy">Comedy</option>
		<option value="Documentary">Documentary</option>
		<option value="Drama">Drama</option>
		<option value="Family">Family</option>
		<option value="Foreign">Foreign</option>
		<option value="Games">Games</option>
		<option value="Horror">Horror</option>
		<option value="Music">Music</option>
		<option value="New">New</option>
		<option value="Sci-Fi">Sci-Fi</option>
		<option value="Sports">Sports</option>
		<option value="Travel">Travel</option>
	</select>
	
	
	<input type="submit" value="Search" />
</form>
<table class="table">
<tr>
<th>Title</th>
<th>Description</th>
<th>Release Year</th>
<th>Length</th>
<th>Rating </th>
</tr>
<c:forEach items="${films}" var="film">
<tr>
    <!-- What do we print here for each actor? -->
    <td><c:out value="${film.title}"/></td>
    <td><c:out value="${film.description}"/></td>
    <td><c:out value="${film.releaseYear}"/></td>
    <td><c:out value="${film.length}"/></td>
    <td><c:out value="${film.rating}"/></td>
</tr>
</c:forEach>
</table>
<%@include file="common/footer.jspf"%>