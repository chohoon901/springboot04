package io.playdata.springboot04.service;

import io.playdata.springboot04.model.Product;
import io.playdata.springboot04.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // 의존성 주입이 될 클래스를 받아줄 생성자 생성
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;


    // Create
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    public Product readProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> readAllProducts() {
        return productRepository.findAll();
    }

    public void updateProduct(Long id, Product product) {
        product.setId(id);
        productRepository.save(product);
//        Optional<Product> existingProduct = productRepository.findById(id);
//        if (existingProduct.isPresent()) {
//            Product updatedProduct = existingProduct.get();
//            updatedProduct.setName(product.getName());
//            updatedProduct.setPrice(product.getPrice());
//            updatedProduct.setDescription(product.getDescription());
//            updatedProduct.setUpdatedAt(LocalDateTime.now());
//            productRepository.save(updatedProduct);
//        } else {
//            throw new IllegalArgumentException("Product with ID " + id + " not found");
//        }
    }


    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> searchProductsWithKeyword(String keyword) {
        return productRepository.findProductsWithKeyword(keyword);
    }
    public List<Product> findAllByOrderByPriceDesc() {
        return productRepository.findAllByOrderByPriceDesc();
    }


}
