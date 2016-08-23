package todor.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.UsesSunHttpServer;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService{

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserDetailsServiceImpl userDatailsService;
	
	@Override
	public String findLoggedInUserName() {
	
		return SecurityContextHolder.getContext().getAuthentication().getName();
		
	}
	
	
	@Override
	public void autologin(String username, String password) {
		
		UserDetails userDetails = userDatailsService.loadUserByUsername(username);
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
				userDetails, password, userDetails.getAuthorities());
		
		authenticationManager.authenticate(token);
		
		if(token.isAuthenticated()){
			
			SecurityContextHolder.getContext().setAuthentication(token);
			
		}
	}
}
