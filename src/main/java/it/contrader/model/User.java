package it.contrader.model;

import javax.persistence.*;

import it.contrader.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User extends UserDTO {

	public enum Usertype {
		ADMIN, USER, SUPERADMIN
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	protected List<Center> centers;

	@OneToMany(mappedBy = "user", cascade = CascadeType.REFRESH)
	protected List<Order> orders;
}
