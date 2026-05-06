package com.corder.ecommerce.controller;

import com.corder.ecommerce.model.Product;
import com.corder.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> allProducts = productService.getAllProducts();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }

    @GetMapping("product/{id}")
    public ResponseEntity<Product> getProductsById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("product/{id}/image")
    public ResponseEntity<byte[]> getProductImageById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(product.getImageData(), HttpStatus.OK);
    }

    @GetMapping("/product/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword) {
        List<Product> products = productService.searchProducts(keyword);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile) {
        Product productAdded = productService.addOrUpdateProduct(product, imageFile);
        return new ResponseEntity<>(productAdded, HttpStatus.CREATED);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestPart Product product, @RequestPart MultipartFile imageFile) {
        Product productUpdated = productService.addOrUpdateProduct(product, imageFile);
        return new ResponseEntity<>("Product Updated", HttpStatus.OK);

    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) {
        String sucessMessage = productService.deleteProductById(id);
        return new ResponseEntity<>(sucessMessage, HttpStatus.OK);
    }


}
