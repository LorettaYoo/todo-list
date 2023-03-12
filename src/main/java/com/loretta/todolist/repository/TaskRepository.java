package com.loretta.todolist.repository;

import com.loretta.todolist.repository.entity.TaskPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TaskRepository extends JpaRepository<TaskPO, Long> {
    @Transactional
    @Modifying
    @Query("update TaskPO t set t.completed = ?1 where t.id = ?2")
    void updateCompletedById(boolean completed, long id);

}
