package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.UserDTO;

import it.contrader.model.User;

@Component
public class UserConverter extends AbstractConverter<User, UserDTO> {

	@Autowired
	private CenterConverter centerConverter;

	@Override
	public User toEntity(UserDTO userDTO) {
		User user = null;
		if (userDTO != null) {
			user = new User(userDTO.getId(), userDTO.getUsername(), userDTO.getPassword(), userDTO.getUsertype(), userDTO.getFirstname(), userDTO.getLastname(), userDTO.getAddress(), userDTO.getZipcode(), userDTO.getCity(), userDTO.getProvince(), userDTO.getEmail(), userDTO.getPhone(), userDTO.getCenters(), userDTO.getOrders());
		}
		return user;
	}

	@Override
	public UserDTO toDTO(User user) {
		UserDTO userDTO = null;
		if (user != null) {
			userDTO = new UserDTO(user.getId(), user.getUsername(), user.getPassword(), user.getUsertype(), user.getFirstname(), user.getLastname(), user.getAddress(), user.getZipcode(), user.getCity(), user.getProvince(), user.getEmail(), user.getPhone(), user.getCenters(), user.getOrders());

		}
		return userDTO;
	}
}