package com.example.demo.cli;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserDAOService;



@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner{

	private static final Logger log=LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User user = new User("Jill", "Admin");
		userRepository.save(user);
		log.info("New User is created : " + user);

		Optional<User> userWithIdOne=userRepository.findById(1L);
		log.info(" User is retrieved : " + userWithIdOne);
		
		List<User> users = userRepository.findAll();
		log.info("All Users : " + users);
	}

}
