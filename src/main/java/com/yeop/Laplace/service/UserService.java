package com.yeop.Laplace.service;

import com.yeop.Laplace.VO.User;
import com.yeop.Laplace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<?> insertUser(User user){
        return ResponseEntity.ok(userRepository.save(user));
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUser(String userId) {
        Optional<User> user = userRepository.findByUserId(userId);
        return user.orElseGet(() -> new User(1L, "", "", "", 0));
    }

    public void updateUser(String userId, String name){
        Optional<User> user = userRepository.findByUserId(userId);
        User newUser = null;
        if(user.isPresent()){
            newUser = user.get();
            newUser.setName(name);
        }else{
            return;
        }

        userRepository.save(newUser);
    }

    public int deleteByUserId(String userId){
        return userRepository.deleteByUserId(userId);
    }
}
