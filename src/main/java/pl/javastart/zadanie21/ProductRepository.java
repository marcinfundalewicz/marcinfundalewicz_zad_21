package pl.javastart.zadanie21;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productList = new ArrayList<>();

    Product product1 = new Product("Mleko", 5, "art.spożywcze");
    Product product2 = new Product("Serek wiejski", 3, "art.spożywcze");
    Product product3 = new Product("Banany", 5, "art.spożywcze");
    Product product4 = new Product("Czajnik", 100, "art.gosp.domowego");
    Product product5 = new Product("Lodówka", 1000, "art.gosp.domowego");
    Product product6 = new Product("Mikrofalówka", 150, "art.gosp.domowego");
    Product product7 = new Product("Samochód", 150000, "inne");
    Product product8 = new Product("Motor", 10000, "inne");
    {
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        productList.add(product6);
        productList.add(product7);
        productList.add(product8);

    }

    public void addProduct(String name, int price, String category) {
        productList.add(new Product(name, price, category));

    }

    public List<Product> getProductList() {
        return productList;
    }
}
