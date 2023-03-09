package com.loretta.todolist.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loretta.todolist.controller.response.TaskListResponse;
import com.loretta.todolist.controller.response.TaskResponse;
import com.loretta.todolist.service.TaskService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TaskControllerTest {
    @MockBean
    private TaskService taskService;
    @Autowired
    private MockMvc mockMvc;
    private static final String MVCRESULT = "{\"totalTasksNumber\":0,\"tasksList\":[]}";

    @Test
    void should_list_all_tasks() throws Exception {
        // Given
        TaskListResponse<TaskResponse> taskListResponse = new TaskListResponse<>(0L, new ArrayList<>());

        // When
        when(taskService.listTasks()).thenReturn(taskListResponse);

        RequestBuilder request = MockMvcRequestBuilders.get("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(taskListResponse));

        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();

        // Then
        Assertions.assertEquals(MVCRESULT, mvcResult.getResponse().getContentAsString());

    }

    @Test
    void should_add_task_successfully() {
        // Given


        // When

        // Then
    }
}