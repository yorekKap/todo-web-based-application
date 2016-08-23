<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
<style type="text/css">
			* {
				font-family: Arial, Verdana, sans-serif;
			}
			input {
				border-bottom: 1px dotted #dcdcdc;
				border-top: none;
				border-right: none;
				border-left: none;
				padding: 5px;
				width: 280px;
				margin-bottom: 20px;}
			input:focus {
				border: 1px dotted #dcdcdc;
				outline: none;}
			input#submit {
				color: #ffffff;
				background-color: #665544;
				border: none;
				border-radius: 5px;
				width: 80px;}
			input#submit:hover {
				color: #665544;
				background-color: #efefef;}
			fieldset {
				width: 350px;
				border: 1px solid #dcdcdc;
				border-radius: 10px;
				padding: 20px;
				text-align: right;
				margin-right: auto;
				margin-left: auto;}
			legend {
				background-color: #efefef;
				border: 1px solid #dcdcdc;
				border-radius: 10px;
				padding: 10px 20px;
				text-align: left;
				text-transform: uppercase;}
	
		</style>

</head>
<body>

	<form:form action="/todor/register/" method ="post" enctype="multipart/form-data" modelAttribute="userForm"> 
		
		<fieldset>
		<legend>Please register</legend>
		<table>
			
			<tr>
			<td></td>
			<td class = "error"><form:errors path = "username"/></td>
			</tr>
			
			<tr>
				<td>Username: </td>
				<td><input type = "text" name = "username" value = ""></td>
			</tr>
		
			<tr>
				<td></td>
				<td><form:errors path = "password"/>
			</tr>
			
		
			<tr>
				<td>Password: </td>
				<td><input type = "password" name = "password" value = ""></td>
			</tr>

			<tr>
				<td></td>
				<td><form:errors path="confirmPassword" />
			</tr>
			
			
			<tr>
				<td>Confirm Password:</td>
				<td><input type="password" name="confirmPassword" value="" ></td>
			</tr>

			<tr>
				<td></td>
				<td><form:errors path="email"/>
			</tr>
			
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" value=""></td>
			</tr>

			<tr>
				<td><input name = "submit" type = "submit" value = "Register"></td>
			</tr>
		
		</table>
		
		<input name="${_csrf.parameterName}" type="hidden"
			value="${_csrf.token}" />

	</fieldset>
	
	</form:form>

</body>
</html>