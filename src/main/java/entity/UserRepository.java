package entity;

import jakarta.persistence.EntityManager;
import org.example.demo5.User;

public class UserRepository implements IUserRepository {

    private final EntityManager entityManager;

    public UserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addUser(User u) {
        var transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(u);

        transaction.commit();

    }
    @Override
    public void editUser(UsersEntity user) {
        var transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(user);
        transaction.commit();
    }
}
