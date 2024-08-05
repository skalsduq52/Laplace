package com.yeop.Laplace.controller.user;

import com.yeop.Laplace.VO.User;
import com.yeop.Laplace.repository.UserRepository;
import com.yeop.Laplace.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(User user){
        return ResponseEntity.ok(userRepository.save(user));
    }

    @GetMapping("/lists")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/lists/{userId}")
    public User getUser(@PathVariable String userId) {
        return userRepository.findByUserId(userId);
    }

    @DeleteMapping("/delete/{userId}")
    @Transactional
    public void deleteUser(@PathVariable String userId) {
        userRepository.deleteByUserId(userId);
    }



}
