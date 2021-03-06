<style type="text/css">
* {
        margin: 0;
        padding: 0;
        border: 0;
        outline: 0;
        font-size: 100%;
        vertical-align: baseline;
        background: transparent;
    }

html {
	/* 	background: #f1efcb url(http://subtlepatterns.com/patterns/tex2res4.png) 0 0 repeat; */
 	min-height: 100%; 
 	font-family: Arial, Verdana, sans-serif; 
	font-weight: 300;
	color: #000;
}

html, body {
    margin: 0;
    padding: 0;
}

a {
	color: #000000;
	text-decoration: none;
}


a#logout {
	color: #000000;
	text-decoration: none;
}

a#logout:hover{

	color: #b2a7a7;
	

}

/* 	a:hover, li:hover > a { */
/* 		color: #b2a7a7; */
/* 	} */
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
}

li {
	margin: 0;
	padding: 0;
}

ul#menu {
	/* 	border-left: 1px solid #dcdcdc; */
	/* 	border-right: 1px solid #dcdcdc; */
	float: left;
	font-size: 140%;
	min-height: 100%;
	margin-left: 1em;
}

div#menu {
	
	margin: 0;
	padding: 0;
	margin-left: 10px;
	width: 110px;
	border-left: 1px solid #dcdcdc;
	border-right: 1px solid #dcdcdc;
	height: 700px;
	position: fixed;
	width: 230px;
}

#menu li {
	position: relative;
	z-index: 1;
}

#menu li a {
	display: block;
	padding: 0.5em 1em;
	white-space: nowrap;
}

#menu li ul {
	position: relative;
	top: 0.5em;
	float: none;
}

#menu li:hover ul {
	display: block;
}

#menu li ul a {
	position: relative;
	font-size: 0.8em;
}

#menu li ul a:hover {
	color: #b2a7a7;
}

#menu li ul a:hover:before {
	content: "";
	display: block;
	width: 1em;
	height: 1em;
	/* 		background: rgba(0,0,0,0.75); */
	border-bottom: 1px solid #FFF;
	position: absolute;
	top: 0.5em;
	left: -0.75em;
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
	width: 120px;
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
}

.centered {
	position: absolute;
	margin: auto;
	top: 0;
	right: 0;
	bottom: 0;
	left: 0;
}

legend {
	background-color: #efefef;
	border: 1px solid #dcdcdc;
	border-radius: 10px;
	padding: 10px 20px;
	text-align: left;
	text-transform: uppercase;
}

textarea {
	border: 1px dotted #dcdcdc;
	font-family: Arial, Verdana, sans-serif;
	padding: 5px;
	width: 280px;
	margin-bottom: 20px;
	padding: 5px;
}

textarea:focus {
	border: 1px solid #dcdcdc;
	outline: none;
}

.popup-position {
	top: 0;
	left: 0;
	position: fixed;
	width: 100%;
	height: 120%;
	background-color: rgba(0, 0, 0, 0.7);
	display: none;
}

.popup-wrapper {
	width: 410px;
	height: 550px;
	margin: 50px auto;
	text-align: left;
}

.popup-wrapper2 {
	width: 350px;
	height: 550px;
	margin: 50px auto;
	text-align: left;
}

.popup-container {
	background-color: #FFF;
	padding: 15px;
}

#addCategory {
	display: none;
}

form:errors {
	color: red;
	align: left;
}

button {
	color: #ffffff;
	background-color: #665544;
	border: none;
	border-radius: 5px;
	width: 70px;
}

button:hover {
	color: #665544;
	background-color: #efefef;
}

button#create-todo {
	width: 400px;
	height: 40px;
	margin-top: 10px;
}

div.container {
	margin-left: 300px;


}

p.categoryName {
	font-family: "Times New Roman", Times;
	font-size: 160%;
}

input[type="checkbox"] {
	margin: 4px 0 0;
	margin-top: 1px;
	line-height: normal;
}

l.todo-list li span.todo-name {
	font-weight: 600;
	color: #8F8F8F;
}

ul.todo-list li span.todo-description {
	display: block;
	color: #A8A8A8;
}

ul.todo-list {
	margin-top: 50px;
}

ul.todo-list li a {
	display: block;
	border-bottom: 1px dotted #CFCFCF;
	padding: 20px;
	text-decoration: none;
}

ul.todo-list li a:hover {
	background-color: #f0e6bd;
}

ul.todo-list li span {
	display: block;
}

ul.todo-list span.done {
	text-decoration: line-through;
	
}

button.deleteTodo {
	margin-left: 50px;
	width: 150px;
	height: 50px;
	float: right;
	margin-right: 50px;
}

p#todo{

	font-size: 200%;
	font-family:  Arial, Verdana, sans-serif;

}
img.cross{

	display:inline-block;
	width: 10px;
	height: 10px;

}

img.cross:hover{

	border-radius: 140px;
	cursor: pointer;


}

a.category{

	display: inline-block;

}

tr.categories{

	font-size: 80%;


}

a.categories:hover{

		color: #b2a7a7;
		
}

</style>

	<script type="text/javascript">

	function confirmRemoveCategory(category, actualCategory){
		
		var answ = confirm("Are you sure you wan't to delete " + category +" category?");
		if(answ == true){
			
			if(!actualCategory){
			
				window.location = translate('/todor/userpage/categories/All'+
						'/removeCategory?categoryToDelete='+category);

				
			}
			
			else{
				window.location = translate('/todor/userpage/categories/'+actualCategory+
													'/removeCategory?categoryToDelete='+category);
			}
			}
		
	}
	
    function toggle_visibility(id) {
       var e = document.getElementById(id);
       if(e.style.display == 'block')
          e.style.display = 'none';
       else
          e.style.display = 'block';
    }
    
	function translate(categoryName){
		
		var newstring = categoryName.replace(' ', '-');
		return newstring;
		
	}
	
	function action(formName, categoryName){
		
		var oForm = document.forms[formName];
		oForm.action = translate(categoryName);
		return true;
	}
	
</script>



	