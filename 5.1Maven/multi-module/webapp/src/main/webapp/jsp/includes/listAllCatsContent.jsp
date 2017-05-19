<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<div>
	<c:forEach items="${cats}" var="cat">
		<div>
			<p><b>Name: </b>${cat.name}</p>
			<p><b>Breed: </b>${cat.breed}</p>
			<p><b>Age: </b>${cat.age}</p>
			<p><b>Character: </b>${cat.character}</p>
			<p><b>History: </b>${cat.history}</p>
			<p><b>Wool length: </b>${cat.woolLength}</p>
			<hr/>
		</div>
	</c:forEach>

</div>