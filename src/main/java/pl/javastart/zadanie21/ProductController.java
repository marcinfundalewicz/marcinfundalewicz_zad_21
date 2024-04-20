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
    String showProducts(@RequestParam(required = false) Category category) {
        int finalPrice = 0;
        String result = "";
        for (Product product : productRepository.getProductList()) {
            if (category == null || product.getCategory() == category) {
                result += product + "</br>";
                finalPrice += product.getPrice();
            }
        }
        return result + "</br>" + "Suma zakupów wynosi" + "</br>" + finalPrice + "zł";
    }

    @RequestMapping("/add")
    String addUser(@RequestParam(value = "name", required = false) String name,
                   @RequestParam(value = "price", required = false) Integer price,
                   @RequestParam(value = "category", required = false) Category category) {
        if (!name.isEmpty() && price != null && category != null) {
            productRepository.addProduct(name, price, category);
            return "redirect:/success.html";
        } else {
            return "redirect:/err.html";
        }
    }
}