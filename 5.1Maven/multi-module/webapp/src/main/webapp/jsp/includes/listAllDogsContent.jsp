<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<div>
	<c:forEach items="${dogs}" var="dog">
		<div class="dogInfo">
			<p><b>Name: </b>${dog.name}</p>
			<p><b>Breed: </b>${dog.breed}</p>
			<p><b>Age: </b>${dog.age}</p>
			<p><b>Character: </b>${dog.character}</p>
			<p><b>History: </b>${dog.history}</p>
			<hr/>
		</div>
	</c:forEach>

</div>