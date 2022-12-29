package com.Cattyreminder.cattyreminder.service;

import com.Cattyreminder.cattyreminder.converter.SegmentConverter;
import com.Cattyreminder.cattyreminder.converter.UserConverter;
import com.Cattyreminder.cattyreminder.dao.TaskRepository;
import com.Cattyreminder.cattyreminder.dao.UserRepository;
import com.Cattyreminder.cattyreminder.dto.SegmentDTO;
import com.Cattyreminder.cattyreminder.dto.TaskDTO;
import com.Cattyreminder.cattyreminder.dto.UserDTO;
import com.Cattyreminder.cattyreminder.model.Segment;
import com.Cattyreminder.cattyreminder.model.Task;
import com.Cattyreminder.cattyreminder.model.User;
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
public class TaskService extends AbstractService<Task, TaskDTO> {



    //ALL crud methods in AbstractService

    //LOGIN method

	/*
	public List<UserDTO> getAdminUsersList() {
		return converter.toDTOList((UserRepository)repository.findByUsertype(User.Usertype.ADMIN));
	}
	 */

    public Iterable<TaskDTO> findByUserAndStart_date(UserDTO user, LocalDate date) {
        UserConverter userConverter = new UserConverter();
        return converter.toDTOList(((TaskRepository)repository).findByUserAndStartDate(userConverter.toEntity(user),date));
    }

    public Iterable<TaskDTO> findByUserAndEnd_date(UserDTO user, LocalDate date) {
        UserConverter userConverter = new UserConverter();

        try{
           List<TaskDTO> TASKS = converter.toDTOList(((TaskRepository)repository).findByUserAndEndDate(userConverter.toEntity(user),date));
            return TASKS;
        }catch (Exception ex){
            System.out.println();
            return null;
        }
    }

    public Iterable<TaskDTO> findBySegment(SegmentDTO segment) {
        SegmentConverter segmentConverter = new SegmentConverter();
        return converter.toDTOList(((TaskRepository)repository).findBySegment(segmentConverter.toEntity(segment)));
    }


    public Iterable<TaskDTO> getAllByUser(UserDTO user) {
        UserConverter userConverter = new UserConverter();
        return converter.toDTOList(((TaskRepository)repository).findByUser(userConverter.toEntity(user)));
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