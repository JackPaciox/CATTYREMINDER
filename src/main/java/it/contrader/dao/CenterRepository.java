package it.contrader.dao;

import javax.transaction.Transactional;

import it.contrader.dto.UserDTO;
import it.contrader.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Center;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface CenterRepository extends CrudRepository<Center, Long> {

    //@Query("SELECT * from center where center.city=?1 and center.address=?2")
    //List<Center> findByCity(String city, String address);

    List<Center> findByUser(User user);

    List<Center> findByUserNot(User user);

}

