package org.example.demo5;

import entity.ProductsEntity;

import java.util.List;

public interface IProductRepository {
    void addProduct(ProductsEntity productsEntity);

    List<ProductsEntity> getAllProducts();

    List<ProductsEntity> getAllProductsNames();

    ProductsEntity getProduct(String productName);


}
