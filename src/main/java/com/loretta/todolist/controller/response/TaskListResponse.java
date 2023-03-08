package com.loretta.todolist.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class TaskListResponse<T> {
    private long totalTasksNumber;
    private List<T> tasksList;
}
