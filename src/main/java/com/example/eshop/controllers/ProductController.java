package com.example.eshop.controllers;

import com.example.eshop.controllers.services.ProductService;
import com.example.eshop.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String allProducts(Model model){
        List<Product> productList = productService.allProducts();
        model.addAttribute("products", productList);
        return "product";
    }

    @PostMapping("/product/create")
    public String createProduct(Product product){
        productService.saveProduct(product);
        return "redirect:/";
    }

    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model){
            model.addAttribute("product", productService.getProductById(id));
        return "product-info";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return "redirect:/";
    }
}
