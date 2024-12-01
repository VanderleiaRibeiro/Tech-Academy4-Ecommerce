package com.ecommerce.estiloriel.controller;

import com.ecommerce.estiloriel.dto.StatusRequestDTO;
import com.ecommerce.estiloriel.model.Status;
import com.ecommerce.estiloriel.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/status")
public class StatusController {

    @Autowired
    private StatusRepository repository;

    @GetMapping
    public ResponseEntity<List<Status>> getAllStatus() {
        List<Status> statusList = this.repository.findAll();
        return ResponseEntity.ok(statusList);
    }

    @PostMapping
    public ResponseEntity<Status> createStatus(@RequestBody StatusRequestDTO statusRequestDTO) {
        Status status = new Status();
        status.setNome(statusRequestDTO.getNome());

        Status savedStatus = this.repository.save(status);

        return ResponseEntity.status(201).body(savedStatus);
    }
}
