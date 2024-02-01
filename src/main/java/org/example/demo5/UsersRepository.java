package org.example.demo5;

import entity.UsersEntity;
import jakarta.persistence.EntityManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersRepository implements IUsersRepository {
    private final EntityManager entityManager;
    private Connection connection;

    public UsersRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public void addUser(UsersEntity usersEntity) {
        var transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(usersEntity);
        transaction.commit();
    }

    @Override
    public void editUser(UsersEntity usersEntity) {
        var Query = "CREATE TRIGGER after_update_users " +
                "AFTER UPDATE ON users" +
                "FOR EACH ROW" +
                "BEGIN " +
                "INSERT INTO archive()";

    }

    @Override
    public List<User> getHistory( String username) {
        List<User> userList = new ArrayList<>();
        var query = "SELECT * FROM archive WHERE user_name = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            // Set the parameter (username) for the PreparedStatement
            preparedStatement.setString(1, username);

            // Execute the query and get the result set
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                // Process the result set and populate the userList
                while (resultSet.next()) {
                    // Assuming User has appropriate constructor and setters
                    User user = new User(
                            resultSet.getString("user_name"),
                            resultSet.getString("sex"),
                            resultSet.getDouble("weight"),
                            resultSet.getDouble("height"),
                            resultSet.getInt("age"),
                            resultSet.getString("avg_activity"),
                            resultSet.getString("goal")
                    );
                    userList.add(user);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any exceptions specific to database access
        }
        return userList;
    }


}
