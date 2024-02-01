package entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.demo5.User;

public class UserRepository implements IUserRepository {

    private final EntityManager entityManager;

    public UserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addUser(User u) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        try {
            var transaction = em.getTransaction();
            transaction.begin();
            em.persist(u);
            transaction.commit();
        } finally {
            em.close();
            emf.close();
        }
    }

    @Override
    public void editUser(UsersEntity user) {
        var transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(user);
        transaction.commit();
    }
}
