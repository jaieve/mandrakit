package com.jaieve.mandrakit.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
public class Category {
    private Map<String, List<String>> contents;
    private String description;
    private String title;
    private Date createDateTime;
    private Date updateDateTime;
    private String userKey;
}
