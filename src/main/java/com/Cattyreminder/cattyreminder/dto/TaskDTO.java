package com.Cattyreminder.cattyreminder.dto;

import com.Cattyreminder.cattyreminder.model.Segment;
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
public class TaskDTO {

    private Long Id;

    private Boolean state;

    private String name;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    private Segment segments;

    private User user;


}
