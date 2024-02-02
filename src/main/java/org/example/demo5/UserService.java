package org.example.demo5;

import entity.UsersEntity;

public class UserService implements IUsersService {
    private final IUsersRepository userRepository;

    public UserService(IUsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user) {
        userRepository.addUser(user);
    }

    @Override
    public void editUser(User user) {
        // Implement the editUser logic if needed
    }
//
//    @Override
//    public List<UsersEntity> getHistory() {
//        return null;
//    }


//    @Override
//    public List<User> getHistory() {
//        return IUserRepository.getHistory().stream().map(this::mapUsersEntityToUser).collect(Collectors.toList());
//    }

    private User mapUsersEntityToUser(UsersEntity usersEntity) {
        if (usersEntity == null) {
            return null;
        }
        return new User(usersEntity.getUserName(), usersEntity.getSex(), usersEntity.getWeight(), usersEntity.getHeight(), usersEntity.getAge(), usersEntity.getAvgActivity(), usersEntity.getGoal());
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
        return userEntity;
    }
}
// tu kontrola wyjatkow co do nazwy uzytkownika