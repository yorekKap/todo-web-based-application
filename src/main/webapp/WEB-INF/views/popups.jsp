	<div id='addCategory' class = 'popup-position'>
		<div class = 'popup-wrapper2'>
			<div class = 'popup-container'>	
				<form:form action = "/todor/userpage/createCategory" method = "GET">

					<tr>
						<td>Category name:</td>
						<td><input type="text" name="categoryName" value=""></td>
					</tr>
					<tr>
						<td>Category description:</td>
						<td><textarea name="categoryDescription" cols="40" rows="4"></textarea></td>
					</tr>

					<tr>
						<td><input id ="submit" name="submit" type="submit" value="Create category" 
						 onclick="toggle_visibility('addCategory')"></td>
						 
					</tr>


				</form:form>
			<button onclick="toggle_visibility('addCategory')" >Cancel</button>
			</div>
</div>
</div>
			<div id='addTodo' class='popup-position'>
				<div class='popup-wrapper'>
					<div class='popup-container'>
					<form:form name = "createTodo" method="GET">
						
								Todo name:
								<input type="text" name="name" value="">
							Todo state:
							<br />
					<input type="radio" name="state" value="Today" checked>Today
							<input type="radio" name="state" value="Next Week">Next Week
							<input type="radio" name="state" value="Next Month">Next Month
							
								Todo prority:
								 <select name="priority">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>
									<option value="9">9</option>
									<option value="10" selected>10</option>
								</select>	
								<br/><br/>						
								Todo description:
								<textarea name="description" cols="40" rows="4"></textarea>
		
								<input id = "submit" name="submit" type="submit"
									value="Create todo" onclick="toggle_visibility('addTodo')" />
								
						</form:form>
					
					<button onclick="toggle_visibility('addTodo')">Cancel</button>
					
					
					</div>

				</div>

			</div>

