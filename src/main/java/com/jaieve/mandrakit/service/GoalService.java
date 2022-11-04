package com.jaieve.mandrakit.service;

import com.jaieve.mandrakit.dto.Goal;

import java.io.IOException;
import java.util.List;

public interface GoalService {
    void save(List<Goal> goals, String userId) throws IOException;
}
