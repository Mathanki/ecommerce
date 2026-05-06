package com.corder.ecommerce.service;

import com.corder.ecommerce.model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProducts();
    public Product getProductById(Long id);
    public Product addOrUpdateProduct(Product product,MultipartFile image );
    public String deleteProductById(Long id);
    public List<Product> searchProducts(String keyword);
}
