package org.example.demo5;

import java.util.Scanner;

public class Test1 {
    private final Scanner scanner;
    private IProductsService productsService;

    public Test1(Scanner scanner, ProductsService productsService) {
        this.scanner = scanner;
    }

    public void start() {
        System.out.println("Start");
        var option = choose();
        perform(option);
    }

    private String choose() {
        return scanner.nextLine();
    }

    private void perform(String option) {
        switch (option) {
            case "1":
            case "add":
                addProduct();
                break;
            case "2":
            case "getbyname":
                showProductByName();
                break;
            case "3":
            case "getall":
                showAllProducts();
                break;

        }
    }

    private void addProduct() {
        System.out.println("Provide title");
        var title = scanner.nextLine();

        System.out.println("Provide author");
        var author = scanner.nextLine();

        System.out.println("Provide isbn");
        var isbn = scanner.nextLine();

        System.out.println("Provide publication year");
        var date = scanner.nextLine();

        //bookService.addBook(new Book(title, author, isbn, Date.valueOf(date)));
    }

    private void showAllProducts() {
        var books = productsService.getAllProducts();

        for (var book : books) {
            System.out.println(book);
        }
    }

    private void showProductByName() {
        System.out.println("Provide name: ");
        var id = scanner.nextLine();
        var book = productsService.getProduct(id);
        System.out.println(book);
    }
}
