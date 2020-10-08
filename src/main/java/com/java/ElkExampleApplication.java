package com.java;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.java.entity.User;

import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@RestController
@Log4j2
public class ElkExampleApplication {
	


	   
	public static void main(String[] args) {
		log.info("this is a info message");
	      log.warn("this is a warn message");
	      log.error("this is a error message");
		SpringApplication.run(ElkExampleApplication.class, args);
	}
	
	@GetMapping("/getUser/{id}")

	public User getUserById(@PathVariable  int id) {
		
		List<User>  users  = getUser();
		
		 User user =  users.stream().filter(u->u.getId()==id).findAny().orElse(null);
		 
		 if(user != null) {
			 log.info("user found {}"+user);
			 return user ;
		 } else {
			 
			 try {
				 
				 throw new Exception();
			 }catch(Exception e) {e.printStackTrace();
			 log.info("user  not found {}"+id);
			 
			 }
			 return  new User();
		 }
		 
		
	}

		
	
	
	
	public List<User> getUser() {
		
		return  Stream.of(new User(1,"ram"),
				new User(2,"sita"),
				new User(3,"hanuman"),
				new User(4,"laxman")).collect(Collectors.toList());
	}

}
