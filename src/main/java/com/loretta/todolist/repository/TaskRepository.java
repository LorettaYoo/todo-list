package com.loretta.todolist.repository;

import com.loretta.todolist.repository.entity.TaskPO;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository {
    List<TaskPO> findAll(Sort.Direction sort, String property);

}
