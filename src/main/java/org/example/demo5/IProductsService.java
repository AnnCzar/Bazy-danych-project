package org.example.demo5;

import entity.ProductsEntity;

import java.util.List;

public interface IProductsService {
    void addProduct(Products product);

    List<Products> getAllProducts();

    Products getProduct(String productName);

    List<ProductsEntity> getAllProductsNames();
}
