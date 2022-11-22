package it.contrader.dto;

import it.contrader.model.Center;
import it.contrader.model.Order;
import it.contrader.model.User.Usertype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {

	private Long id;

	private String username;

	private String password;

	private Usertype usertype;

	private String firstname;

	private String lastname;

	private String address;

	private String zipcode;

	private String city;

	private String province;

	private String email;

	private String phone;

	private List<Center> centers;

	private List<Order> orders;

}
