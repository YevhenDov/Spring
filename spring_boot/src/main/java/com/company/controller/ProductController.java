package com.company.controller;

import com.company.controller.dto.Product;
import com.company.service.impl.ProducerServiceImpl;
import com.company.service.impl.ProductServiceImpl;
import com.company.transformer.ProducerMapper;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductController {

    private final ProductServiceImpl productService;
    private final ProducerServiceImpl producerService;
    private final ProducerMapper producerMapper = Mappers.getMapper(ProducerMapper.class);

    @GetMapping("admin/products")
    public ModelAndView getAllProducts() {
        ModelAndView modelAndView = new ModelAndView("ADMIN_product_list");
        modelAndView.addObject("products", productService.getAllProducts());

        return modelAndView;
    }

    @GetMapping("admin/product-form")
    public ModelAndView productForm() {
        Product product = new Product();
        ModelAndView modelAndView = new ModelAndView("ADMIN_product_form");

        modelAndView.addObject("product", product);
        modelAndView.addObject("producers", producerService.getAllProducers());

        return modelAndView;
    }

    @PostMapping("admin/save-product")
    public RedirectView saveProduct(@ModelAttribute("product") Product product) {
        product.setProducer(producerMapper.mapProducerToProducerEntity(producerService.getProducerByName(product.getProducerName())));
        productService.createProduct(product);

        return new RedirectView("admin/products");
    }

    @GetMapping("admin/edit-product/{id}")
    public ModelAndView editProductForm(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("ADMIN_edit_product");
        Product product = productService.getProductById(id);
        modelAndView.addObject("product", product);
        modelAndView.addObject("producers", producerService.getAllProducers());

        return modelAndView;
    }

    @DeleteMapping("admin/delete-product/{id}")
    public RedirectView deleteProduct(@PathVariable(name = "id") Long id) {
        productService.deleteProductId(id);

        return new RedirectView("admin/products");
    }

    @GetMapping("user/products")
    public ModelAndView getAllProductsForUser() {
        ModelAndView modelAndView = new ModelAndView("USER_product_list");
        modelAndView.addObject("products", productService.getAllProducts());
        return modelAndView;
    }
}
