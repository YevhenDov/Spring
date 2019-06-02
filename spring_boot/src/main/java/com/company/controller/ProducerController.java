package com.company.controller;

import com.company.controller.dto.Producer;
import com.company.service.impl.ProducerServiceImpl;
import lombok.AllArgsConstructor;
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
public class ProducerController {

    ProducerServiceImpl service;

    @GetMapping("/admin/producers")
    public String getAllProducers(Model model){
        model.addAttribute("producers", service.getAllProducers());
        return "ADMIN_producer_list";
    }

    @GetMapping("/admin/producer_form")
    public String producerForm(Model model){
        Producer producer = new Producer();
        model.addAttribute("producer", producer);
        return "ADMIN_producer_form";
    }

    @PostMapping("/admin/save_producer")
    public String saveProducer(@ModelAttribute("producer") Producer producer){
        service.createProducer(producer);
        return "redirect:/admin/producers";
    }

    @GetMapping("/admin/edit_producer/{id}")
    public ModelAndView editProductForm(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("ADMIN_edit_producer");
        Producer producer = service.getProducerById(id);
        modelAndView.addObject("producer", producer);

        return modelAndView;
    }

    @GetMapping("admin/delete_producer/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id){
        service.deleteProducerById(id);
        return "redirect:/admin/producers";
    }

    @GetMapping("user/producers")
    public String getAllProducersForUser(Model model){
        model.addAttribute("producers", service.getAllProducers());
        return "USER_producer_list";
    }
}
