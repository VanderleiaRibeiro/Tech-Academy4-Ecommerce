package com.ecommerce.estiloriel.controller;

import com.ecommerce.estiloriel.dto.EnderecoRequestDTO;
import com.ecommerce.estiloriel.model.Endereco;
import com.ecommerce.estiloriel.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoRepository repository;

    @GetMapping
    public ResponseEntity<List<Endereco>> findAll() {
        List<Endereco> enderecos = this.repository.findAll();
        return ResponseEntity.ok(enderecos);
    }

    @PostMapping
    public ResponseEntity<Endereco> save(@RequestBody EnderecoRequestDTO dto) {
        if (dto.getCep().isEmpty() || dto.getRua().isEmpty() || dto.getNumero().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        Endereco endereco = new Endereco(dto.getCep(), dto.getRua(), dto.getNumero(), dto.getComplemento());
        this.repository.save(endereco);

        return ResponseEntity.status(201).body(endereco);
    }
}
