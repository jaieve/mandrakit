package com.jaieve.mandrakit.controller.api;

import com.jaieve.mandrakit.dto.User;
import com.jaieve.mandrakit.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Slf4j
public class UserController {
//    private
    private final UserService userService;

    @GetMapping
    public ResponseEntity<Object> getUsers(@RequestParam String userKey) throws ExecutionException, InterruptedException {
        User user = userService.getUser(userKey);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/list")
    public ResponseEntity<Object> getUsers() throws ExecutionException, InterruptedException {
        List<User> list = userService.getUsers();
//        log.info(this.)
        return ResponseEntity.ok().body(list);
    }
}
