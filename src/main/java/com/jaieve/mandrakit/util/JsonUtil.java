package com.jaieve.mandrakit.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class JsonUtil {
    public String readLines(String filename) {
        return new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(filename))).lines().collect(Collectors.joining());
    }
}
