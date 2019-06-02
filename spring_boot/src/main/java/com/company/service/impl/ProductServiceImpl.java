package com.company.service.impl;

import com.company.controller.dto.Product;
import com.company.repository.ProductEntityRepository;
import com.company.service.ProductService;
import com.company.transformer.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductServiceImpl implements ProductService {

    private ProductEntityRepository repository;
    private ProductMapper mapper;

    @Override
    public void createProduct(Product product) {
        repository.save(mapper.mapProductToProductEntity(product));
    }

    @Override
    public Product getProductById(Long id) {
        return mapper.mapProductEntityToProduct(repository.findById(id).get());
    }

    @Override
    public void updateProduct(Product product) {
        repository.save(mapper.mapProductToProductEntity(product));
    }

    @Override
    public void deleteProductId(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return mapper.mapProductEntityListToProductList(repository.findAll());
    }
}
