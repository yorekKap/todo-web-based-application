<%@ page language="java" contentType="text/html; charset=UTF-8"
    	pageEncoding="UTF-8" isELIgnored="false"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/static/css/style.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${user.username} page</title>
<%@ include file = "style.jsp" %>
</head>
<body>

<%@ include file = "menu.jsp" %>

<%@ include file = "popups.jsp" %>

			<div class="container">
      <p class = categoryName>
        <button id = "create-todo" onclick="toggle_visibility('addTodo')">Create new todo</button>
        <a style = "margin-left: 150px;">${category.name}</a>
      </p>
      <button class = "deleteTodo" 
      onclick= "window.location = translate('/todor/userpage/categories/${category.name}/deleteTodos');">
      			Delete done</button>
		<br/><br/>
		<p id = 'todo'>Todo<p>
		<ul class = "todo-list">      
      	<c:forEach items="${category.todos}" var="todo">
		<c:if test="${todo.done == true}">
		<c:set var="spanClass" value = "done">
		</c:set>
		</c:if>
		<c:if test="${todo.done == false}">
		<c:set var="spanClass" value = "">
		</c:set>
		</c:if>
		<li>
			<a href = "/todor/userpage/categories/${category.name}/done?choosen=${todo.name}">
				<span class = "todo-name ${spanClass}">${todo.name}</span>
				<span></span>
				<span class = "todo-description">${todo.description}</span>
			</a>
		</c:forEach>	
        </ul>
          </div>

<script type="text/javascript">
    window.onpaint = action('createTodo', '/todor/userpage/categories/${category.name}/createTodo');
</script>

</body>
</html>		