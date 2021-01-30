package com.example.todolist.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Todo {
    private int id;
    private String title;
    private boolean completed;
    private int order;

    public Todo(String title) {
        this.title = title;
        this.completed = false;
        this.order = 1;
    }
}
