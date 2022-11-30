package com.Cattyreminder.cattyreminder.dto;

import com.Cattyreminder.cattyreminder.model.Company;
import com.Cattyreminder.cattyreminder.model.Locations;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class LocationsDTO {
    private Long id;

    private String country;

    private String city;

    private String address;

    private String postalCode;

    private Company company;

}
