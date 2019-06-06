package com.company.controller;

import com.company.controller.dto.Producer;
import com.company.service.impl.ProducerServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ProducerController {

    private final ProducerServiceImpl service;

    @GetMapping("/admin/producers")
    public ModelAndView getAllProducers(){
        ModelAndView modelAndView = new ModelAndView("ADMIN_producer_list");
        modelAndView.addObject("producers", service.getAllProducers());
        return modelAndView;
    }

    @GetMapping("/admin/producer-form")
    public ModelAndView producerForm(){
        Producer producer = new Producer();
        ModelAndView modelAndView = new ModelAndView("ADMIN_producer_form");
        modelAndView.addObject("producer", producer);
        return modelAndView;
    }

    @PostMapping("/admin/save-producer")
    public RedirectView saveProducer(@ModelAttribute("producer") Producer producer){
        service.createProducer(producer);
        return new RedirectView("/admin/producers");
    }

    @GetMapping("/admin/edit-producer/{id}")
    public ModelAndView editProductForm(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("ADMIN_edit_producer");
        Producer producer = service.getProducerById(id);
        modelAndView.addObject("producer", producer);

        return modelAndView;
    }

    @DeleteMapping("/admin/delete-producer/{id}")
    public RedirectView deleteProducer(@PathVariable(name = "id") Long id){
        service.deleteProducerById(id);
        return new RedirectView("/admin/producers");
    }

    @GetMapping("user/producers")
    public ModelAndView getAllProducersForUser(){
        ModelAndView modelAndView = new ModelAndView("USER_producer_list");
        modelAndView.addObject("producers", service.getAllProducers());
        return modelAndView;
    }
}
