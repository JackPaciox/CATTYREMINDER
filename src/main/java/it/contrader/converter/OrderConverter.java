package it.contrader.converter;

import it.contrader.dto.OrderDTO;
import it.contrader.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter extends AbstractConverter <Order,OrderDTO> {

    @Autowired
    private UserConverter userConverter;
    @Autowired
    private ProductConverter productConverter;
    @Autowired
    private CenterConverter centerConverter;

    @Override
    public Order toEntity(OrderDTO orderDTO) {
        Order order = null;
        if (orderDTO != null) {
            order = new Order(orderDTO.getId(), orderDTO.getTitle(), orderDTO.getDescription(), orderDTO.getPrice(), orderDTO.getDiscount(), orderDTO.getStartDiscountDate(), orderDTO.getEndDiscountDate(), orderDTO.getOrderDate(),orderDTO.getUser(),orderDTO.getCenter(),orderDTO.getProduct());
        }
        return order;
    }

    @Override
    public OrderDTO toDTO(Order order) {
        OrderDTO orderDTO = null;
        if (order != null) {
            orderDTO = new OrderDTO(order.getId(), order.getTitle(), order.getDescription(), order.getPrice(), order.getDiscount(), order.getStartDiscountDate(), order.getEndDiscountDate(), order.getOrderDate(),order.getUser(),order.getCenter(),order.getProduct());
        }
        return orderDTO;
    }

}
