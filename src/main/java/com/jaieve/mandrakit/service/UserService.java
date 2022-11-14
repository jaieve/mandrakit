package com.jaieve.mandrakit.service;

import com.jaieve.mandrakit.dto.User;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface UserService {

    List<User> getUsers() throws ExecutionException, InterruptedException;
    User getUser(String userKey) throws ExecutionException, InterruptedException;
    User getUserById(String userId) throws ExecutionException, InterruptedException;
    void saveGoal(String userKey, String goalKey) throws ExecutionException, InterruptedException;
    void saveUser(User user) throws ExecutionException, InterruptedException;
}
