package com.loretta.todolist.service;

import com.loretta.todolist.controller.response.TaskListResponse;
import com.loretta.todolist.controller.response.TaskResponse;
import com.loretta.todolist.infrastructure.TaskMapper;
import com.loretta.todolist.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class TaskService {
    private TaskRepository taskRepository;
    public TaskListResponse<TaskResponse> listTasks() {
        List<TaskResponse> taskResponseList = taskRepository.findAll(Sort.Direction.DESC, "createTime")
                .stream()
                .map(TaskMapper.MAPPER::toTaskResponse)
                .collect(Collectors.toList());
        int taskNumber = taskResponseList.size();
        return new TaskListResponse<>(taskNumber,taskResponseList);
    }
}
