package it.contrader.dao;
import it.contrader.dto.OrderDTO;
import it.contrader.model.Center;
import it.contrader.model.Orders;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.utils.UserSingleton;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vittorio
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class OrderDAO {
    private final String QUERY_ALL_ADMIN = "SELECT * FROM orders WHERE center_id=?";

    private final String QUERY_ALL = "SELECT * FROM orders";

    private final String QUERY_ALL_OF_USER = "SELECT * FROM orders WHERE user_id=?";
    private final String QUERY_CREATE = "INSERT INTO orders (" +
            "user_id, " +
            "product_id, " +
            "center_id," +
            "title," +
            "description," +
            "price," +
            "discount," +
            "start_discount_date," +
            "end_discount_date," +
            "order_date)" +
            " VALUES (?,?,?,?,?,?,?,?,?,?)";
    public OrderDAO() {

    }

    public List<Orders> getAll() {
        List<Orders> ordersList = new ArrayList<Orders>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY_ALL);
            Orders order;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int user_id = Integer.parseInt(resultSet.getString("user_id"));
                int product_id = Integer.parseInt(resultSet.getString("product_id"));
                int center_id = Integer.parseInt(resultSet.getString("center_id"));
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                Float price = Float.valueOf(resultSet.getString("price"));
                Float discount = Float.valueOf(resultSet.getString("discount"));
                //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String start_discount_date = resultSet.getString("start_discount_date");
                String end_discount_date = resultSet.getString("end_discount_date");
                String order_date = resultSet.getString("order_date");
                System.out.println(String.valueOf(end_discount_date));
                order = new Orders(user_id, product_id,center_id, title,description, price, discount,start_discount_date, end_discount_date, order_date);
                order.setId(id);
                ordersList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ordersList;
    }

    public List<Orders> getAllOfUser() {
        List<Orders> ordersList = new ArrayList<Orders>();
        UserSingleton User = UserSingleton.getInstance();
        int User_id = User.getId();
        Connection connection = ConnectionSingleton.getInstance();
        try {
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ALL_OF_USER);
            preparedStatement.setInt(1, User_id);
            ResultSet resultSet = statement.executeQuery(QUERY_ALL_OF_USER);
            Orders order;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int user_id = Integer.parseInt(resultSet.getString("user_id"));
                int product_id = Integer.parseInt(resultSet.getString("product_id"));
                int center_id = Integer.parseInt(resultSet.getString("center_id"));
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                Float price = Float.valueOf(resultSet.getString("price"));
                Float discount = Float.valueOf(resultSet.getString("discount"));
                String start_discount_date = resultSet.getString("start_discount_date");
                String end_discount_date = resultSet.getString("end_discount_date");
                String order_date = resultSet.getString("order_date");
                order = new Orders(user_id, product_id,center_id, title,description, price, discount,start_discount_date, end_discount_date, order_date);
                order.setId(id);
                ordersList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ordersList;
    }
    public boolean insert(Orders orderToInsert) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
            preparedStatement.setInt(1, orderToInsert.getUser_id());
            preparedStatement.setInt(3, orderToInsert.getCenter_id());
            preparedStatement.setInt(2, orderToInsert.getProduct_id());
            preparedStatement.setString(4, orderToInsert.getTitle());
            preparedStatement.setString(5, orderToInsert.getDescription());
            preparedStatement.setFloat(6, orderToInsert.getPrice());
            preparedStatement.setFloat(7, orderToInsert.getDiscount());
            //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            preparedStatement.setString(8, orderToInsert.getStart_discount_date());
            preparedStatement.setString(9, orderToInsert.getEnd_discount_date());
            preparedStatement.setString(10, orderToInsert.getOrder_date());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }

    }

    public List<Orders> getAllAdmin(int id) {
        List<Orders> ordersList = new ArrayList<Orders>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ALL_ADMIN);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Orders order;
            while (resultSet.next()) {
                int user_id = Integer.parseInt(resultSet.getString("user_id"));
                int product_id = Integer.parseInt(resultSet.getString("product_id"));
                int center_id = Integer.parseInt(resultSet.getString("center_id"));
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                Float price = Float.valueOf(resultSet.getString("price"));
                Float discount = Float.valueOf(resultSet.getString("discount"));
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String start_discount_date = resultSet.getString("start_discount_date");
                String end_discount_date = resultSet.getString("end_discount_date");
                String order_date = resultSet.getString("order_date");
                order = new Orders(user_id, product_id,center_id, title,description, price, discount,start_discount_date, end_discount_date, order_date);
                order.setId(id);
                ordersList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ordersList;
    }

}

