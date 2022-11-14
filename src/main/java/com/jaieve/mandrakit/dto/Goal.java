package com.jaieve.mandrakit.dto;

import lombok.Data;

import java.util.Map;

@Data
public class Goal {
    private String userId;
    private String title;
    private String description;
    private String createDateTime;
    private String updateDateTime;
    private Map<String,Category> goal;
}

