package com.Cattyreminder.cattyreminder.dao;

import com.Cattyreminder.cattyreminder.model.Project;
import com.Cattyreminder.cattyreminder.model.Segment;
import com.Cattyreminder.cattyreminder.model.Task;
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
public interface SegmentRepository extends CrudRepository<Segment, Long>{

    List<Segment> findByProject(Project project);

}
