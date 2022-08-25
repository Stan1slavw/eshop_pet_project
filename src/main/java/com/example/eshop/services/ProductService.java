package com.example.eshop.services;

import com.example.eshop.entity.Image;
import com.example.eshop.entity.Product;
import com.example.eshop.entity.User;
import com.example.eshop.repositories.ProductRepository;
import com.example.eshop.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;


    public List<Product> findAllByTitleStartsWith(String title) {
        List<Product> allProducts = productRepository.findAll();
        List<Product> allProductsStartsWith = new ArrayList<>();
        if (title==null){
            return allProducts;
        }
        for (Product product: allProducts){
            if (product.getTitle().toLowerCase().startsWith(title.toLowerCase())){
                allProductsStartsWith.add(product);
            }
        }
        return allProductsStartsWith;
    }

    List<Product> findAllByTitleStartingWithAndCity(String title, String city){
        List<Product> allProducts = productRepository.findAll();
        List<Product> allProductsStartsWithAndCity = new ArrayList<>();
        for (Product product: allProducts){
            if (product.getTitle().toLowerCase().startsWith(title.toLowerCase())&& product  .getCity().equals(city)){
                allProductsStartsWithAndCity.add(product);
            }
        }
        return allProductsStartsWithAndCity;
    }

    public List<Product> findAllByTitleStartsWithAndCity(String title, String city) {
        if (Objects.equals(city, "")){
            return findAllByTitleStartsWith(title);
        }
       List<Product> productsByTitleStartWithAndCity = findAllByTitleStartingWithAndCity(title, city);
       return productsByTitleStartWithAndCity;
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }


    public void saveProduct(Principal principal, Product product, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        product.setUser(getUserByPrincipal(principal));
        Image image1;
        Image image2;
        Image image3;
        if (file1.getSize() != 0) {
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            product.addImageToProduct(image1);
        }
        if (file2.getSize() != 0) {
            image2 = toImageEntity(file2);
            product.addImageToProduct(image2);
        }
        if (file3.getSize() != 0) {
            image3 = toImageEntity(file3);
            product.addImageToProduct(image3);
        }
        log.info("Saving new Product. Title: {}; Author email: {}", product.getTitle(), product.getUser().getEmail());
        Product productFromDb = productRepository.save(product);
        productFromDb.setPreviewImageId(productFromDb.getImages().get(0).getId());
        productRepository.save(product);
    }


    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElse(null);
        if (product != null) {
            productRepository.delete(product);
        }
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
