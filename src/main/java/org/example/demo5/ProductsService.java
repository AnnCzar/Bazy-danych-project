package org.example.demo5;

import entity.ProductsEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsService implements IProductsService{

    private IProductRepository productRepository;
    @Override
    public void addProduct(Products product){
        productRepository.addProduct(mapProductsToProductsEntity(product));
    }

    @Override
    public List<Products> getAllProducts(){
        return productRepository.getAllProducts().stream().map(this::mapProductsEntityToProducts).collect(Collectors.toList());
    }


    @Override
    public Products getProduct(String productName){
        return mapProductsEntityToProducts(productRepository.getProduct(productName));
    }

    @Override
    public List<ProductsEntity> getAllProductsNames(){
        return productRepository.getAllProductsNames();
    }

    private Products mapProductsEntityToProducts(ProductsEntity productsEntity){
        return new Products(productsEntity.getProductId(), productsEntity.getProductName(), productsEntity.getKalc(),
                productsEntity.getProteins(), productsEntity.getCarbs(), productsEntity.getFat());
    }

    private ProductsEntity mapProductsToProductsEntity(Products product){
        var productsEntity = new ProductsEntity();
        productsEntity.setProductName(product.getProductName());
        productsEntity.setCarbs(product.getCarbs());
        productsEntity.setFat(product.getFat());
        productsEntity.setProteins(product.getProteins());
        productsEntity.setKalc(product.getKalc());
        return productsEntity;
    }

}
