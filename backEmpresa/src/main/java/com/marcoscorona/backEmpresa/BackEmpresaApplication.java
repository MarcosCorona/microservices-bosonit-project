package com.marcoscorona.backEmpresa;

import com.marcoscorona.backEmpresa.user.application.UserService;
import com.marcoscorona.backEmpresa.user.domain.Role;
import com.marcoscorona.backEmpresa.user.domain.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class BackEmpresaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackEmpresaApplication.class, args);
	}

	/*@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ADMIN"));
			userService.saveRole(new Role(null, "EMPLOYEE"));
			userService.saveRole(new Role(null, "CLIENT"));

			userService.saveUser(new User(null, "marcos", "corona dionisio", 25, "marcos@testing.com", "608418540", new ArrayList<>(), "marcost", "1234"));
			userService.saveUser(new User(null, "andrea", "test", 25, "andrea@testing.com", "608418540", new ArrayList<>(), "andreat", "1234"));
			userService.saveUser(new User(null, "john", "test1", 25, "john@testing.com", "608418540", new ArrayList<>(), "johnt", "1234"));
			userService.saveUser(new User(null, "arthur", "test2", 25, "arthur@testing.com", "608418540", new ArrayList<>(), "arthurt", "1234"));


			userService.addRoleToUser("marcost", "ADMIN");
			userService.addRoleToUser("andreat", "EMPLOYEE");
			userService.addRoleToUser("johnt", "CLIENT");
			userService.addRoleToUser("arthurt", "ADMIN");
		};
	}*/
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
}
