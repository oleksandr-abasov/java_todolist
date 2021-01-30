package com.example.todolist.controller;

import com.example.todolist.converter.TodoConverter;
import com.example.todolist.dto.TodoDto;
import com.example.todolist.model.Todo;
import com.example.todolist.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class TodoController {

    private TodoService todoService;

    TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("todos")
    public List<TodoDto> getTodos() {
        return todoService.findAll()
                .stream().map(todo -> TodoConverter.modelToDto(todo))
                .collect(Collectors.toList());
    }

    @PostMapping("todos")
    public TodoDto createTodo(@RequestBody TodoDto todoDto) {
        Todo createdTodo = todoService.createOrUpdate(TodoConverter.dtoToModel(todoDto));
        return TodoConverter.modelToDto(createdTodo);
    }

    @PutMapping("todos/{id}")
    public TodoDto updateTodo(@PathVariable int id, @RequestBody TodoDto todo) {
        Optional<Todo> fetched = todoService.findById(id);
        if (fetched.isPresent()) {
            Todo fetchedTodo = fetched.get();
            fetchedTodo.setTitle(todo.getTitle());
            fetchedTodo.setCompleted(todo.isCompleted());
            fetchedTodo.setOrder(todo.getOrder());
            Todo updatedTodo = todoService.createOrUpdate(fetchedTodo);
            return TodoConverter.modelToDto(updatedTodo);
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
