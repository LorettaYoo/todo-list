package com.loretta.todolist.infrastructure;

import com.loretta.todolist.controller.response.TaskResponse;
import com.loretta.todolist.repository.entity.TaskPO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TaskMapper {
    TaskMapper MAPPER = Mappers.getMapper(TaskMapper.class);

    TaskResponse toTaskResponse(TaskPO taskPO);
}
