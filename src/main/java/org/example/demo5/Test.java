package org.example.demo5;

import jakarta.persistence.Persistence;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var emf = Persistence.createEntityManagerFactory("default");
        var em = emf.createEntityManager();
        var productsRepository = new ProductsRepository(em);
        var productsService = new ProductsService();
        var test1 = new Test1(scanner, productsService);
        test1.start();

        scanner.close();
        em.close();
        emf.close();
    }
}
