package data.dao;

import config.DataBaseConnector;
import data.entity.User;
import data.service.UserLoginServiceModel;
import query.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    private final DataBaseConnector connector = new DataBaseConnector();

    @Override
    public void register(User user) {

        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(Query.INSERT_USER)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public User selectUserByUsername(String username) {
        User user = null;
        try (Connection connection = connector.getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(Query.SELECT_USER_BY_USERNAME)) {
            preparedStatement.setString(1, username);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String password = rs.getString("password");
                String email = rs.getString("email");
                user = new User(id, username, password, email);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }




    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
