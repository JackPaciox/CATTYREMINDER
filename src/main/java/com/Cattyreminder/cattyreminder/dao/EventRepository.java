package com.Cattyreminder.cattyreminder.dao;

import com.Cattyreminder.cattyreminder.model.Event;
import com.Cattyreminder.cattyreminder.model.Project;
import com.Cattyreminder.cattyreminder.model.User;
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
public interface EventRepository extends CrudRepository<Event, Long>{

    List<Event> findByUsers(User users);

    List<Event> findByUsersAndDate(User users, LocalDate data);


}
