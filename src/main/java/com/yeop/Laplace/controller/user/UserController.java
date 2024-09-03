package com.yeop.Laplace.controller.user;

import com.yeop.Laplace.VO.User;
import com.yeop.Laplace.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "User API", description = "유저 정보 관련 API 입니다.")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "성공"),
        @ApiResponse(responseCode = "4xx", description = "실패")
})
@RequestMapping("/users")
@RestController
public class UserController {


    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create")
    @Tag(name = "User API")
    @Operation(summary = "User 생성", description = "User 정보를 생성합니다.")
    @Parameters({
            @Parameter(name = "userId", description = "유저 아이디", example = "nmy5220", required = true),
            @Parameter(name = "name", description = "유저 이름", example = "나민엽", required = true),
            @Parameter(name = "age", description = "유저 나이", example = "29", required = true),
            @Parameter(name = "oid", description = "자동 생성되는 값입니다.")
    })
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
    public Optional<User> getUser(@PathVariable String userId) {
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
