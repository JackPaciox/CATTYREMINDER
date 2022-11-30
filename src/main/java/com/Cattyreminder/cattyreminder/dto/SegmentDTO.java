package com.Cattyreminder.cattyreminder.dto;

import com.Cattyreminder.cattyreminder.model.Project;
import com.Cattyreminder.cattyreminder.model.Task;
import com.Cattyreminder.cattyreminder.model.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class SegmentDTO {

    private Long Id;

    private Boolean state;

    private String name;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    private Project project;

    private int status;

    private List<User> resources;

    private List<Task> tasks;
}
