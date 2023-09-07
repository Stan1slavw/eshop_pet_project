package com.example.eshop.controllers.services;

import com.example.eshop.entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private long ID = 0;
    {
        products.add(new Product(++ID,"PS5", "Simple ex", 4500, "Kharkov", "Max"));
        products.add(new Product(++ID,"Xbox", "Simple ex", 3000, "kiyv", "Alex"));
    }

    public List<Product> allProducts(){
        return products;
    }

    public void saveProduct(Product product){
        product.setId(++ID);
        products.add(product);
    }

    public void deleteProduct(Long id){
        products.removeIf(product -> product.getId().equals(id));
    }

    public Product getProductById(Long id) {
        for (Product product: products){
            if (product.getId().equals(id)){
                return product;
            }
        }
        return null;
    }
}
