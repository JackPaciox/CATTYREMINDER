package com.Cattyreminder.cattyreminder.dto;

import com.Cattyreminder.cattyreminder.model.Company;
import com.Cattyreminder.cattyreminder.model.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class EventDTO {
    private Long id;

    private String link;

    private LocalDate date;

    private int duration;

    private List<User> users;

}
