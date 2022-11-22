package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.User;

import java.util.List;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsernameAndPassword(String username, String password);

	List<User> findByUsertype(User.Usertype usertype);

	List<User> findByUsertypeNot(User.Usertype usertype);

}
