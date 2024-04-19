package pl.javastart.zadanie21;

public class Product {
    String name;
    int price;
    String category;

    public Product(String name, int price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        return name + " " + price + " " + category;
    }
}
