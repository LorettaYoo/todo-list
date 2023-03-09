package com.loretta.todolist.controller.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class AddTaskRequest {
    private String taskName;
}
