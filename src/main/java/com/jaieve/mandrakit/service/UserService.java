package com.jaieve.mandrakit.service;

import com.jaieve.mandrakit.dto.User;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface UserService {

    List<User> getUsers() throws ExecutionException, InterruptedException;
    User getUser(String userId) throws ExecutionException, InterruptedException;
    void saveGoal(String userKey, String goalKey) throws ExecutionException, InterruptedException;
}
