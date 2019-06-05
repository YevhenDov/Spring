package com.company.service.impl;

import com.company.controller.dto.Product;
import com.company.repository.ProductEntityRepository;
import com.company.service.ProductService;
import com.company.transformer.ProductMapper;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductServiceImpl implements ProductService {

    private final ProductEntityRepository repository;
    private final ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

    @Override
    public void createProduct(Product product) {
        repository.save(mapper.mapProductToProductEntity(product));
    }

    @Override
    public Product getProductById(Long id) {
        return mapper.mapProductEntityToProduct(repository.findById(id).orElse(null));
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
