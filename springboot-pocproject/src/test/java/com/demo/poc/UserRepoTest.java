package com.demo.poc;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.demo.poc.model.User;
import com.demo.poc.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepoTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void createUserTest() {
		User user = new User();
		user.setEmail("testcase@gmail.com");
		user.setPassword("123456");
		user.setFirstName("test");
		user.setLastName("case");
		
		User saveUser = userRepository.save(user);
		User findUser = entityManager.find(User.class, saveUser.getId());
		
		assertThat(findUser.getEmail()).isEqualTo(user.getEmail());
	}
	
	@Test
	public void findUserByEmailTest() {
		//find the user email that is saved in the database
		String email = "test@gmail.com";
		
		User user = userRepository.findByEmail(email);
		
		assertThat(user).isNotNull();
	}
	
}
