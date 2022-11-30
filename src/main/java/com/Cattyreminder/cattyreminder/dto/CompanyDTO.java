package com.Cattyreminder.cattyreminder.dto;

import com.Cattyreminder.cattyreminder.model.Locations;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class CompanyDTO {
    private Long id;

    private String avatar;

    private String name;

    private List<Locations> locationsList;

}
