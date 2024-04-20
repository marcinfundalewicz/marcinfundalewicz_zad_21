package pl.javastart.zadanie21;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productList = new ArrayList<>();

    public ProductRepository() {
        productList.add(new Product("Mleko", 5, Category.ART_SPOZYWCZE));
        productList.add(new Product("Serek wiejski", 3, Category.ART_SPOZYWCZE));
        productList.add(new Product("Banany", 5, Category.ART_SPOZYWCZE));
        productList.add(new Product("Czajnik", 100, Category.ART_GOSP_DOMOWEGO));
        productList.add(new Product("Lodówka", 1000, Category.ART_GOSP_DOMOWEGO));
        productList.add(new Product("Mikrofalówka", 150, Category.ART_GOSP_DOMOWEGO));
        productList.add(new Product("Samochód", 150000, Category.INNE));
        productList.add(new Product("Motor", 10000, Category.INNE));
    }


    public void addProduct(String name, int price, Category category) {
        productList.add(new Product(name, price, category));

    }

    public List<Product> getProductList() {
        return productList;
    }
}
