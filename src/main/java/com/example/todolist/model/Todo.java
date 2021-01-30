package com.example.todolist.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class Todo {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "sorting_order")
    private Integer order;
    private boolean completed;
    private String title;

    public Todo(String title) {
        this.title = title;
        this.completed = false;
        this.order = 1;
    }
}
