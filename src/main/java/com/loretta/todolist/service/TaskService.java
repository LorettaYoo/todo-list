package com.loretta.todolist.service;

import com.loretta.todolist.controller.response.TasksListResponese;
import com.loretta.todolist.controller.response.TasksResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class TaskService {
    public TasksListResponese<TasksResponse> listTasks() {
        return new TasksListResponese<>(1,new ArrayList<>());
    }
}
