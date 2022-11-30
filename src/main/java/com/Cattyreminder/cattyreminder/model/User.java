package com.Cattyreminder.cattyreminder.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user")
public class User {

    //un giorno bisognera' implementare anche un superAdmin.
    public enum Usertype {
        ADMIN, USER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Usertype usertype;

    private String username;

    private String firstname;

    private String lastname;

    private String password;

    private String email;

    @Nullable
    private String phone;

    @Nullable
    private String discord;

    @Nullable
    @OneToMany(mappedBy = "user", cascade = CascadeType.MERGE)
    private List<Project> project;

    @Nullable
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Task> task;

    @Nullable
    @OneToOne
    @JoinColumn(name = "contactsetting_id")
    private ContactSetting contactSetting;

    @Nullable
    @OneToOne
    @JoinColumn(name = "preferences_id")
    private Preferences preferences;

}
