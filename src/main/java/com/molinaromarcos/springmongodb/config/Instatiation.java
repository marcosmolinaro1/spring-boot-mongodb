package com.molinaromarcos.springmongodb.config;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.molinaromarcos.springmongodb.domain.Post;
import com.molinaromarcos.springmongodb.domain.User;
import com.molinaromarcos.springmongodb.repository.PostRepository;
import com.molinaromarcos.springmongodb.repository.UserRepository;

@Configuration
public class Instatiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
	
		
		userRepository.deleteAll();
		postRepository.deleteAll();		
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para São Paulo. Abraços!", maria);
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", maria);
		
		userRepository.saveAll(java.util.Arrays.asList(maria, alex, bob));
		postRepository.saveAll(java.util.Arrays.asList(post1, post2));
		
	}

}
