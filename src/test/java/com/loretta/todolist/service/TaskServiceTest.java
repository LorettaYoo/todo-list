package com.loretta.todolist.service;

import com.loretta.todolist.controller.request.AddTaskRequest;
import com.loretta.todolist.controller.response.TaskListResponse;
import com.loretta.todolist.controller.response.TaskResponse;
import com.loretta.todolist.infrastructure.TaskMapper;
import com.loretta.todolist.repository.TaskRepository;
import com.loretta.todolist.repository.entity.TaskPO;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Sort;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class TaskServiceTest {
    private final TaskRepository taskRepository = mock(TaskRepository.class);

    private final TaskService taskService = new TaskService(taskRepository);

    @Test
    void should_return_all_tasks() {
        // Given
        TaskPO taskPO = new TaskPO(1L, "task 01", false, false, "2023/03/07");
        List<TaskPO> taskPOList = List.of(taskPO);
        TaskResponse taskResponse = TaskMapper.MAPPER.toTaskResponse(taskPO);
        List<TaskResponse> taskResponseList = List.of(taskResponse);

        // When
        when(taskRepository.findAll(Sort.by(Sort.Direction.DESC, "createTime"))).thenReturn(taskPOList);
        TaskListResponse<TaskResponse> taskResponseTaskListResponse = taskService.listTasks();

        // Then
        assertEquals(1L, taskResponseTaskListResponse.getTotalTasksNumber());
        assertEquals(taskResponseList.toString(), taskResponseTaskListResponse.getTasksList().toString());

    }

    @Test
    void should_save_task_successfully() {
        // Given
        AddTaskRequest request = AddTaskRequest.builder().taskName("test task").build();
        TaskPO taskPO = TaskPO.builder().taskName("test task").build();

        // When
        when(taskRepository.save(taskPO)).thenReturn(taskPO);
        taskService.saveTasks(request);

        // Then
        verify(taskRepository).save(taskPO);
    }
}