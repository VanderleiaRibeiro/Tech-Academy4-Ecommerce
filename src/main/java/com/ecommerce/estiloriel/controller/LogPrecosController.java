package com.ecommerce.estiloriel.controller;

import com.ecommerce.estiloriel.dto.PedidoRequestDTO;
import com.ecommerce.estiloriel.model.LogPrecos;
import com.ecommerce.estiloriel.model.Produto;
import com.ecommerce.estiloriel.model.Usuario;
import com.ecommerce.estiloriel.repository.LogPrecosRepository;
import com.ecommerce.estiloriel.repository.ProdutoRepository;
import com.ecommerce.estiloriel.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/log-precos")
public class LogPrecosController {

    @Autowired
    private LogPrecosRepository logPrecosRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public ResponseEntity<List<LogPrecos>> findAll() {
        List<LogPrecos> logs = this.logPrecosRepository.findAll();
        return ResponseEntity.ok(logs);
    }

    @PostMapping
    public ResponseEntity<LogPrecos> save(@RequestBody PedidoRequestDTO dto) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(dto.idUsuario());
        Optional<Produto> produtoOpt = produtoRepository.findById(dto.idPedido()); // Aqui você pode querer mudar para a relação correta entre produto e pedido

        if (!usuarioOpt.isPresent() || !produtoOpt.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        Usuario usuario = usuarioOpt.get();
        Produto produto = produtoOpt.get();

        LogPrecos logPrecos = new LogPrecos(
                usuario,
                produto,
                new Date(),
                dto.total(),
                dto.total()
        );

        logPrecosRepository.save(logPrecos);

        return ResponseEntity.status(201).body(logPrecos);
    }
}
