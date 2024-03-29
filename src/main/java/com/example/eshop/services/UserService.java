package com.example.eshop.services;

import com.example.eshop.entity.User;
import com.example.eshop.entity.enums.Role;
import com.example.eshop.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean createUser(User user) {
        String email = user.getEmail();
        if (userRepository.findByEmail(email) != null) return false;
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setPassword(user.getPassword());
        user.getRoles().add(Role.ROLE_ADMIN);
        log.info("Saving new User with email: {}", email);
        userRepository.save(user);
        return true;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void banUser(Long id) {
        if (id!=null){
           User user = userRepository.findById(id).orElse(null);
            assert user != null;
            user.setActive(false);
            log.info("Ban User with id ={}; email: {}", user.getId(), user.getEmail());
            userRepository.save(user);
        }
    }

    public void unBanUser(Long id) {
        if (id!=null){
            User user = userRepository.findById(id).orElse(null);
            assert user != null;
            user.setActive(true);
            log.info("Unban User with id ={}; email: {}", user.getId(), user.getEmail());
            userRepository.save(user);
        }
    }

    public void changeUserRole(User user, Map<String, String> form) {
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());
        user.getRoles().clear();
        for (String key: form.keySet()){
            if (roles.contains(key)){
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userRepository.save(user);
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }
}
