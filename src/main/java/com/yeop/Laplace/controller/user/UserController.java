package com.yeop.Laplace.controller.user;

import com.yeop.Laplace.VO.User;
import com.yeop.Laplace.repository.UserRepository;
import com.yeop.Laplace.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@Tag(name = "유저", description = "유저 관련 api 입니다.")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create")
    @Tag(name = "User API")
    @Operation(summary = "User 생성", description = "User 정보를 생성합니다.")
    public ResponseEntity<?> createUser(User user){
        return ResponseEntity.ok(userRepository.save(user));
    }

    @GetMapping("/lists")
    @Tag(name = "User API")
    @Operation(summary = "User 목록 조회", description = "전체 User 정보를 조회합니다.")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @Tag(name = "User API")
    @Operation(summary = "User 정보 조회", description = "특정 User 정보를 조회합니다.")
    @GetMapping("/lists/{userId}")
    public User getUser(@PathVariable String userId) {
        return userRepository.findByUserId(userId);
    }

    @Tag(name = "User API")
    @Operation(summary = "User 삭제", description = "특정 User를 삭제 합니다.")
    @DeleteMapping("/delete/{userId}")
    @Transactional
    public void deleteUser(@PathVariable String userId) {
        userRepository.deleteByUserId(userId);
    }



}
