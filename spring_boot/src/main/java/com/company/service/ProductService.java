package com.company.service;

import com.company.controller.dto.Product;

import java.util.List;

public interface ProductService {
    void createProduct(Product product);

    Product getProductById(Long id);

    void deleteProductId(Long id);

    List<Product> getAllProducts();
}
