package todor.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import todor.domain.TodoCategory;
import todor.domain.User;
import todor.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Transactional
	@Override
	public User findByUsername(String username) {
	
		User user = userRepository.findUserByUsername(username);
		return user;
		
	}
	
	@Transactional
	@Override
	public void save(User user) {
		
		if(!user.isRegistered()){
			user.setPassword(encoder.encode(user.getPassword()));
			user.setRegistered(true);
		}
		
		userRepository.save(user);	
		
		
	}
}
