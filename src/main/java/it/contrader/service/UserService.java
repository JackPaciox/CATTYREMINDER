package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.UserConverter;
import it.contrader.dao.UserRepository;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;

import java.util.List;

@Service
public class UserService extends AbstractService<User, UserDTO> {

	@Autowired
	private UserConverter converter;
	@Autowired
	private UserRepository repository;

	public UserDTO findByUsernameAndPassword(String username, String password) {
		return converter.toDTO(repository.findByUsernameAndPassword(username, password));
	}

	public List<UserDTO> getAdminUsersList() {
		return converter.toDTOList(repository.findByUsertype(User.Usertype.ADMIN));
	}

	public Boolean isAdmin(UserDTO user){
		//test output
		return user.getUsertype().equals(User.Usertype.ADMIN);
	}
	public Boolean isSuperadmin(UserDTO user){
		//test output
		return user.getUsertype().equals(User.Usertype.SUPERADMIN);
	}
	@Override
	public List<UserDTO> getAll() {
		return converter.toDTOList(repository.findByUsertypeNot(User.Usertype.SUPERADMIN));
	}
}
