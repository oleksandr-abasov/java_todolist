package com.example.todolist.controller;

import com.example.todolist.model.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {

    List<Todo> todos = new ArrayList<>();

    TodoController() {
        Todo stubTodo1 = new Todo(1, "Bake a cake", false, 1);
        Todo stubTodo2 = new Todo(2, "Make a soup", false, 2);
        todos.add(stubTodo1);
        todos.add(stubTodo2);
    }

    @GetMapping("todos")
    public List<Todo> getTodos() {
        // find all todos in db
        return todos;
    }

    @PostMapping("todos")
    public Todo createTodo(Todo todo) {
        // save todo in db
        todos.add(todo);
        return todo;
    }

    @PutMapping("todos/{id}")
    public Todo updateTodo(@PathVariable int id, Todo todo) {
        for (Todo cur: todos) {
            if (cur.getId() == id) {
                cur.setTitle(todo.getTitle());
                cur.setCompleted(todo.isCompleted());
                cur.setOrder(todo.getOrder());
                return cur;
            }
        }
        return null;
    }

    @DeleteMapping("todos/{id}")
    public void deleteTodo(@PathVariable int id) {
        for (Todo cur: todos) {
            if (cur.getId() == id) {
                // remove from db
                todos.remove(cur);
            }
        }
    }
}
