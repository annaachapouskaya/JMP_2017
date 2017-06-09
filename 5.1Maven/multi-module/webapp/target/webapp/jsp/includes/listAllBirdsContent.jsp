<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<div>
	<c:forEach items="${birds}" var="bird">
		<div class="birdInfo">
			<p><b>Name: </b>${bird.name}</p>
			<p><b>Breed: </b>${bird.breed}</p>
			<p><b>Age: </b>${bird.age}</p>
			<p><b>Is singing: </b>${bird.singing}</p>
			<p><b>History: </b>${bird.history}</p>
			<hr/>
		</div>
	</c:forEach>

</div>