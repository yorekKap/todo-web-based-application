package todor.service;

import todor.domain.User;

public interface UserService {

	void save(User user);
	
	User findByUsername(String username);
	
	
}
