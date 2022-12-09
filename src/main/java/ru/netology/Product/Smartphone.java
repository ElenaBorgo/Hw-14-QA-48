package ru.netology.Product;

public class Smartphone extends Product {

    private String companyName;

    public Smartphone(int id, String name, int price, String companyName) {
        super(id, name, price);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }
}
