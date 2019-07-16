package it.contrader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

import it.contrader.services.UserService;

@SpringBootApplication
public class SpringWebApplication {

	static UserService userService;

	@Autowired
	public SpringWebApplication(UserService userService) {
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringWebApplication.class, args);
	}
}
