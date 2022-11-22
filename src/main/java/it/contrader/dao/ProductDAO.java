package it.contrader.dao;

import it.contrader.model.Product;
import it.contrader.model.User;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.utils.UserSingleton;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements DAO<Product> {

	private final String QUERY_ALL = "SELECT * FROM products";

	private final String QUERY_ALL_BY_DELETED = "SELECT * FROM products WHERE deleted = 0";
	private final String QUERY_ALL_BY_OFFERS ="SELECT * FROM products WHERE deleted = 0 AND (discount IS NOT NULL OR discount <> 0)";
	private final String QUERY_ALL_BY_DATA ="SELECT * FROM products WHERE deleted = 0 ORDER BY updated_at DESC";
	private final String QUERY_ALL_BY_PRICE ="SELECT * FROM products WHERE deleted = 0 ORDER BY price";
	private final String QUERY_CREATE = "INSERT INTO products (center_id, title, description, price, discount, start_discount_date, end_discount_date, deleted) VALUES (?,?,?,?,?,?,?,0)";
	private final String QUERY_READ ="SELECT * FROM products WHERE id=? AND deleted = 0";
	private final String QUERY_FROM_CENTER = "SELECT * FROM products WHERE center_id=? AND deleted = 0";
	private final String QUERY_UPDATE = "UPDATE products SET center_id=?, title=?, description=?, price=?, discount=?, start_discount_date=?, end_discount_date=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM products WHERE id=?";


	public ProductDAO () {

	}
	public List<Product> getAllProductNotDeleted(){
		List<Product> productsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			//need to review this part of code...
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ALL_BY_DELETED);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				String description = resultSet.getString("description");
				float price = resultSet.getFloat("price");
				float discount = resultSet.getFloat("discount");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				String start_discount_at = resultSet.getString("start_discount_date");
				String end_discount_at = resultSet.getString("end_discount_date");
				Product product = new Product(id, resultSet.getInt("center_id"), title, description, price, discount, start_discount_at, end_discount_at);
				product.setId(id);
				productsList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return productsList;
	}


	public List<Product> getAllProductBySelectedCenter(int center_id) {
		List<Product> productsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			//need to review this part of code...
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_FROM_CENTER);
			preparedStatement.setInt(1, center_id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				String description = resultSet.getString("description");
				float price = resultSet.getFloat("price");
				float discount = resultSet.getFloat("discount");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				String start_discount_at = resultSet.getString("start_discount_date");
				String end_discount_at = resultSet.getString("end_discount_date");
				Product product = new Product(id, resultSet.getInt("center_id"), title, description, price, discount, start_discount_at, end_discount_at);
				product.setId(id);
				productsList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return productsList;
	}

	public List<Product> getAll_By_OFFERS() {
		List<Product> productsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL_BY_OFFERS);
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				int center_id = resultSet.getInt("center_id");
				String title = resultSet.getString("title");
				String description = resultSet.getString("description");
				float price = resultSet.getFloat("price");
				float discount = resultSet.getFloat("discount");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				String start_discount_at = resultSet.getString("start_discount_date");
				String end_discount_at = resultSet.getString("end_discount_date");
				Product product = new Product(id, center_id, title, description, price, discount, start_discount_at, end_discount_at);
				product.setId(id);
				productsList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productsList;
	}
	public List<Product> getAll() {
		List<Product> productsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				int center_id = resultSet.getInt("center_id");
				String title = resultSet.getString("title");
				String description = resultSet.getString("description");
				float price = resultSet.getFloat("price");
				float discount = resultSet.getFloat("discount");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				String start_discount_at = resultSet.getString("start_discount_date");
				String end_discount_at = resultSet.getString("end_discount_date");
				Product product = new Product(center_id, title, description, price, discount, start_discount_at, end_discount_at);
				product.setId(id);
				productsList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productsList;
	}
	public List<Product> getAll_By_PRICE() {
		List<Product> productsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL_BY_PRICE);
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				int center_id = resultSet.getInt("center_id");
				String title = resultSet.getString("title");
				String description = resultSet.getString("description");
				float price = resultSet.getFloat("price");
				float discount = resultSet.getFloat("discount");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				String start_discount_at = resultSet.getString("start_discount_date");
				String end_discount_at =resultSet.getString("end_discount_date");
				Product product = new Product(id, title, description, price, discount, start_discount_at, end_discount_at);
				product.setId(id);
				productsList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productsList;
	}
	public List<Product> getAll_By_DATA() {
		List<Product> productsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL_BY_DATA);
			User user;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				int center_id = resultSet.getInt("center_id");
				String title = resultSet.getString("title");
				String description = resultSet.getString("description");
				float price = resultSet.getFloat("price");
				float discount = resultSet.getFloat("discount");
				String start_discount_at = resultSet.getString("start_discount_date");
				String end_discount_at = resultSet.getString("end_discount_date");
				Product product = new Product(id,center_id, title, description, price, discount, start_discount_at, end_discount_at);
				product.setId(id);
				productsList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productsList;
	}

	public boolean insert(Product productToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1, productToInsert.getCenter_id());
			preparedStatement.setString(2, productToInsert.getTitle());
			preparedStatement.setString(3, productToInsert.getDescription());
			preparedStatement.setFloat(4, productToInsert.getPrice());
			preparedStatement.setFloat(5, productToInsert.getDiscount());
			//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			preparedStatement.setString(6, productToInsert.getStart_discount_date());
			preparedStatement.setString(7, productToInsert.getEnd_discount_date());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Product read(int productId) {
		try {
			Connection connection = ConnectionSingleton.getInstance();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, productId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int center_id;
			String title, description, start_date_at, end_date_at;
			float price, discount;
			int id = resultSet.getInt("id");
			center_id = resultSet.getInt("center_id");
			title = resultSet.getString("title");
			description = resultSet.getString("description");
			price = resultSet.getFloat("price");
			discount = resultSet.getFloat("discount");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			start_date_at = resultSet.getString("start_discount_date");
			end_date_at = resultSet.getString("end_discount_date");
			Product product = new Product(
					id,
					center_id,
					title,
					description,
					price,
					discount,
					start_date_at,
					end_date_at
			);
			product.setId(resultSet.getInt("id"));

			return product;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public boolean update(Product productToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (productToUpdate.getId() == 0)
			return false;

		Product productRead = read(productToUpdate.getId());
		if (!productRead.equals(productToUpdate)) {
			try {
				// Fill the productToUpdate object
				if (productToUpdate.getCenter_id() == 0) {
					productToUpdate.setCenter_id(productRead.getCenter_id());
				}

				if (productToUpdate.getTitle() == null || productToUpdate.getTitle().equals("")) {
					productToUpdate.setTitle(productRead.getTitle());
				}

				if (productToUpdate.getDescription() == null || productToUpdate.getDescription().equals("")) {
					productToUpdate.setDescription(productRead.getDescription());
				}

				if (productToUpdate.getPrice() == 0) {
					productToUpdate.setPrice(productRead.getPrice());
				}

				if (productToUpdate.getDiscount() == 0) {
					productToUpdate.setDiscount(productRead.getDiscount());
				}
				if (productToUpdate.getStart_discount_date() == null || productToUpdate.getStart_discount_date().equals("")) {
					productToUpdate.setStart_discount_date(productRead.getStart_discount_date());
				}

				if (productToUpdate.getEnd_discount_date() == null || productToUpdate.getEnd_discount_date().equals("")) {
					productToUpdate.setEnd_discount_date(productRead.getEnd_discount_date());
				}

				// Update the product
				PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, productToUpdate.getCenter_id());
				preparedStatement.setString(2, productToUpdate.getTitle());
				preparedStatement.setString(3, productToUpdate.getDescription());
				preparedStatement.setFloat(4, productToUpdate.getPrice());
				preparedStatement.setFloat(5, productToUpdate.getDiscount());
				preparedStatement.setString(6, productToUpdate.getStart_discount_date());
				preparedStatement.setString(7, productToUpdate.getEnd_discount_date());
				preparedStatement.setInt(8, productToUpdate.getId());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}

		return false;

	}

	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
			System.out.println(e);
		}
		return false;
	}


}
