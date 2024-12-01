package com.ecommerce.estiloriel.controller;

import com.ecommerce.estiloriel.dto.CategoriaRequestDTO;
import com.ecommerce.estiloriel.model.Categoria;
import com.ecommerce.estiloriel.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll() {
        List<Categoria> categorias = this.repository.findAll();
        return ResponseEntity.ok(categorias);
    }

    @PostMapping
    public ResponseEntity<Categoria> save(@RequestBody CategoriaRequestDTO dto) {
        if (dto.nome().isEmpty() || dto.descricao().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        Categoria categoria = new Categoria(dto.nome(), dto.descricao());
        this.repository.save(categoria);

        return ResponseEntity.status(201).body(categoria);
    }
}
