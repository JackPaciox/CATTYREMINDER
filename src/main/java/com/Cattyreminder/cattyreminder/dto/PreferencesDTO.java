package com.Cattyreminder.cattyreminder.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class PreferencesDTO {
    private Long id;

    private Boolean message;

    private Boolean email;

    private Boolean whatsapp;

    private Boolean events;

    private Boolean task;

    private Boolean project;
}
