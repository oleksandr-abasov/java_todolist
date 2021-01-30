package com.example.todolist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class TodoDto {
    private Integer id;
    private Integer order;
    private boolean completed;
    private String title;
}
