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
        if (dto.cep() == null || dto.rua().isEmpty() || dto.numero() == null) {
            return ResponseEntity.status(428).build();
        }

        Endereco endereco = new Endereco();
        endereco.setIdEndereco(dto.idEndereco());
        endereco.setRua(dto.rua());
        endereco.setCep(dto.cep());
        endereco.setNumero(dto.numero());
        endereco.setComplemento(dto.complemento());
        this.repository.save(endereco);

        return ResponseEntity.status(201).body(endereco);
    }
}
