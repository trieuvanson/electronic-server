package com.app.electronicserver;

import com.app.electronicserver.model.Order;
import com.app.electronicserver.repo.OrderDetailRepo;
import com.app.electronicserver.repo.OrderRepo;
import com.app.electronicserver.repo.ProductRepo;
import com.app.electronicserver.service.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class ElectronicServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElectronicServerApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //BrandService brandService
//	@Bean
//	CommandLineRunner run(UserService userService) {
//		return args -> {
////			userService.saveRole(new Role("USER_ROLE", "USER_ROLE", new Date(), new Date()));
////			userService.saveRole(new Role("ADMIN_ROLE", "ADMIN_ROLE", new Date(), new Date()));
//
////			User user1 = new User();
////			user1.setUsername("TVS");
////			user1.setPassword("1234");
////			User user2 = new User();
////			user2.setUsername("TVS1234");
////			user2.setPassword("1234");
//////			userService.saveUser(user1);
////			userService.saveUser(user2);
//
////			userService.addRoleToUser("TVS", "USER_ROLE");
////			userService.addRoleToUser("TVS", "ADMIN_ROLE");
//			userService.addRoleToUser("TVS1234", "USER_ROLE");
//			userService.addRoleToUser("TVS1234", "ADMIN_ROLE");
//		};
//	}
//    @Bean
//    CommandLineRunner run(OrderService orderService) {
//        return args -> {
////			User user = new User();
////			user.setUsername("trieuvanson");
////
////			Order order = new Order();
////			order.setUser(user);
////			orderService.saveOrder(order);
//
//            Order order = orderService.findById((long)1);
////
////            System.out.println(order.getUser().getUsername());
////
//            orderService.saveOrderDetails(order);
//
//
//        };
//    }


//    @Bean
//    CommandLineRunner run(OrderDetailRepo orderService) {
//        return args -> {
//            orderService.getQuantityAndNameFormOrderDetail().forEach(p -> System.out.println(p.getName()));
//
//        };
//    }

}
