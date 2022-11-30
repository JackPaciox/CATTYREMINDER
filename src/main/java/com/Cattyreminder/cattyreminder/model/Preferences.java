package com.Cattyreminder.cattyreminder.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="preferences")
public class Preferences {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean message;

    private Boolean email;

    private Boolean whatsapp;

    private Boolean events;

    private Boolean task;

    private Boolean project;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
