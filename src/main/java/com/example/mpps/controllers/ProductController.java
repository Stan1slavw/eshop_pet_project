package com.example.mpps.controllers;



import com.example.mpps.entity.Product;
import com.example.mpps.entity.User;
import com.example.mpps.repositories.ProductRepository;
import com.example.mpps.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
//    public String products(@ModelAttribute("searchWord") String title, @ModelAttribute("searchCity") String city, Principal principal, Model model) {
    public String products(@ModelAttribute("searchWord") String title, @ModelAttribute("searchCity") String city,
                           @ModelAttribute("searchCategory") String category, @ModelAttribute("searchPrice") String price, Principal principal, Model model) {
//        model.addAttribute("products", productService.findAllByTitleStartsWithAndCity(title, city));
        model.addAttribute("products", productService.findAllByTitleStartsWithAndCityAndCategoryAndPrice(title, city, category, price));
        model.addAttribute("user", productService.getUserByPrincipal(principal));
        model.addAttribute("searchWord", title);
        model.addAttribute("searchCity", city);
        model.addAttribute("searchCategory", category);
        model.addAttribute("searchPrice", price);
        return "products";
    }

    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model, Principal principal) {
        Product product = productService.getProductById(id);
        model.addAttribute("user", productService.getUserByPrincipal(principal));
        model.addAttribute("product", product);
        model.addAttribute("images", product.getImages());
        model.addAttribute("authorProduct", product.getUser());
        return "product-info";
    }

    @PostMapping("/product/create")
    public String createProduct(@RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2,
                                @RequestParam("file3") MultipartFile file3, Product product, Principal principal) throws IOException {
        productService.saveProduct(principal, product, file1, file2, file3);
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/my/products";
    }

    @GetMapping("/my/products")
    public String userProducts(Principal principal, Model model) {
        User user = productService.getUserByPrincipal(principal);
        model.addAttribute("user", user);
        model.addAttribute("products", user.getProducts());
        return "my-products";
    }
}
