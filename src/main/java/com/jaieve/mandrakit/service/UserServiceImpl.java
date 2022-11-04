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
}
