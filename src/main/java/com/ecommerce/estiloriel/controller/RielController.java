package com.ecommerce.estiloriel.controller;

import com.ecommerce.estiloriel.model.EstiloRiel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/riel")
public class RielController {

    @Autowired
    private RielRepository repository;

    @GetMapping
    public List<EstiloRiel> findAll () {
        return this.repository.findAll();
    }

}
