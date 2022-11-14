package com.jaieve.mandrakit.controller.api;

import com.jaieve.mandrakit.dto.Category;
import com.jaieve.mandrakit.service.GoalService;
import com.jaieve.mandrakit.service.UserService;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/goals")
@Slf4j
public class GoalController {
    @Value("${firebase.sample.path}")
    public String sampleGoals;
    @Autowired
    private final GoalService goalService;
    private final UserService userService;

    @Operation(summary = "만다라트 조회 by userKey", description = "Firebase 컬렉션 Goals의 특정 goal(=만다라트)(문서)")
    @ApiParam(value="User컬렉션에 저장된 GoalKey 확인하여 Goal컬렉션에서 문서정보 확인")
    @GetMapping
    public ResponseEntity<Object> getGoal(@RequestParam String userKey) throws ExecutionException, InterruptedException {
        String goalKey = userService.getUser(userKey).getGoalKey();
        log.info("GoalID: {}", goalKey);
        Category category = goalService.getGoal(goalKey);
        return ResponseEntity.ok().body(category);
    }

    @Operation(summary = "만다라트 등록", description = "Firebase 컬렉션 Goals에 새로운 문서 추가")
    @ApiParam(value="클라이언트에서 content, title, description, userKey를 전달해야 함.")
    @PostMapping("/save")
    public ResponseEntity<Category> save(@RequestBody Category category) throws ExecutionException, InterruptedException {
        log.info("Category : {}",  category);
        String goalKey = goalService.save(category);
        userService.saveGoal(category.getUserKey(), goalKey);
        return ResponseEntity.ok().body(category);
    }
}
