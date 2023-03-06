package com.loretta.todolist.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TasksResponse {
    private long id;
    private String taskName;
    private boolean completed;
    private boolean deleted;
}
