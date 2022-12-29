package com.Cattyreminder.cattyreminder.service;

import com.Cattyreminder.cattyreminder.converter.ProjectConverter;
import com.Cattyreminder.cattyreminder.converter.UserConverter;
import com.Cattyreminder.cattyreminder.dao.ProjectRepository;
import com.Cattyreminder.cattyreminder.dao.SegmentRepository;
import com.Cattyreminder.cattyreminder.dto.ProjectDTO;
import com.Cattyreminder.cattyreminder.dto.SegmentDTO;
import com.Cattyreminder.cattyreminder.dto.UserDTO;
import com.Cattyreminder.cattyreminder.model.Project;
import com.Cattyreminder.cattyreminder.model.Segment;
import org.springframework.stereotype.Service;

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
public class ProjectService extends AbstractService<Project, ProjectDTO> {


    //ALL crud methods in AbstractService

    //LOGIN method

	/*
	public List<UserDTO> getAdminUsersList() {
		return converter.toDTOList((UserRepository)repository.findByUsertype(User.Usertype.ADMIN));
	}
	 */


    public List<ProjectDTO> getAllByUser(UserDTO user) {
        UserConverter userConverter = new UserConverter();

        try{
        return converter.toDTOList(((ProjectRepository)repository).findByUser(userConverter.toEntity(user)));
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