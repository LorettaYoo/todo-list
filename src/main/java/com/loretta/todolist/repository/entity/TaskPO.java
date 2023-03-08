package com.loretta.todolist.repository.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "task")
public class TaskPO {
    @Id
    private long id;
    @Column(name = "task_name")
    private String taskName;
    private boolean completed;
    private boolean deleted;

    @Column(name = "create_time")
    private String createTime;

}
