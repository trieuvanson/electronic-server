package com.app.electronicserver;

import com.app.electronicserver.model.Brand;
import com.app.electronicserver.model.Role;
import com.app.electronicserver.model.User;
import com.app.electronicserver.service.BrandService;
import com.app.electronicserver.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class ElectronicServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElectronicServerApplication.class, args);
	}
	@Bean
	PasswordEncoder passwordEncoder()	{
		return new BCryptPasswordEncoder();
	}
	@Bean
	CommandLineRunner run(UserService userService, BrandService brandService) {
		return args -> {

//			userService.saveRole(new Role("USER_ROLE", "USER_ROLE", new Date(), new Date()));
//			userService.saveRole(new Role("ADMIN_ROLE", "ADMIN_ROLE", new Date(), new Date()));

//			User user1 = new User();
//			user1.setUsername("TVS");
//			user1.setPassword("1234");
//			user1.setRoles(new ArrayList<>());
//			User user2 = new User();
//			user2.setUsername("TVS1");
//			user2.setPassword("1234");
//			userService.saveUser(user1);
//			userService.saveUser(user2);

//			userService.addRoleToUser("TVS", "USER_ROLE");
//			userService.addRoleToUser("TVS", "ADMIN_ROLE");
//			userService.addRoleToUser("TVS1", "USER_ROLE");
//			userService.addRoleToUser("TVS1", "ADMIN_ROLE");
//			userService.addRoleToUser("TVS2", "USER_ROLE");
//			userService.addRoleToUser("TVS2", "ADMIN_ROLE");
		};
	}
}
