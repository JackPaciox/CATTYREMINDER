package com.Cattyreminder.cattyreminder.converter;

import com.Cattyreminder.cattyreminder.dto.TaskDTO;
import com.Cattyreminder.cattyreminder.model.Task;

public class TaskConverter extends AbstractConverter<Task, TaskDTO>{

    @Override
    public Task toEntity(TaskDTO taskDTO) {
        Task task = null;
        if (taskDTO != null) {
            task = new Task(taskDTO.getId(),taskDTO.getState(), taskDTO.getName(), taskDTO.getDescription(), taskDTO.getStartDate(),taskDTO.getEndDate(),taskDTO.getUser(),taskDTO.getSegments());
        }
		return task;
    }

    @Override
    public TaskDTO toDTO(Task task) {
        TaskDTO taskDTO = null;
        if (task != null) {
            taskDTO = new TaskDTO(task.getId(),task.getState(), task.getName(), task.getDescription(), task.getStartDate(),task.getEndDate(),task.getSegment(),task.getUser());
        }
        return taskDTO;
    }
}
