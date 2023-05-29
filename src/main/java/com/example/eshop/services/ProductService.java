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

    //Поиск по названию продукта
    public List<Product> findAllByTitleStartsWith(String title) {
        List<Product> allProducts = productRepository.findAll();
        List<Product> allProductsStartsWith = new ArrayList<>();
        if (title == null) {
            return allProducts;
        }
        for (Product product : allProducts) {
            if (product.getTitle().toLowerCase().startsWith(title.toLowerCase())) {
                allProductsStartsWith.add(product);
            }
        }
        return allProductsStartsWith;
    }

    //Поиск по названию города
    public List<Product> findAllByCity(String city) {
        List<Product> allProducts = productRepository.findAll();
        List<Product> allProductsByCity = new ArrayList<>();
        if (city == null) {
            return allProducts;
        }
        for (Product product : allProducts) {
            if (product.getCity().toLowerCase().startsWith(city.toLowerCase())) {
                allProductsByCity.add(product);
            }
        }
        return allProductsByCity;
    }

    //Поиск по цене
    public List<Product> findAllByPrice(String price) {
        List<Product> allProducts = productRepository.findAll();
        List<Product> allProductsWithPriceLow = new ArrayList<>();
        if (price == null) {
            return allProducts;
        }
        for (Product product : allProducts) {
            if (Integer.parseInt(product.getPrice()) <= Integer.parseInt(price)) {
                allProductsWithPriceLow.add(product);
            }
        }
        return allProductsWithPriceLow;
    }

    //Поиск по категории
    public List<Product> findAllByCategory(String category) {
        List<Product> allProducts = productRepository.findAll();
        List<Product> allProductsWithCategory = new ArrayList<>();
        if (category == null) {
            return allProducts;
        }
        for (Product product : allProducts) {
            if (product.getCategory().equals(category)) {
                allProductsWithCategory.add(product);
            }
        }
        return allProductsWithCategory;
    }

    //Поиск по названию и городу
    public List<Product> findAllByTitleStartingWithAndCity(String title, String city) {
        List<Product> allProducts = productRepository.findAll();
        List<Product> allProductsStartsWithAndCity = new ArrayList<>();
        for (Product product : allProducts) {
            if (product.getTitle().toLowerCase().startsWith(title.toLowerCase()) && product.getCity().equals(city)) {
                allProductsStartsWithAndCity.add(product);
            }
        }
        return allProductsStartsWithAndCity;
    }

    //Поиск по названию и цене
    public List<Product> findAllByTitleStartingWithAndPrice(String title, String price) {
        List<Product> allProducts = productRepository.findAll();
        List<Product> allProductsStartsWithAndPrice = new ArrayList<>();
        for (Product product : allProducts) {
            if (product.getTitle().toLowerCase().startsWith(title.toLowerCase()) && Integer.parseInt(product.getPrice()) <= Integer.parseInt(price)) {
                allProductsStartsWithAndPrice.add(product);
            }
        }
        return allProductsStartsWithAndPrice;
    }

    //Поиск по названию и категории
    public List<Product> findAllByTitleStartingWithAndCategory(String title, String category) {
        List<Product> allProducts = productRepository.findAll();
        List<Product> allProductsStartsWithAndCategory = new ArrayList<>();
        for (Product product : allProducts) {
            if (product.getTitle().toLowerCase().startsWith(title.toLowerCase()) && product.getCategory().equals(category)) {
                allProductsStartsWithAndCategory.add(product);
            }
        }
        return allProductsStartsWithAndCategory;
    }

    //Поиск по городу и цене
    public List<Product> findAllByCityAndPrice(String city, String price) {
        List<Product> allProducts = productRepository.findAll();
        List<Product> allProductsByCityAndPrice = new ArrayList<>();
        for (Product product : allProducts) {
            if (product.getCity().equals(city) && Integer.parseInt(product.getPrice()) <= Integer.parseInt(price)) {
                allProductsByCityAndPrice.add(product);
            }
        }
        return allProductsByCityAndPrice;
    }

    //Поиск по городу и категории
    public List<Product> findAllByCityAndCategory(String city, String category) {
        List<Product> allProducts = productRepository.findAll();
        List<Product> allProductsByCityAndCategory = new ArrayList<>();
        for (Product product : allProducts) {
            if (product.getCity().equals(city) && product.getCategory().equals(category)) {
                allProductsByCityAndCategory.add(product);
            }
        }
        return allProductsByCityAndCategory;
    }

    //Поиск по цене и категории
    public List<Product> findAllByPriceAndCategory(String price, String category) {
        List<Product> allProducts = productRepository.findAll();
        List<Product> allProductsByPriceAndCategory = new ArrayList<>();
        for (Product product : allProducts) {
            if (Integer.parseInt(product.getPrice()) <= Integer.parseInt(price) && product.getCategory().equals(category)) {
                allProductsByPriceAndCategory.add(product);
            }
        }
        return allProductsByPriceAndCategory;
    }

    //Поиск по названию городу и цене
    public List<Product> findAllByTitleAndCityAndPrice(String title, String city, String price) {
        List<Product> allProducts = productRepository.findAll();
        List<Product> allProductsByTitleAndCityAndPrice = new ArrayList<>();
        for (Product product : allProducts) {
            if (Integer.parseInt(product.getPrice()) <= Integer.parseInt(price) && product.getTitle()
                    .toLowerCase().startsWith(title.toLowerCase()) && product.getCity().equals(city)) {
                allProductsByTitleAndCityAndPrice.add(product);
            }
        }
        return allProductsByTitleAndCityAndPrice;
    }

    //Поиск по названию городу и категории
    public List<Product> findAllByTitleAndCityAndCategory(String title, String city, String category) {
        List<Product> allProducts = productRepository.findAll();
        List<Product> allProductsByTitleAndCityAndCategory = new ArrayList<>();
        for (Product product : allProducts) {
            if (product.getCategory().equals(category) && product.getTitle().toLowerCase().startsWith(title.toLowerCase()) && product.getCity().equals(city)) {
                allProductsByTitleAndCityAndCategory.add(product);
            }
        }
        return allProductsByTitleAndCityAndCategory;
    }

    //Поиск по городу цене и категории
    public List<Product> findAllByPriceAndCityAndCategory(String price, String city, String category) {
        List<Product> allProducts = productRepository.findAll();
        List<Product> allProductsByPriceAndCityAndCategory = new ArrayList<>();
        for (Product product : allProducts) {
            if (Integer.parseInt(product.getPrice()) <= Integer.parseInt(price) && product.getCity().equals(city) && product.getCategory().equals(category)) {
                allProductsByPriceAndCityAndCategory.add(product);
            }
        }
        return allProductsByPriceAndCityAndCategory;
    }

    //Поиск по цене категории и названию
    public List<Product> findAllByPriceAndCategoryAndTitle(String price, String title, String category) {
        List<Product> allProducts = productRepository.findAll();
        List<Product> allProductsByPriceAndCategoryAndTitle = new ArrayList<>();
        for (Product product : allProducts) {
            if (Integer.parseInt(product.getPrice()) <= Integer.parseInt(price) && product.getTitle()
                    .toLowerCase().startsWith(title.toLowerCase()) && product.getCategory().equals(category)) {
                allProductsByPriceAndCategoryAndTitle.add(product);
            }
        }
        return allProductsByPriceAndCategoryAndTitle;
    }


//    public List<Product> findAllByTitleStartsWithAndCity(String title, String city) {
//        if (Objects.equals(city, "")) {
//            return findAllByTitleStartsWith(title);
//        }
//        List<Product> productsByTitleStartWithAndCity = findAllByTitleStartingWithAndCity(title, city);
//        return productsByTitleStartWithAndCity;
//    }

    /*////////////////////////////////////////*/
    public List<Product> findAllByTitleStartsWithAndCityAndCategoryAndPrice(String title, String city, String category, String price) {
        //Вывод всех товаров Y
        if (Objects.equals(title, "") && Objects.equals(city, "") && Objects.equals(category, "") && Objects.equals(price, "")) {
            System.out.println("Вывод всех товаров");
            return productRepository.findAll();
        }
/////////////////////////////////////////
        //Поиск товаров по названию Y
        if (!Objects.equals(title, "") && Objects.equals(category, "") && Objects.equals(price, "") && Objects.equals(city, "")) {
            System.out.println("Поиск товаров по названию");
            return findAllByTitleStartsWith(title);
        }
        //Поиск товаров по городу Y
        if (Objects.equals(title, "") && Objects.equals(category, "") && Objects.equals(price, "") && !Objects.equals(city, "")) {
            System.out.println("Поиск товаров по городу");
            return findAllByCity(city);
        }
        //Поиск товаров по цене Y
        if (Objects.equals(title, "") && Objects.equals(category, "") && !Objects.equals(price, "") && Objects.equals(city, "")) {
            System.out.println("Поиск товаров по цене");
            return findAllByPrice(price);
        }
        //Поиск товаров по категориям Y
        if (Objects.equals(title, "") && !Objects.equals(category, "") && Objects.equals(price, "") && Objects.equals(city, "")) {
            System.out.println("Поиск товаров по категориям");
            return findAllByCategory(category);
        }
/////////////////////////////////////////
        //Поиск по названию и городу Y
        if (!Objects.equals(title, "") && Objects.equals(category, "") && Objects.equals(price, "") && !Objects.equals(city, "")) {
            System.out.println("Поиск по названию и городу");
            return findAllByTitleStartingWithAndCity(title, city);
        }
        //Поиск по названию и цене Y
        if (!Objects.equals(title, "") && Objects.equals(category, "") && !Objects.equals(price, "") && Objects.equals(city, "")) {
            System.out.println("Поиск по названию и цене");
            return findAllByTitleStartingWithAndPrice(title, price);
        }
        //Поиск по названию и категории Y
        if (!Objects.equals(title, "") && !Objects.equals(category, "") && Objects.equals(price, "") && Objects.equals(city, "")) {
            System.out.println("Поиск по названию и категории");
            return findAllByTitleStartingWithAndCategory(title, category);
        }
        //Поиск по городу и цене Y
        if (Objects.equals(title, "") && Objects.equals(category, "") && !Objects.equals(price, "") && !Objects.equals(city, "")) {
            System.out.println("Поиск по городу и цене");
            return findAllByCityAndPrice(city, price);
        }
        //Поиск по городу и категории Y
        if (Objects.equals(title, "") && !Objects.equals(city, "") && !Objects.equals(category, "") && Objects.equals(price, "")) {
            System.out.println("Поиск по городу и категории");
            return findAllByCityAndCategory(city, category);
        }
        //Поиск по цене и категории Y
        if (Objects.equals(title, "") && Objects.equals(city, "") && !Objects.equals(category, "") && !Objects.equals(price, "")) {
            System.out.println("Поиск по цене и категории");
            return findAllByPriceAndCategory(price, category);
        }

/////////////////////////////////////////
        //Поиск по названию городу и цене Y
        if (!Objects.equals(title, "") && !Objects.equals(city, "") && Objects.equals(category, "") && !Objects.equals(price, "")) {
            System.out.println("Поиск по названию городу и цене");
            return findAllByTitleAndCityAndPrice(title, city, price);
        }
        //Поиск по названию городу и категории Y
        if (!Objects.equals(title, "") && !Objects.equals(city, "") && !Objects.equals(category, "") && Objects.equals(price, "")) {
            System.out.println("Поиск по названию городу и категории");
            return findAllByTitleAndCityAndCategory(title, city, category);
        }
        //Поиск по городу цене и категории N
        if (Objects.equals(title, "") && !Objects.equals(city, "") && !Objects.equals(category, "") && !Objects.equals(price, "")) {
            System.out.println("Поиск по городу цене и категории");
            return findAllByPriceAndCityAndCategory(price, city, category);
        }
        //Поиск по цене категории и названию Y
        if (!Objects.equals(title, "") && Objects.equals(city, "") && !Objects.equals(category, "") && !Objects.equals(price, "")) {
            System.out.println("Поиск по цене категории и названию");
            return findAllByPriceAndCategoryAndTitle(price, title, category);
        }


//        if (Objects.equals(city, "") && (Objects.equals(category, ""))){
//            return findAllByTitleStartsWith(title);
//        }
//        if (!Objects.equals(category, "")){
//            return findAllByCategory(category);
//        }

        return findAllByPriceAndCategory("10", "123");

    }


    /*////////////////////////////////////////*/
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

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
