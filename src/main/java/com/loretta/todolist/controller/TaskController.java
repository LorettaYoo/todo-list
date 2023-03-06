package com.loretta.todolist.controller;

import com.loretta.todolist.controller.response.TasksListResponese;
import com.loretta.todolist.controller.response.TasksResponse;
import com.loretta.todolist.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TaskController {
    private TaskService taskService;

    @GetMapping("/tasks")
    public TasksListResponese<TasksResponse> listTasks() {
        return taskService.listTasks();
    }
}
