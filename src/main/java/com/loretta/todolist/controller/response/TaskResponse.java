package com.loretta.todolist.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class TaskResponse {
    private long id;
    private String taskName;
    private boolean completed;
    private String createTime;
}
