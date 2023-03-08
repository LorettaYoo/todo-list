package com.loretta.todolist.repository.impl;

import com.loretta.todolist.repository.entity.TaskPO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTaskRepository extends JpaRepository<TaskPO,Long> {

}
