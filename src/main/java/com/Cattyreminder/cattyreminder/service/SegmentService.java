package com.Cattyreminder.cattyreminder.service;

import com.Cattyreminder.cattyreminder.converter.ProjectConverter;
import com.Cattyreminder.cattyreminder.converter.UserConverter;
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
public class SegmentService extends AbstractService<Segment, SegmentDTO> {


    //ALL crud methods in AbstractService

    //LOGIN method

	/*
	public List<UserDTO> getAdminUsersList() {
		return converter.toDTOList((UserRepository)repository.findByUsertype(User.Usertype.ADMIN));
	}
	 */

    public List<SegmentDTO> getAllByProject(ProjectDTO projectDTO) {
        ProjectConverter projectConverter = new ProjectConverter();
        return converter.toDTOList(((SegmentRepository)repository).findByProject(projectConverter.toEntity(projectDTO)));
    }

//    public List<SegmentDTO> getAllByUser(UserDTO user) {
//        UserConverter userConverter = new UserConverter();
//        return converter.toDTOList(((SegmentRepository)repository).findByUser(userConverter.toEntity(user)));
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