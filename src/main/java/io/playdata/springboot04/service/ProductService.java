package io.playdata.springboot04.service;

import io.playdata.springboot04.model.Product;
import io.playdata.springboot04.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    }


    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
