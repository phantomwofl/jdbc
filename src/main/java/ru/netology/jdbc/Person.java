package ru.netology.jdbc;

public class Person {
    private String name;
    private String productName;

    public Person(String name, String productName) {
        this.name = name;
        this.productName = productName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
