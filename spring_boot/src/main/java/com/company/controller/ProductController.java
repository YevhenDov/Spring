package com.company.controller;

import com.company.controller.dto.Product;
import com.company.service.impl.ProducerServiceImpl;
import com.company.service.impl.ProductServiceImpl;
import com.company.transformer.ProducerMapper;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductController {

    private final ProductServiceImpl productService;
    private final ProducerServiceImpl producerService;
    private final ProducerMapper producerMapper = Mappers.getMapper(ProducerMapper.class);

    @GetMapping("admin/products")
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());

        return "ADMIN_product_list";
    }

    @GetMapping("admin/product_form")
    public String productForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("producers", producerService.getAllProducers());

        return "ADMIN_product_form";
    }

    @PostMapping("admin/save_product")
    public String saveProduct(@ModelAttribute("product") Product product) {
        product.setProducer(producerMapper.mapProducerToProducerEntity(producerService.getProducerByName(product.getProducerName())));
        productService.createProduct(product);

        return "redirect:/admin/products";
    }

    @GetMapping("admin/edit_product/{id}")
    public ModelAndView editProductForm(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("ADMIN_edit_product");
        Product product = productService.getProductById(id);
        modelAndView.addObject("product", product);
        modelAndView.addObject("producers", producerService.getAllProducers());

        return modelAndView;
    }

    @GetMapping("admin/delete_product/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id) {
        productService.deleteProductId(id);

        return "redirect:/admin/products";
    }

    @GetMapping("user/products")
    public String getAllProductsForUser(Model model) {
        model.addAttribute("products", productService.getAllProducts());

        return "USER_product_list";
    }
}
