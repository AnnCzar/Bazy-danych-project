package org.example.demo5;

import entity.UsersEntity;

import java.sql.Connection;
import java.util.List;

public interface IUsersRepository {
    void addUser(UsersEntity userEntity);

    void editUser(UsersEntity usersEntity);

    public List<User> getHistory(String username);
}
