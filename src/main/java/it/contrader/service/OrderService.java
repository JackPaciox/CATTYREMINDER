package it.contrader.service;

import it.contrader.converter.CenterConverter;
import it.contrader.converter.OrderConverter;
import it.contrader.converter.ProductConverter;
import it.contrader.converter.UserConverter;
import it.contrader.dao.OrderRepository;
import it.contrader.dto.OrderDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService extends AbstractService <Order, OrderDTO>{

    @Autowired
    private OrderConverter converter;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private CenterConverter centerConverter;

    @Autowired
    private ProductConverter productConverter;

    @Autowired
    private OrderRepository repository;

    public List<OrderDTO> findByUser(UserDTO userDTO) {
        return converter.toDTOList(repository.findByUser(userConverter.toEntity(userDTO)));
    }


}
