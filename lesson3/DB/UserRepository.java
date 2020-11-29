package part3.lesson3.DB;

import part3.lesson3.AuthService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserRepository implements AuthService {

    public User findUserByEmailAndPassword(String email, String password){
        Connection connection = DataSource.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM users.users WHERE email = ? AND password = ?"
            );
            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet rs = statement.executeQuery();
            if (rs.next()){
                return new User(
                        rs.getInt("id"),
                        rs.getString("nickname"),
                        rs.getString("email"),
                        rs.getString("password")
                );
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("SWW during user fetch", e);
        } finally {
            DataSource.close(connection);
        }

    }

    @Override
    public void start() {
        System.out.println("The authentication service is started");
    }

    @Override
    public String getNickByLoginPass(String email, String pass) {
        Connection connection = DataSource.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM users.users WHERE email = ? AND password = ?"
            );
            statement.setString(1, email);
            statement.setString(2, pass);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                return resultSet.getString("nickname");
            }
        } catch (SQLException e) {
            throw new RuntimeException("SWW during getting nick", e);
        }

        return null;
    }

    public int save (User user) {
        Connection connection = DataSource.getConnection();

        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO users.users (email, password, nickname) VALUES (?, ?, ?) "
            );
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getPassword());

            int val = statement.executeUpdate();
            connection.commit();
            return val;

        } catch (SQLException e) {
            DataSource.rollback(connection);
            throw new RuntimeException("SWW during saving user", e);
        }finally {
            DataSource.close(connection);
        }
    }

    public void changeNick(String oldNick, String newNick){
        Connection connection = DataSource.getConnection();
        ArrayList <Integer> list = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM users.users WHERE nickname = ?"
            );
            statement.setString(1, oldNick);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                list.add(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("SWW during changing nick", e);
        }

        try{
            PreparedStatement st = connection.prepareStatement(
                    "UPDATE users.users SET nickname = ? WHERE id = ?"
            );
            for (int i = 0; i < list.size(); i++) {
                System.out.println("id is: " + list.get(i));
                st.setString(1, newNick);
                st.setInt(2, list.get(i));
                st.executeUpdate();
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void stop() {
        System.out.println("The authentication service is stopped");
    }
}
