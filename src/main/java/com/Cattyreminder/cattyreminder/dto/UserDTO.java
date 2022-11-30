package com.Cattyreminder.cattyreminder.dto;

import com.Cattyreminder.cattyreminder.model.Preferences;
import com.Cattyreminder.cattyreminder.model.ContactSetting;
import com.Cattyreminder.cattyreminder.model.Project;
import com.Cattyreminder.cattyreminder.model.Task;
import com.Cattyreminder.cattyreminder.model.User.Usertype;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;

    private Usertype usertype;

    private String username;

    private String firstname;

    private String lastname;

    private String password;

    private String email;

    private String phone;

    private String discord;

    private List<Task> task;

    private List<Project> project;

    private ContactSetting contactSetting;


    private Preferences preferences;

}
