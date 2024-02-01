package org.example.demo5;

import entity.ProductsEntity;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ProductsRepository implements IProductRepository{

    private final EntityManager entityManager;

    public ProductsRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addProduct(ProductsEntity productsEntity) {
        var transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(productsEntity);
        transaction.commit();
    }

    @Override
    public List<ProductsEntity> getAllProducts() {
        var stringQuery = "SELECT p FROM ProductsEntity p";
        var query = entityManager.createQuery(stringQuery, ProductsEntity.class);
        return query.getResultList();
    }

    @Override
    public List<ProductsEntity> getAllProductsNames() {
        var stringQuery = "SELECT productName FROM ProductsEntity p";
        var query = entityManager.createQuery(stringQuery, ProductsEntity.class);
        return query.getResultList();
    }

    @Override
    public ProductsEntity getProduct(String productName) {
        return entityManager.find(ProductsEntity.class, productName);
    }
}
