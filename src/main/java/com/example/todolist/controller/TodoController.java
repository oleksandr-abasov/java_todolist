package com.example.todolist.controller;

import com.example.todolist.model.Todo;
import com.example.todolist.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TodoController {

    private TodoService todoService;

    TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("todos")
    public List<Todo> getTodos() {
        return todoService.findAll();
    }

    @PostMapping("todos")
    public Todo createTodo(Todo todo) {
        return todoService.createOrUpdate(todo);
    }

    @PutMapping("todos/{id}")
    public Todo updateTodo(@PathVariable int id, Todo todo) {
        Optional<Todo> fetched = todoService.findById(id);
        if (fetched.isPresent()) {
            Todo fetchedTodo = fetched.get();
            fetchedTodo.setTitle(todo.getTitle());
            fetchedTodo.setCompleted(todo.isCompleted());
            fetchedTodo.setOrder(todo.getOrder());
            return todoService.createOrUpdate(fetchedTodo);
        }
        return null;
    }

    @DeleteMapping("todos/{id}")
    public void deleteTodo(@PathVariable int id) {
        Optional<Todo> fetched = todoService.findById(id);
        if (fetched.isPresent()) {
            todoService.delete(fetched.get());
        }
    }
}
