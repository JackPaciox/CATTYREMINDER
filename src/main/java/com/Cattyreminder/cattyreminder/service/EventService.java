package com.Cattyreminder.cattyreminder.service;

import com.Cattyreminder.cattyreminder.converter.UserConverter;
import com.Cattyreminder.cattyreminder.dao.EventRepository;
import com.Cattyreminder.cattyreminder.dao.ProjectRepository;
import com.Cattyreminder.cattyreminder.dto.EventDTO;
import com.Cattyreminder.cattyreminder.dto.ProjectDTO;
import com.Cattyreminder.cattyreminder.dto.UserDTO;
import com.Cattyreminder.cattyreminder.model.Event;
import com.Cattyreminder.cattyreminder.model.Project;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
public class EventService extends AbstractService<Event, EventDTO> {


    //ALL crud methods in AbstractService

    //LOGIN method

	/*
	public List<UserDTO> getAdminUsersList() {
		return converter.toDTOList((UserRepository)repository.findByUsertype(User.Usertype.ADMIN));
	}
	 */
    public List<EventDTO> getAllByUserAndDate(UserDTO user, LocalDate date) {
        UserConverter userConverter = new UserConverter();
        try{
        return converter.toDTOList(((EventRepository)repository).findByUsersAndDate(userConverter.toEntity(user),date));
    }catch (Exception exception){
        return null;
    }
    }

    public List<EventDTO> getAllByUser(UserDTO user) {
        UserConverter userConverter = new UserConverter();
        try{
        return converter.toDTOList(((EventRepository)repository).findByUsers(userConverter.toEntity(user)));
    }catch (Exception exception){
        return null;
    }

    }
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