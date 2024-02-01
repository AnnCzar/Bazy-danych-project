package org.example.demo5;

import entity.IUserRepository;
import entity.UsersEntity;
public class UserService implements Users {
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user) {
        userRepository.addUser(user);
    }

    @Override
    public void editUser(User user) {
        // Implement the editUser logic if needed
    }


    private User mapUsersEntityToUser(UsersEntity usersEntity) {
        if (usersEntity == null) {
            return null;
        }
        return new User(UsersEntity.getUserName(), UsersEntity.getSex(), usersEntity.getWeight(), usersEntity.getHeight(), usersEntity.getAge(), usersEntity.getAvgActivity(), usersEntity.getGoal());
    }

    private static UsersEntity mapUserToUsersEntity(User user) {
        var userEntity = new UsersEntity();
        userEntity.setUserName(user.getUserName());
        userEntity.setSex(user.getSex());
        userEntity.setWeight(user.getWeight());
        userEntity.setHeight(user.getHeight());
        userEntity.setAge(user.getAge());
        userEntity.setAvgActivity(user.getAvgActivity());
        userEntity.setGoal(user.getGoal());
        userEntity.setDailyConsumptionsByUserName(user.getDailyConsumptionsByUserName());
        return userEntity;
    }
}
// tu kontrola wyjatkow co do nazwy uzytkownika