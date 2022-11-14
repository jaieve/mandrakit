package com.jaieve.mandrakit.controller.api;

import com.jaieve.mandrakit.dto.Category;
import com.jaieve.mandrakit.service.GoalService;
import com.jaieve.mandrakit.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/goal")
@Slf4j
public class GoalController {
    @Value("${firebase.sample.path}")
    public String sampleGoals;
    @Autowired
    private final GoalService goalService;
    private final UserService userService;

    @GetMapping
    public ResponseEntity<Object> getGoal(@RequestParam String userKey) throws ExecutionException, InterruptedException {
        String goalId = userService.getUser(userKey).getGoalKey();
        log.info("GoalID: {}", goalId);
        Category category = goalService.getGoal(goalId);
        return ResponseEntity.ok().body(category);
    }

    @PostMapping("/save")
    public ResponseEntity<Category> save(@RequestBody Category category) throws ExecutionException, InterruptedException {
        log.info("Category : {}",  category);
        String goalKey = goalService.save(category);
        userService.saveGoal(category.getUserKey(), goalKey);
        return ResponseEntity.ok().body(category);
    }
}
