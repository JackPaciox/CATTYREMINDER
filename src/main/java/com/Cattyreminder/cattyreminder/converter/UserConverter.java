package com.Cattyreminder.cattyreminder.converter;

import com.Cattyreminder.cattyreminder.dto.UserDTO;
import com.Cattyreminder.cattyreminder.model.User;

public class UserConverter extends AbstractConverter<User, UserDTO>{

    @Override
    public User toEntity(UserDTO userDTO) {
        User user = null;
        if (userDTO != null) {
            user = new User(userDTO.getId(),userDTO.getUsertype(),userDTO.getUsername(),userDTO.getFirstname(),userDTO.getLastname(), userDTO.getPassword(), userDTO.getEmail(), userDTO.getPhone(), userDTO.getDiscord(), userDTO.getProject(),userDTO.getTask() ,userDTO.getContactSetting(),userDTO.getPreferences());
        }
		return user;
    }

    @Override
    public UserDTO toDTO(User user) {
        UserDTO userDTO = null;
        if (user != null) {
            userDTO = new UserDTO(user.getId(), user.getUsertype(), user.getUsername(), user.getFirstname(), user.getLastname(), user.getPassword(), user.getEmail(), user.getPhone(), user.getDiscord(), user.getTask(),user.getProject(), user.getContactSetting(), user.getPreferences());
        }
        return userDTO;
    }
}
