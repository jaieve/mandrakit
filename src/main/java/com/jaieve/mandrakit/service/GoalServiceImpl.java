package com.jaieve.mandrakit.service;

import com.jaieve.mandrakit.dto.Category;
import com.jaieve.mandrakit.repository.GoalDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class GoalServiceImpl implements GoalService{

    private final GoalDAO goalDAO;

    @Override
    public String save(Category category) {
        return goalDAO.save(category);
    }

    @Override
    public Category getGoal(String userId) throws ExecutionException, InterruptedException {
        return goalDAO.getGoal(userId);
    }
}

