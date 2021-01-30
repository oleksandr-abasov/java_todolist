package com.example.todolist.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class Todo {
    @Id
    private int id;
    private String title;
    private boolean completed;
    @Column(name = "sorting_order")
    private int order;

    public Todo(String title) {
        this.title = title;
        this.completed = false;
        this.order = 1;
    }
}
