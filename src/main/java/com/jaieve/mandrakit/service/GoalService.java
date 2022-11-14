package com.jaieve.mandrakit.service;

import com.jaieve.mandrakit.dto.Category;

import java.util.concurrent.ExecutionException;

public interface GoalService {
    String save(Category category);
    Category getGoal(String userId) throws ExecutionException, InterruptedException;
}
