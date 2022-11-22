package it.contrader.dao;

import it.contrader.model.Order;
import it.contrader.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findByUser(User user);

}
