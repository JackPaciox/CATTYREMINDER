package it.contrader.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.User;

/**
 * 
 * @author Vittorio
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class LoginDAO {

	private final String QUERY_LOGIN = "SELECT * FROM user WHERE username = ? AND password = ?";

	
	public User login (String username, String password) {

		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);
			
			statement.setString(1, username);
			statement.setString(2, password);

			
			ResultSet resultSet;
			
			if(statement.executeQuery().next()) {
				resultSet = statement.executeQuery();
				resultSet.next();
				String usertype = resultSet.getString("usertype");
				String firstname = resultSet.getString("firstname");
				String lastname = resultSet.getString("lastname");
				String address = resultSet.getString("address");
				String city = resultSet.getString("city");
				String province = resultSet.getString("province");
				String zipcode = resultSet.getString("zipcode");
				String email = resultSet.getString("email");
				String phone = resultSet.getString("phone");

				int id = resultSet.getInt("id");
				User user = new User(id, username, password, usertype,firstname,lastname,address,zipcode,city,province,email,phone);
				
				return user;
			}

			return null;
		}
		
		catch (SQLException e) {
			
			return null;
		}
	}
}
