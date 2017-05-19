<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<meta name="viewport" content="width=device-with, initial-scale=1.0" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body>
	
	<table class="table">
		<tr>
			<td colspan="2">
				<tiles:insertAttribute name="header" />
			</td>
		</tr>
		<tr>
			<td width="30%">
				<tiles:insertAttribute name="menu" />
			</td>
			<td>
				<tiles:insertAttribute name="body" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<tiles:insertAttribute name="footer" />
			</td>
		</tr>
	</table>

	<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
</body>
</html>