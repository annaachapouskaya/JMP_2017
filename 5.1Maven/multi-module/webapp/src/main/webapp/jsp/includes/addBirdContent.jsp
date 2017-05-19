<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div>
	<form:form method="POST" action="${pageContext.request.contextPath}/pets/birds/add.html">
		<table>
			<tr>
				<td><form:label path="name">Name: </form:label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="breed">Breed: </form:label></td>
				<td><form:input path="breed" /></td>
			</tr>
			<tr>
				<td><form:label path="singing">Is singing: </form:label></td>
				<td><form:input path="singing" /></td>
			</tr>
			<tr>
				<td><form:label path="age">Age: </form:label></td>
				<td><form:input path="age" /></td>
			</tr>
			<tr>
				<td><form:label path="history">History: </form:label></td>
				<td><form:input path="history" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
	
</div>