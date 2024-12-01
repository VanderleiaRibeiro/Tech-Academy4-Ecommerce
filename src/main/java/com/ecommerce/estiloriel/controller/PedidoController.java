package com.ecommerce.estiloriel.controller;

import com.ecommerce.estiloriel.dto.PedidoRequestDTO;
import com.ecommerce.estiloriel.model.Pedido;
import com.ecommerce.estiloriel.model.Status;
import com.ecommerce.estiloriel.model.Usuario;
import com.ecommerce.estiloriel.repository.PedidoRepository;
import com.ecommerce.estiloriel.repository.StatusRepository;
import com.ecommerce.estiloriel.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private StatusRepository statusRepository;

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return ResponseEntity.ok(pedidos);
    }

    @PostMapping
    public ResponseEntity<Pedido> save(@RequestBody PedidoRequestDTO dto) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(dto.getIdUsuario());
        if (!usuarioOpt.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        Optional<Status> statusOpt = statusRepository.findById(dto.getIdStatus());
        if (!statusOpt.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        Usuario usuario = usuarioOpt.get();
        Status status = statusOpt.get();

        Pedido pedido = new Pedido(
                usuario,
                dto.getData(),
                status,
                dto.getTotal()
        );

        Pedido savedPedido = pedidoRepository.save(pedido);

        return ResponseEntity.status(201).body(savedPedido);
    }
}
