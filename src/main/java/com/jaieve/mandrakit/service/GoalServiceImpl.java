package com.jaieve.mandrakit.service;

import com.jaieve.mandrakit.dto.Goal;
import com.jaieve.mandrakit.repository.GoalDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GoalServiceImpl implements GoalService{

    private final GoalDAO goalDAO;

    @Override
    public void save(List<Goal> goals, String userId) throws IOException {
        goalDAO.save(goals, userId);
    }
}
