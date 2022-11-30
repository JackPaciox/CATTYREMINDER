package com.Cattyreminder.cattyreminder.dao;

import com.Cattyreminder.cattyreminder.model.User.Usertype;

import com.Cattyreminder.cattyreminder.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
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
public interface UserRepository extends CrudRepository<User, Long>{

    User findByUsernameAndPassword(String username, String password);

    boolean existsByUsernameAndPassword(String username, String password);

    List<User> findByUsertype(Usertype usertype);

    List<User> findByUsertypeNot(Usertype usertype);

}
