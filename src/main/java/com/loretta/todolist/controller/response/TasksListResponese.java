package com.loretta.todolist.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class TasksListResponese<T> {
    private long totalTasksNumber;
    private List<T> tasksList;
}
