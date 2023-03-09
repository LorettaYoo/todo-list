package com.loretta.todolist.repository;

import com.loretta.todolist.repository.entity.TaskPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskPO, Long> {

}
