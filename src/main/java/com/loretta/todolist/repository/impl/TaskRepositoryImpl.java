package com.loretta.todolist.repository.impl;

import com.loretta.todolist.repository.TaskRepository;
import com.loretta.todolist.repository.entity.TaskPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class TaskRepositoryImpl implements TaskRepository {
    @Autowired
    private JpaTaskRepository repository;


    @Override
    public List<TaskPO> findAll(Sort.Direction sort, String property) {
        return repository.findAll(Sort.by(sort, property));
    }
}
