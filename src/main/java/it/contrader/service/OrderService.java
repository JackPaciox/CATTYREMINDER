package it.contrader.service;

import it.contrader.converter.CenterConverter;
import it.contrader.converter.OrderConverter;
import it.contrader.dao.CenterDAO;
import it.contrader.dao.OrderDAO;
import it.contrader.dto.OrderDTO;
import it.contrader.model.Orders;

import java.util.List;

/**
 *
 * @author Vittorio, De Santis
 *
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class OrderService extends AbstractService<Orders, OrderDTO> {

    private OrderDAO orderDAO;
    private OrderConverter orderConverter;

    //Istanzio DAO  e Converter specifici.
    public OrderService(){
        this.orderDAO = new OrderDAO();
        this.orderConverter = new OrderConverter();
    }

    public List<OrderDTO> getAllFromCenter(int id) {
        // Ottiene una lista di entità e le restituisce convertendole in DTO
        return orderConverter.toDTOList(orderDAO.getAllAdmin(id));
    }
    public List<OrderDTO> getAll() {
        // Ottiene una lista di entità e le restituisce convertendole in DTO
        return orderConverter.toDTOList(orderDAO.getAll());
    }
    public List<OrderDTO> getAllOfUser() {
        // Ottiene una lista di entità e le restituisce convertendole in DTO
        return orderConverter.toDTOList(orderDAO.getAll());
    }

    public boolean insert(OrderDTO dto) {
        // Converte un DTO in entità e lo passa al DAO per l'inserimento
        return orderDAO.insert(orderConverter.toEntity(dto));
    }


    public List<OrderDTO> getAllOfOrder(int id) {
        OrderDAO orderdao = new OrderDAO();
        OrderConverter orderConverter = new OrderConverter();
        return orderConverter.toDTOList(orderdao.getAllAdmin(id));
    }

}

