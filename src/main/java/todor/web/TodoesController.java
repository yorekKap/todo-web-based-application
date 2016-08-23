package todor.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.UsesSunHttpServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import todor.domain.Todo;
import todor.domain.TodoCategory;
import todor.domain.User;
import todor.repositories.UserRepository;
import todor.security.SecurityService;
import todor.service.UserService;

@Controller
@RequestMapping("/userpage")
public class TodoesController {

	@Autowired
	UserService userService;
	
	@Autowired
	SecurityService securityService;
	
    @RequestMapping
	public String onUserPage(Model model){
		
		String userName = securityService.findLoggedInUserName();
		
		System.out.println(userName);
		User user =  userService.findByUsername(userName);
		
		model.addAttribute("user",user);
		model.addAttribute("categories", user.getCategories());
		
		return "userpage";
	
    }
			
		@RequestMapping(path =  "/createCategory")
		public String onCreateCategory(Model model, @RequestParam String categoryName, @RequestParam String categoryDescription){
			
			if(categoryName == null || categoryName.isEmpty())
				return "redirect:/userpage";

			String userName = securityService.findLoggedInUserName();
			User user = userService.findByUsername(userName);
			
			TodoCategory todoCategory = new TodoCategory();
			todoCategory.setName( categoryName);
			todoCategory.setDescription(categoryDescription);
		    
			user.addCategory(todoCategory);
			

			model.addAttribute("user",user);
			model.addAttribute("categories", user.getCategories());
			model.addAttribute("category", todoCategory);
			
			userService.save(user);
				
			return "redirect:/userpage/categories/"+categoryName;
		
	}
	
	@RequestMapping(path = "/categories/{categoryName}")
	public String onCategoryName(Model model, @PathVariable String categoryName){
	
		String userName = securityService.findLoggedInUserName();
		User user = userService.findByUsername(userName);
		categoryName = categoryName.replaceAll("-" , " ");
		TodoCategory category = user.getCategory(categoryName);
		
		model.addAttribute("user",user);
		model.addAttribute("categories", user.getCategories());
		model.addAttribute("category", category);
		
		return "userpage";
	
	}
	
	@RequestMapping(path = "/categories/{categoryName}/createTodo")
	public String onCreateTodo(Model model, @RequestParam String name, @RequestParam String description,
						@RequestParam int priority, @RequestParam String state, @PathVariable String categoryName){
	
		if(name == null || name.isEmpty()){
		
			String toRedirect = "/userpage/categories/"+categoryName;
			return "redirect:"+toRedirect;
		
		}
		
		
		String userName = securityService.findLoggedInUserName();
		User user = userService.findByUsername(userName);
		categoryName = categoryName.replaceAll("-" , " ");
		TodoCategory category = user.getCategory(categoryName);
	
		Todo todo = new Todo();
		todo.setName(name);
		todo.setDescription(description);
		todo.setPriority(priority);
		todo.setState(state);
		
		category.addTodo(todo);
		
		userService.save(user);
		
		categoryName = categoryName.replaceAll(" " , "-");
		
		if(categoryName.equals("All")){
			return "redirect:/userpage/categories";
		}
		else{
			return "redirect:/userpage/categories/"+categoryName;
			
		}
	}
	
	@RequestMapping(path = "/categories/{categoryName}/done")
	public String onDone(@RequestParam String choosen, @PathVariable String categoryName){
		
		String userName = securityService.findLoggedInUserName();
		User user = userService.findByUsername(userName);
		categoryName = categoryName.replaceAll("-" , " ");
		TodoCategory category = user.getCategory(categoryName);
	
		
		Todo choosenTodo = category.getTodo(choosen);
		choosenTodo.toggleDone();
		
		userService.save(user);
		

		categoryName = categoryName.replaceAll(" " , "-");
		String toRedirect = "/userpage/categories/"+categoryName;
		
		return "redirect:"+toRedirect;
	
	}
	
	@RequestMapping(path = "/categories/{categoryName}/deleteTodos")
	public String onDeleteTodos(@PathVariable String categoryName){
		
		String userName = securityService.findLoggedInUserName();
		User user = userService.findByUsername(userName);
		categoryName = categoryName.replaceAll("-" , " ");
    	TodoCategory category = user.getCategory(categoryName);
	
		category.deleteDone();
		
		userService.save(user);
		

		categoryName = categoryName.replaceAll(" " , "-");
		String toRedirect = "/userpage/categories/"+categoryName;
		
		return "redirect:"+toRedirect;
	
	}
	
	@RequestMapping(path = "/categories/{categoryName}/removeCategory")
	public String onRemoveCategory(@PathVariable String categoryName, @RequestParam String categoryToDelete){
		
		String userName = securityService.findLoggedInUserName();
		User user = userService.findByUsername(userName);
		categoryName = categoryName.replaceAll("-" , " ");
		categoryToDelete = categoryToDelete.replaceAll("-", " ");
		user.removeCategory(categoryToDelete);
	
		userService.save(user);
		
		if(categoryName.equals(categoryToDelete) || categoryName.equals("All")){
			
			return "redirect:/userpage/categories";
			
		}
		
		
		categoryName = categoryName.replaceAll(" " , "-");
		String toRedirect = "/userpage/categories/"+categoryName;
		
		return "redirect:"+toRedirect;
	
		
	}
	
	@RequestMapping(path = "/categories")
	public String onCategories(Model model){
		
		String userName = securityService.findLoggedInUserName();
		User user = userService.findByUsername(userName);
		
		if(!user.isCategoryExist("All")){
			
			TodoCategory newTodoCategory = new TodoCategory();
			newTodoCategory.setName("All");
			newTodoCategory.setDescription("All uncategorised stuff here");
			user.addCategory(newTodoCategory);
			userService.save(user);
		
		}
		
		model.addAttribute("user", user);
		model.addAttribute("categories", user.getCategories());
		
		return "all";
		
	}


	@RequestMapping(path = "/categories/{categoryName}/all/done")
	public String onAllDone(@RequestParam String choosen, @PathVariable String categoryName){
		
		String userName = securityService.findLoggedInUserName();
		User user = userService.findByUsername(userName);
		categoryName = categoryName.replaceAll("-" , " ");
		TodoCategory category = user.getCategory(categoryName);
	
		
		Todo choosenTodo = category.getTodo(choosen);
		choosenTodo.toggleDone();
		
		userService.save(user);
		
		String toRedirect = "/userpage/categories/";
		
		return "redirect:"+toRedirect;
	
	}
	
	@RequestMapping(path = "/categories/all/deleteTodos")
	public String onAllDeleteTodos(){
		
		String userName = securityService.findLoggedInUserName();
		User user = userService.findByUsername(userName);
		
		for(TodoCategory category : user.getCategories()){
			
		    category.deleteDone();
			
		}
	
		userService.save(user);
		
		String toRedirect = "/userpage/categories";
		
		return "redirect:"+toRedirect;
	
	}
	
	

}
