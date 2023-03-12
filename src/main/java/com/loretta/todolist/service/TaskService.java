package com.loretta.todolist.service;

import com.loretta.todolist.controller.request.AddTaskRequest;
import com.loretta.todolist.controller.response.TaskListResponse;
import com.loretta.todolist.controller.response.TaskResponse;
import com.loretta.todolist.infrastructure.TaskMapper;
import com.loretta.todolist.repository.TaskRepository;
import com.loretta.todolist.repository.entity.TaskPO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class TaskService {
    private TaskRepository taskRepository;

    public TaskListResponse<TaskResponse> listTasks() {
        List<TaskResponse> taskResponseList = taskRepository.findAll(Sort.by(Sort.Direction.DESC, "createTime"))
                .stream()
                .map(TaskMapper.MAPPER::toTaskResponse)
                .collect(Collectors.toList());
        int taskNumber = taskResponseList.size();
        return new TaskListResponse<>(taskNumber, taskResponseList);
    }


    public void saveTasks(AddTaskRequest request) {
        String taskName = request.getTaskName();
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);
        TaskPO taskPO = TaskPO.builder().taskName(taskName).createTime(createTime).build();
        taskRepository.save(taskPO);
    }

    public void completeTasks(long id) {
        Optional<TaskPO> optionalTaskPO = taskRepository.findById(id);
        if (optionalTaskPO.isPresent()) {
            boolean completed = optionalTaskPO.get().isCompleted();
            taskRepository.updateCompletedById(!completed,id);
        }else {
            throw new RuntimeException();
        }
    }
}
