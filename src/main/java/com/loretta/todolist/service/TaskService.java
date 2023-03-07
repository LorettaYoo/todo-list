package com.loretta.todolist.service;

import com.loretta.todolist.controller.response.TasksListResponese;
import com.loretta.todolist.controller.response.TasksResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class TaskService {
    public TasksListResponese<TasksResponse> listTasks() {
        return null;
    }
}
