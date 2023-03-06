package com.loretta.todolist.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Table;

@Builder
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "task")
public class TaskPO {
    private long id;
    @Column(name = "task_name")
    private String taskName;
    private boolean completed;
    private boolean deleted;

}
