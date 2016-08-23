<div id = 'menu'>
<ul id="menu">
	<li>
		<a id = "logout" href = "/todor/logout" style="margin-left: -20px;">Logout</a>
		
		<table>
		
			<tr>
				<a class = "categories" href="javascript:void(0)" onclick="toggle_visibility('addCategory')" style="margin-left: -20px;">Create new category</a>
			</tr>
			
			<tr class = "categories">
				<td></td>
				<td><a class ="categories" href="javascript:document.location.href=translate('/todor/userpage/categories')">
				<c:out value="All"></c:out></a></td>
			</tr>
			
			
			<c:forEach items="${categories}" var = "cat">
				<c:if test = "${cat.name ne 'All'}">
			
			<tr class = "categories">
				<td><img class ="cross" 
					src = "http://s1.iconbird.com/ico/0612/GooglePlusInterfaceIcons/w128h1281338911337cross.png"
				 	onclick="confirmRemoveCategory('${cat.name}', '${category.name }')"/></td>
				<td><a class ="categories" href="javascript:document.location.href=translate('/todor/userpage/categories/${cat.name}')">
				<c:out value="${cat.name}"></c:out>
				</c:if>
				</a></td>
			</tr>
			
			</c:forEach>
			
		</table>
	<li>
		
</ul>
</div>
