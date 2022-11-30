package com.Cattyreminder.cattyreminder.converter;

import com.Cattyreminder.cattyreminder.dto.ProjectDTO;
import com.Cattyreminder.cattyreminder.dto.TaskDTO;
import com.Cattyreminder.cattyreminder.model.Project;
import com.Cattyreminder.cattyreminder.model.Task;

public class ProjectConverter extends AbstractConverter<Project, ProjectDTO>{

    @Override
    public Project toEntity(ProjectDTO projectDTO) {
        Project project = null;
        if (projectDTO != null) {
            project = new Project(project.getId(), projectDTO.getName(), projectDTO.getAvatar(),projectDTO.getUser() ,projectDTO.getSegments());
        }
		return project;
    }

    @Override
    public ProjectDTO toDTO(Project project) {
        ProjectDTO projectDTO = null;
        if (project != null) {
            projectDTO = new ProjectDTO(project.getId(), project.getName(), project.getAvatar(),project.getUser(), project.getSegments());
        }
        return projectDTO;
    }
}
