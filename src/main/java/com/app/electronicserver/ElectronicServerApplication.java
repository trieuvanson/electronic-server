package com.app.electronicserver;

import com.app.electronicserver.model.Discount;
import com.app.electronicserver.model.Product;
import com.app.electronicserver.model.Role;
import com.app.electronicserver.model.User;
import com.app.electronicserver.repo.OrderRepo;
import com.app.electronicserver.repo.ProductRepo;
import com.app.electronicserver.service.CommentsService;
import com.app.electronicserver.service.DiscountService;
import com.app.electronicserver.service.ProductService;
import com.app.electronicserver.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ElectronicServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElectronicServerApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    CommandLineRunner run(UserService userService) {
//        return args -> {
//            if (userService.getUsers().isEmpty()) {
//                userService.saveRole(new Role("USER_ROLE", "USER_ROLE", new Date(), new Date()));
//                userService.saveRole(new Role("ADMIN_ROLE", "ADMIN_ROLE", new Date(), new Date()));
//                User user1 = new User();
//                user1.setUsername("TVS");
//                user1.setPassword("1234");
//                User user2 = new User();
//                user2.setUsername("TVS1234");
//                user2.setPassword("1234");
//                userService.saveUser(user1);
//                userService.saveUser(user2);
//
//                userService.addRoleToUser("TVS", "USER_ROLE");
//                userService.addRoleToUser("TVS", "ADMIN_ROLE");
//                userService.addRoleToUser("TVS1234", "USER_ROLE");
//                userService.addRoleToUser("TVS1234", "ADMIN_ROLE");
//            } else userService.getUsers();
//        };
//    }
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


    @Bean
    CommandLineRunner run(ProductService productService) {
        return args -> {
            List<String> pcName = new ArrayList<>();
            List<String> color = new ArrayList<>();
            List<String> pcDescription = Arrays.asList("Laptop", "Desktop", "Tablet", "Smartphone");
            String sort = "";
//            productService.getProductsByFilterUserUi("", pcName, color, 0.0, 999999999.0, false, true, sort)
//                    .stream()
//                    .map(Product::getId)
//                    .forEach(System.out::println);

        };
    }

}
