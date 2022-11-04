package com.jaieve.mandrakit.service;

import com.jaieve.mandrakit.dto.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface UserService {

    List<User> getUsers() throws ExecutionException, InterruptedException;
}
