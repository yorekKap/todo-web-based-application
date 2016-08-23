package todor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import todor.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	public User findUserByUsername(String username);
	
}
