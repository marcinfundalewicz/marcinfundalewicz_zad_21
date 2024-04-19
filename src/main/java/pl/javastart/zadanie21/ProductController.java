package pl.javastart.zadanie21;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping("/products")
    @ResponseBody
    String showProducts() {
        int finalPrice = 0;
        String result = "";
        for (Product product : productRepository.getProductList()) {
            result += product + "</br>";
            finalPrice += product.price;
        }
        return result + "</br>" + "Suma zakupów wynosi" + "</br>" + finalPrice + "zł";
    }

    @RequestMapping("/filterOther")
    @ResponseBody
    String showFilteredProducts() {
        int finalPrice = 0;
        String result = "";
        for (Product product : productRepository.getProductList()) {
            if (product.category.equals("inne")) {
                result += product + "</br>";
                finalPrice += product.price;
            }
        }
        return result + "</br>" + "Suma zakupów wynosi" + "</br>" + finalPrice + "zł";
    }
    @RequestMapping("/filterAgd")
    @ResponseBody
    String showFilteredProductsByAgd() {
        int finalPrice = 0;
        String result = "";
        for (Product product : productRepository.getProductList()) {
            if (product.category.equals("art.gosp.domowego")) {
                result += product + "</br>";
                finalPrice += product.price;
            }
        }
        return result + "</br>" + "Suma zakupów wynosi" + "</br>" + finalPrice + "zł";
    }
    @RequestMapping("/filterFood")
    @ResponseBody
    String showFilteredProductsByFood() {
        int finalPrice = 0;
        String result = "";
        for (Product product : productRepository.getProductList()) {
            if (product.category.equals("art.spożywcze")) {
                result += product + "</br>";
                finalPrice += product.price;
            }
        }
        return result + "</br>" + "Suma zakupów wynosi" + "</br>"+ finalPrice + "zł";
    }

    @RequestMapping("/add")
    String addUser(@RequestParam(value = "name", required = false) String name,
                   @RequestParam(value = "price", required = false) Integer price,
                   @RequestParam(value = "category", required = false) String category) {
        if (!name.isEmpty() && price != null && !category.isEmpty()) {
            productRepository.addProduct(name, price, category);
            return "redirect:/success.html";
        } else {
            return "redirect:/err.html";
        }
    }
}