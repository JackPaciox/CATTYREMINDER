package com.Cattyreminder.cattyreminder.dao;

import com.Cattyreminder.cattyreminder.model.Segment;
import com.Cattyreminder.cattyreminder.model.Task;
import com.Cattyreminder.cattyreminder.model.User;
import com.Cattyreminder.cattyreminder.model.User.Usertype;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

/**
 * Estende CrudRepository ed eredita tutti i metodi di CRUD.
 * Definisce il metodo di login.
 *
 * @author Vittorio Valent & Girolamo Murdaca
 *
 * @see CrudRepository
 *
 */

@Repository
@Transactional
public interface TaskRepository extends CrudRepository<Task, Long>{

    List<Task> findByUser(User user);

    List<Task> findByUserAndEndDate(User user,LocalDate date);

    List<Task> findByUserAndStartDate(User user, LocalDate date);

    List<Task> findBySegment(Segment segment);

}
