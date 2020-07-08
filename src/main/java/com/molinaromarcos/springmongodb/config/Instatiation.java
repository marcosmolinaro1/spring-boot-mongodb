package com.molinaromarcos.springmongodb.config;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.molinaromarcos.springmongodb.domain.User;
import com.molinaromarcos.springmongodb.repository.UserRepository;

@Configuration
public class Instatiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(java.util.Arrays.asList(maria, alex, bob));
		
	}

}
