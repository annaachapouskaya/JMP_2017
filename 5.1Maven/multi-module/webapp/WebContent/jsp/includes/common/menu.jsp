<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<p>Our pets</p>
<ul>
	<li><a class="nav-link" href="${pageContext.request.contextPath}/pets/dogs.html">Dogs</a></li>
	<li><a class="nav-link" href="${pageContext.request.contextPath}/pets/cats.html">Cats</a></li>
	<li><a class="nav-link" href="${pageContext.request.contextPath}/pets/birds.html">Birds</a></li>
</ul>
<ul>	
	<sec:authorize access="hasRole('ADMIN')">
		<%--For admins --%>
		<p>Administration</p>
		<li><a class="nav-link" href="${pageContext.request.contextPath}/pets/dogs/add.html">Add a dog</a></li>
		<li><a class="nav-link" href="${pageContext.request.contextPath}/pets/cats/add.html">Add a cat</a></li>
		<li><a class="nav-link" href="${pageContext.request.contextPath}/pets/birds/add.html">Add a bird</a></li>
	</sec:authorize>
</ul>