package com.jaieve.mandrakit.controller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jaieve.mandrakit.dto.Goal;
import com.jaieve.mandrakit.service.GoalService;
import com.jaieve.mandrakit.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/goal")
@Slf4j
public class GoalController {
    @Value("${firebase.sample.path}")
    public String sampleGoals;
    private final GoalService goalService;
    private final JsonUtil jsonUtil;

    @GetMapping("/save")
    public ResponseEntity<Object> save() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Goal> goals = mapper.readValue(jsonUtil.readLines(sampleGoals), List.class);
        String userId = "jaieve1469";
        goalService.save(goals, userId);
        return ResponseEntity.ok().body(goals);
    }
}
