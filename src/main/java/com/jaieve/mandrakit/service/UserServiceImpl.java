package com.jaieve.mandrakit.service;

import com.jaieve.mandrakit.dto.User;
import com.jaieve.mandrakit.repository.UserDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Override
    public List<User> getUsers() throws ExecutionException, InterruptedException {
        return userDAO.getUsers();
    }

    @Override
    public User getUser(String userId) throws ExecutionException, InterruptedException {
        return userDAO.getUser(userId);
    }

    @Override
    public void saveGoal(String userKey, String goalKey) throws ExecutionException, InterruptedException {
        userDAO.saveGoal(userKey, goalKey);
    }
}
