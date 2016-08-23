package todor.web;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import todor.domain.User;
import todor.exceptions.BadPhotoException;
import todor.security.SecurityService;
import todor.security.UserValidator;
import todor.service.FileResolverService;
import todor.service.UserService;

@Controller
public class UserController {

	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private Validator userValidator;
	
	@Autowired
	private FileResolverService fileResolverService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String onRegister(){
		
		return "register";
		
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String onRegister(Model model, @ModelAttribute(name = "userForm") 
							User user, BindingResult bindingResult){
			
			userValidator.validate(user, bindingResult);
			if(bindingResult.hasErrors()){
	
				return "register";
				
			}
			
		user.setRegistered(false);
		userService.save(user);
		
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String onLogin(){
		
		return "login";
	}
	
	
}
