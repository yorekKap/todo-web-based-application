<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <head>
    <title>Login</title>
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
	margin-bottom: 20px;
}

input:focus {
	border: 1px dotted #dcdcdc;
	outline: none;
}

input#submit {
	color: #ffffff;
	background-color: #665544;
	border: none;
	border-radius: 5px;
	width: 80px;
}

button {
	color: #665544;
	background-color: #efefef;
	border-radius: 5px;
	width: 70px;
 	border-bottom: 1px dotted #dcdcdc;
 	border-left: none;
 	border-right: none;
 	border-top: none;
 	width: 280px;
 	height: 28px;
 	
}

button:hover {
	color: black;
	background-color: white;
}

input#submit:hover {
	color: #665544;
	background-color: #efefef;
}

fieldset {
	width: 350px;
	border: 1px solid #dcdcdc;
	border-radius: 10px;
	padding: 20px;
	text-align: right;
	margin-left: auto;
	margin-right: auto;
}

legend {
	background-color: #efefef;
	border: 1px solid #dcdcdc;
	border-radius: 10px;
	padding: 10px 20px;
	text-align: left;
	text-transform: uppercase;
}

div.alert {
	color: red;
	text-align: left;
}
</style>
  </head>
  <body>
    <div>
        <form name="f" action="/todor/login" method="post">               
            <fieldset>
                <legend>Please Login</legend>
                <c:if test="${param.error ne null}">
                <div class="alert">    	
                    Invalid username or password.
                </div>
                </c:if>
                <c:if test="${param.logout ne null}">
                <div class="alert alert-success"> 
                    You have been logged out.
                </div>
                </c:if>
                <label for="username">Username</label>
                <input type="text" id="username" name="username"/>        
                <label for="password">Password</label>
                <input type="password" id="password" name="password"/>    
                <div class="form-actions">
                    <input type="submit" name ="submit" value = "Login"/>
                </div>
                <button type = "button" onclick="notSubmit('/todor/register')">Register</button>
     
            </fieldset>
            
            
            <input name="${_csrf.parameterName}" type="hidden"
			value="${_csrf.token}" />
            
            
        </form>
        
         	  
        
    </div>
    
    <script type="text/javascript">
    
    	function notSubmit(url){
    		
    		window.location="/todor/register";
    		return false;
    		
    	}
    
    
    </script>
    
  </body>
</html>