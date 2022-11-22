package it.contrader.converter;

import it.contrader.dto.OrderDTO;
import it.contrader.model.Orders;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vittorio, De Santis
 *
 */
public class OrderConverter {

    /**
     * Crea un oggetto di tipo UserDTO e lo riempie con i campi del parametro user di tipo User.
     * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
     */
    public OrderDTO toDTO(Orders order) {
        OrderDTO orderDTO = new OrderDTO(order.getId(), order.getUser_id(), order.getProduct_id(),order.getCenter_id() ,order.getTitle(), order.getDescription(), order.getPrice(), order.getDiscount(), order.getStart_discount_date(),order.getEnd_discount_date(),order.getOrder_date());
        return orderDTO;
    }

    /**
     * Crea un oggetto di tipo User e lo riempie con i campi del parametro user di tipo UserDTO.
     * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
     */
    public Orders toEntity(OrderDTO orderDTO) {
        Orders order = new Orders(orderDTO.getId(), orderDTO.getUser_id(), orderDTO.getProduct_id(),orderDTO.getCenter_id(), orderDTO.getTitle(),orderDTO.getDescription(),orderDTO.getPrice(),orderDTO.getDiscount(),orderDTO.getStart_discount_date(),orderDTO.getEnd_discount_date(),orderDTO.getOrder_date());
        return order;
    }

    /**
     * Metodo per convertire le liste di User.
     */
    public List<OrderDTO> toDTOList(List<Orders> orderList) {
        //Crea una lista vuota.
        List<OrderDTO> orderDTOList = new ArrayList<OrderDTO>();

        //Cicla tutti gli elementi della lista e li converte uno a uno
        for(Orders order : orderList) {
            //Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
            //e lo aggiunge adda lista di DTO
            orderDTOList.add(toDTO(order));
        }
        return orderDTOList;
    }



}
