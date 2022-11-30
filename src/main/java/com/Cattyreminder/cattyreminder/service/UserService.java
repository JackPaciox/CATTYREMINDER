package com.Cattyreminder.cattyreminder.service;

import com.Cattyreminder.cattyreminder.converter.UserConverter;
import com.Cattyreminder.cattyreminder.dao.UserRepository;
import com.Cattyreminder.cattyreminder.dto.UserDTO;
import com.Cattyreminder.cattyreminder.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Estende AbstractService con parametri User e UserDTO.
 * Implementa il metodo di login ed eredita quelli Abstract.
 *
 * @author Vittorio Valent & Girolamo Murdaca
 *
 * @see AbstractService
 * @see ServiceDTO
 */
@Service
public class UserService extends AbstractService<User, UserDTO> {


    //ALL crud methods in AbstractService

    //LOGIN method
    public UserDTO findByUsernameAndPassword(String username, String password) {
        UserConverter userConverter = new UserConverter();
        return userConverter.toDTO(((UserRepository)repository).findByUsernameAndPassword(username, password));
    }

    public boolean existByUsernameAndPassword(String username, String password) {
        return ((UserRepository)repository).existsByUsernameAndPassword(username, password);
    }
	/*
	public List<UserDTO> getAdminUsersList() {
		return converter.toDTOList((UserRepository)repository.findByUsertype(User.Usertype.ADMIN));
	}
	 */
    public boolean isAdmin(UserDTO user){
        //user.getUsertype().equals(User.Usertype.ADMIN)
        return false;
    }

    @Override
    public UserDTO insert(UserDTO userDTO){
        UserConverter userConverter = new UserConverter();
        return userConverter.toDTO(repository.save(userConverter.toEntity(userDTO)));
    }

//    @Override
//    public Iterable<UserDTO> getAll() {
//        return converter.toDTOList(((UserRepository)repository).findByUsertypeNot(User.Usertype.SUPERADMIN));
//    }
//
//    public byte[] convertToByteArray(MultipartFile file) throws IOException {
//        byte [] byteArr = null;
//        if(file != null){
//            byteArr = file.getBytes();
//            return byteArr;
//        }
//        return null;
//    }
//
//    public MultipartFile convertToMultipartFile(byte[] byteArr) throws IOException {
//        MultipartFile file = null;
//        if(byteArr != null){
//            file.getInputStream();
//            return file;
//        }
//        return null;
//    }


}