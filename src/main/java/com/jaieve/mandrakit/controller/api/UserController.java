package com.jaieve.mandrakit.controller.api;

import com.jaieve.mandrakit.dto.User;
import com.jaieve.mandrakit.service.UserService;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
@Slf4j
public class UserController {
    private final UserService userService;

//    @Operation(summary = "사용자 정보 조회", description = "Firebase 컬렉션 Users의 특정 User(문서)")
//    @ApiParam(value="${param1.description}")
//    @GetMapping
//    public ResponseEntity<Object> getUser(@RequestParam String userKey) throws ExecutionException, InterruptedException {
//        User user = userService.getUser(userKey);
//        return ResponseEntity.ok().body(user);
//    }

    @Operation(summary = "사용자 정보 조회", description = "Firebase 컬렉션 Users의 특정 User(문서)")
    @ApiParam(value="${param1.description}")
    @GetMapping
    public ResponseEntity<Object> getUserById(@RequestParam String userId) throws ExecutionException, InterruptedException {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok().body(user);
    }

    @Operation(summary = "사용자 전체 목록 조회", description = "Firebase 컬렉션 Users의 모든 문서 조회")
    @GetMapping("/list")
    public ResponseEntity<Object> getUsers() throws ExecutionException, InterruptedException {
        List<User> list = userService.getUsers();
//        log.info(this.)
        return ResponseEntity.ok().body(list);
    }

    @Operation(summary = "사용자 신규 등록", description = "Firebase 컬렉션 Users 신규 문서 추가")
    @PostMapping("/save")
    public ResponseEntity<Object> saveUser(@RequestBody User user) throws ExecutionException, InterruptedException {
        userService.saveUser(user);
        return ResponseEntity.ok().body(user);
    }
}
