package it.contrader.dao;

import it.contrader.dto.UserDTO;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.utils.UserSingleton;
import it.contrader.model.Center;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Vittorio
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class CenterDAO implements DAO<Center> {

    private final String QUERY_ALL = "SELECT * FROM centers ";
    private final String QUERY_ALL_MAIN = "SELECT * FROM centers WHERE user_id <> ?";

    private final String QUERY_ADMIN_ALL = "SELECT * FROM centers WHERE user_id =?";
    private final String QUERY_CREATE = "INSERT INTO centers (user_id, centername, centeraddress, centercity, centerprovince) VALUES (?,?,?,?,?)";
    private final String QUERY_READ = "SELECT * FROM centers WHERE id=?";
    private final String QUERY_UPDATE = "UPDATE centers SET centername=?, centeraddress=?, centercity=?, centerprovince=?  WHERE id=? AND user_id=?";
    private final String QUERY_DELETE = "DELETE FROM centers WHERE id=?";

    public CenterDAO() {

    }
    public List<Center> getAll() {
        List<Center> CentersList = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY_ALL);
            Center Center;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String centername = resultSet.getString("centername");
                String centeraddress = resultSet.getString("centeraddress");
                String centercity = resultSet.getString("centercity");
                String centerprovince = resultSet.getString("centerprovince");
                Center = new Center(id, centername, centeraddress, centercity, centerprovince);
                Center.setId(id);
                CentersList.add(Center);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return CentersList;
    }

    public List<Center> getAllMain(int user_id) {
        List<Center> CentersList = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
            Statement statement = connection.createStatement();
            PreparedStatement resultSet = connection.prepareStatement(QUERY_ALL_MAIN);
            resultSet.setInt(1,user_id);
            ResultSet resultSet_executed = resultSet.executeQuery();
            Center Center;
            while (resultSet_executed.next()) {
                int id = resultSet_executed.getInt("id");
                String centername = resultSet_executed.getString("centername");
                String centeraddress = resultSet_executed.getString("centeraddress");
                String centercity = resultSet_executed.getString("centercity");
                String centerprovince = resultSet_executed.getString("centerprovince");
                Center = new Center(id, centername, centeraddress, centercity, centerprovince);
                Center.setId(id);
                CentersList.add(Center);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return CentersList;

    }
    public List<Center> getAllAdmin(int user_id_lister) {
        List<Center> CentersList = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
            Statement statement = connection.createStatement();
            PreparedStatement resultSet = connection.prepareStatement(QUERY_ADMIN_ALL);
            resultSet.setInt(1,user_id_lister);
            ResultSet resultSet_executed = resultSet.executeQuery();
            Center Center;
            while (resultSet_executed.next()) {
                int id = resultSet_executed.getInt("id");
                String centername = resultSet_executed.getString("centername");
                String centeraddress = resultSet_executed.getString("centeraddress");
                String centercity = resultSet_executed.getString("centercity");
                String centerprovince = resultSet_executed.getString("centerprovince");
                Center = new Center(id, centername, centeraddress, centercity, centerprovince);
                Center.setId(id);
                CentersList.add(Center);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return CentersList;

    }

    public boolean insert(Center CenterToInsert) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
            preparedStatement.setInt(1, CenterToInsert.getUser_id());
            preparedStatement.setString(2, CenterToInsert.getCentername());
            preparedStatement.setString(3, CenterToInsert.getCenteraddress());
            preparedStatement.setString(4, CenterToInsert.getCentercity());
            preparedStatement.setString(5, CenterToInsert.getCenterprovince());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }

    }

    public Center read(int CenterId) {
        Connection connection = ConnectionSingleton.getInstance();
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
            preparedStatement.setInt(1, CenterId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int user_id;
            String centername, centeraddress, centercity, centerprovince;

            user_id = resultSet.getInt("user_id");
            centername = resultSet.getString("centername");
            centeraddress = resultSet.getString("centeraddress");
            centercity = resultSet.getString("centercity");
            centerprovince = resultSet.getString("centerprovince");
            Center Center = new Center(user_id,centername, centeraddress, centercity, centerprovince);
            Center.setId(resultSet.getInt("id"));

            return Center;
        } catch (SQLException e) {
            return null;
        }

    }

    public boolean update(Center CenterToUpdate) {
        Connection connection = ConnectionSingleton.getInstance();

        // Check if id is present
        if (CenterToUpdate.getId() == 0)
            return false;

        Center CenterRead = read(CenterToUpdate.getId());
        if (!CenterRead.equals(CenterToUpdate)) {
            try {
                // Fill the CenterToUpdate object
                if (CenterToUpdate.getCentername() == null || CenterToUpdate.getCentername().equals("")) {
                    CenterToUpdate.setCentername(CenterRead.getCentername());
                }

                if (CenterToUpdate.getCenteraddress() == null || CenterToUpdate.getCenteraddress().equals("")) {
                    CenterToUpdate.setCenteraddress(CenterRead.getCenteraddress());
                }

                if (CenterToUpdate.getCentercity() == null || CenterToUpdate.getCentercity().equals("")) {
                    CenterToUpdate.setCentercity(CenterRead.getCentercity());
                }

                if (CenterToUpdate.getCenterprovince() == null || CenterToUpdate.getCenterprovince().equals("")) {
                    CenterToUpdate.setCenterprovince(CenterRead.getCenterprovince());
                }

                // Update the Center
                PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
                preparedStatement.setString(1, CenterToUpdate.getCentername());
                preparedStatement.setString(2, CenterToUpdate.getCenteraddress());
                preparedStatement.setString(3, CenterToUpdate.getCentercity());
                preparedStatement.setString(4, CenterToUpdate.getCenterprovince());
                preparedStatement.setInt(5, CenterToUpdate.getId());
                preparedStatement.setInt(6, CenterToUpdate.getUser_id());
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
