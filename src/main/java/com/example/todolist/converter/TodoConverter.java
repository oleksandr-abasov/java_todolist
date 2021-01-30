package com.example.todolist.converter;

import com.example.todolist.dto.TodoDto;
import com.example.todolist.model.Todo;

public class TodoConverter {

    public static Todo dtoToModel(TodoDto todoDto) {
        return new Todo(todoDto.getId(), todoDto.getOrder(), todoDto.isCompleted(), todoDto.getTitle());
    }

    public static TodoDto modelToDto(Todo todo) {
        return new TodoDto(todo.getId(), todo.getOrder(), todo.isCompleted(), todo.getTitle());
    }

}
