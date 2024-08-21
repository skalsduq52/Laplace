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
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("")
    @Tag(name = "User API")
    @Operation(summary = "User 생성", description = "User 정보를 생성합니다.")
    public ResponseEntity<?> insertUser(User user){
        return userService.insertUser(user);
    }

    @GetMapping("")
    @Tag(name = "User API")
    @Operation(summary = "User 목록 조회", description = "전체 User 정보를 조회합니다.")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @Tag(name = "User API")
    @Operation(summary = "User 정보 조회", description = "특정 User 정보를 조회합니다.")
    @GetMapping("/{userId}")
    public User getUser(@PathVariable String userId) {
        return userService.getUser(userId);
    }

    @PutMapping("")
    @Tag(name = "User API")
    @Operation(summary = "User 이름 업데이트", description = "id를 키로 유저의 이름을 수정합니다")
    public void updateUser(String userId, String name){
        userService.updateUser(userId, name);
    }

    @Tag(name = "User API")
    @Operation(summary = "User 삭제", description = "특정 User를 삭제 합니다.")
    @DeleteMapping("/{userId}")
    @Transactional
    public int deleteUser(@PathVariable String userId) {
        return userService.deleteByUserId(userId);
    }



}
