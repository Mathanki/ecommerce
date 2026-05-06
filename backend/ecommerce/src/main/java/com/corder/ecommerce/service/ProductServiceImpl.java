package com.corder.ecommerce.service;

import com.corder.ecommerce.advice.ProductNotFoundException;
import com.corder.ecommerce.model.Product;
import com.corder.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        if (productRepository.findAll().isEmpty()) {
            throw new ProductNotFoundException("Products not found");
        }
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product Not found with id : " + id));
    }

    @Override
    public Product addOrUpdateProduct(Product product,  MultipartFile image) {
        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        try {
            product.setImageData(image.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return productRepository.save(product);
    }

    @Override
    public String deleteProductById(Long id) {
        productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product Not found with id : " + id));
        productRepository.deleteById(id);
        return "Deleted product with id : " + id;
    }

    @Override
    public List<Product> searchProducts(String keyword) {
        return productRepository.searchProducts(keyword);
    }
}
