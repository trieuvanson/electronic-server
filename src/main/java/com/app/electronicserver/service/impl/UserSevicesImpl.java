package com.app.electronicserver.service.impl;

import com.app.electronicserver.model.Role;
import com.app.electronicserver.model.User;
import com.app.electronicserver.repo.RoleRepo;
import com.app.electronicserver.repo.UserRepo;
import com.app.electronicserver.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserSevicesImpl implements UserService, UserDetailsService {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null)   {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User found in the database: {}", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
    @Override
    public User saveUser(User user) {
        log.info("Saving new user to the database");
        user.setCreated_at(new Date());
        user.setUpdate_at(new Date());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }
    @Override
    public User updateUser(User user) {
        log.info("Updatting user {} to the database", user.getUsername());
        User oldUser = userRepo.findByUsername(user.getUsername());
        String password = oldUser.getPassword();
        passwordEncoder.matches(password, user.getPassword());
        oldUser.setFullname(user.getFullname());
        oldUser.setAvatar(user.getAvatar());
        oldUser.setEmail(user.getEmail());
        oldUser.setPhone(user.getPhone());
        oldUser.setBirthday(user.getBirthday());
        oldUser.setStatus(user.getStatus());
        oldUser.setAddress(user.getAddress());
        oldUser.setGender(user.getGender());
        oldUser.setUpdate_at(new Date());
        return userRepo.save(oldUser);
    }
    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        role.setCreated_at(new Date());
        role.setUpdate_at(new Date());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        log.info("Adding role {} to user {}", roleName, userName);
        int countUser = 0;
        int countAdmin = 0;
        User user = userRepo.findByUsername(userName);
        for (Role role : user.getRoles()) {
            if (role.getName().equals("USER_ROLE")) {
                countUser++;
            } else if (role.getName().equals("ADMIN_ROLE")) {
                countAdmin++;
            }
        }
        if (countUser == 0 && roleName.equals("USER_ROLE") || countAdmin == 0 && roleName.equals("ADMIN_ROLE")) {
            Role role = roleRepo.findByName(roleName);
            user.getRoles().add(role);
        }

    }

    @Override
    public User getUser(String userName) {
        log.info("Fetching user {}", userName);
        return userRepo.findByUsername(userName);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepo.findAll();
    }


}
