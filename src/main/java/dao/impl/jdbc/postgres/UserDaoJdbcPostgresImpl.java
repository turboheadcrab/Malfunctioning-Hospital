package dao.impl.jdbc.postgres;

import dao.UserDao;
import model.User;

import java.sql.*;
import java.util.List;

/**
 * Created by Apraxin Vladimir on 16.12.16.
 */
public class UserDaoJdbcPostgresImpl implements UserDao {

    static final String JDBC_DRIVER = "";
    static final String DB_URL = "jdbc:postgresql://localhost/hospital";

    static final String USERNAME = "hospital_admin";
    static final String PASSWORD = "69228322";

    @Override
    public void addUser(String username) {

        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUser(String username) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void setUser(String username) {

    }

    @Override
    public void deleteUser(String username) {

    }
}
