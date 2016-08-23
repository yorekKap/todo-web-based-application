package todor.security;

public interface SecurityService {

	String findLoggedInUserName();
	
	void autologin(String name, String password);
}
