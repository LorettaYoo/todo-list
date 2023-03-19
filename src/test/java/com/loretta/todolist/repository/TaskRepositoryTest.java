package com.loretta.todolist.repository;

import com.loretta.todolist.repository.entity.TaskPO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static com.loretta.todolist.utils.SqlPathConstants.INSERT_TWO_TASKS_SQL;
import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@Rollback
class TaskRepositoryTest {
    @Autowired
    private TaskRepository taskRepository;

    @Test
    void should_return_empty_task_list() {
        // When
        List<TaskPO> taskPOList = taskRepository.findAll(Sort.by(Sort.Direction.DESC, "createTime"));

        // Then
        assertThat(taskPOList).isEmpty();
    }

    @Test
    @Sql(INSERT_TWO_TASKS_SQL)
    void should_return_all_tasks() {
        // When
        List<TaskPO> taskPOList = taskRepository.findAll(Sort.by(Sort.Direction.DESC, "createTime"));

        // Then
        assertThat(taskPOList).hasSize(2);
        assertThat(taskPOList.get(0).getTaskName()).isEqualTo("task 02");
        assertThat(taskPOList.get(0).isCompleted()).isEqualTo(false);
    }

    @Test
    void should_save_task_successfully() {
        // Given
        TaskPO taskPO = TaskPO.builder().taskName("test task").build();

        // When
        TaskPO save = taskRepository.save(taskPO);

        // Then
        assertThat(save.getTaskName()).isEqualTo("test task");
        assertThat(save.isCompleted()).isEqualTo(false);
    }
}