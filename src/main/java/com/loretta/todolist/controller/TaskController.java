package com.loretta.todolist.controller;

import com.loretta.todolist.controller.request.AddTaskRequest;
import com.loretta.todolist.controller.response.TaskListResponse;
import com.loretta.todolist.controller.response.TaskResponse;
import com.loretta.todolist.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private TaskService taskService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public TaskListResponse<TaskResponse> listTasks() {
        return taskService.listTasks();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> addTasks(@RequestBody AddTaskRequest request) {
        taskService.saveTasks(request);
        return new ResponseEntity<>("Created Successfully",HttpStatus.CREATED);
    }


}
