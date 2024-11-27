package com.ecommerce.estiloriel.controller;

import com.ecommerce.estiloriel.dto.PedidoRequestDTO;
import com.ecommerce.estiloriel.model.Pedido;
import com.ecommerce.estiloriel.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository repository;

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        List<Pedido> pedidos = this.repository.findAll();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Integer id) {
        Pedido pedido = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));
        return ResponseEntity.ok(pedido);
    }

    @PostMapping
    public ResponseEntity<Pedido> save(@RequestBody PedidoRequestDTO dto) {
        Pedido pedido = new Pedido();
        pedido.setUsuario(dto.getIdUsuario()); //
        pedido.setData(dto.getData());
        pedido.setStatus(dto.getIdStatus()); //
        pedido.setTotal(dto.getTotal());

        this.repository.save(pedido);
        return ResponseEntity.ok(pedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Pedido pedido = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));

        this.repository.delete(pedido);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> update(@PathVariable Integer id, @RequestBody PedidoRequestDTO dto) {
        Pedido pedido = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));

        pedido.setIdUsuario(dto.getIdUsuario());
        pedido.setData(dto.getData());
        pedido.setIdStatus(dto.getIdStatus());
        pedido.setTotal(dto.getTotal());

        this.repository.save(pedido);
        return ResponseEntity.ok(pedido);
    }
}
