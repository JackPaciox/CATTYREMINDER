package it.contrader.dto;

import it.contrader.model.Center;
import it.contrader.model.Product;
import it.contrader.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private long id;

    private String title;

    private String description;

    private float price;

    private float discount;

    private LocalDate startDiscountDate;

    private LocalDate endDiscountDate;

    private LocalDate orderDate;

    private User user;

    private Center center;

    private Product product;

}
