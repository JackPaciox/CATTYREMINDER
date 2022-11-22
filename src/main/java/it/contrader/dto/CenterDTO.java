package it.contrader.dto;

import it.contrader.model.Product;
import it.contrader.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CenterDTO {
    private Long id;

    private String name;

    private String description;

    private String address;

    private String zipcode;

    private String city;

    private String province;

    private String phone;

    private String email;

    private String webSite;

    private UserDTO user;

    private List<Product> products;
}
