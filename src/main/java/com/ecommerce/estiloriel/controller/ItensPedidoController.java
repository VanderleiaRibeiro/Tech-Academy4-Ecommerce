package com.ecommerce.estiloriel.controller;

import com.ecommerce.estiloriel.dto.ItensPedidoRequestDTO;
import com.ecommerce.estiloriel.model.ItensPedido;
import com.ecommerce.estiloriel.model.Pedido;
import com.ecommerce.estiloriel.model.Produto;
import com.ecommerce.estiloriel.repository.ItensPedidoRepository;
import com.ecommerce.estiloriel.repository.PedidoRepository;
import com.ecommerce.estiloriel.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/itens-pedido")
public class ItensPedidoController {

    @Autowired
    private ItensPedidoRepository itensPedidoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public ResponseEntity<List<ItensPedido>> findAll() {
        List<ItensPedido> itens = this.itensPedidoRepository.findAll();
        return ResponseEntity.ok(itens);
    }

    @PostMapping
    public ResponseEntity<ItensPedido> save(@RequestBody ItensPedidoRequestDTO dto) {
        Optional<Pedido> pedidoOpt = pedidoRepository.findById(dto.getIdPedido());
        Optional<Produto> produtoOpt = produtoRepository.findById(dto.getIdProduto());

        if (!pedidoOpt.isPresent() || !produtoOpt.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        Pedido pedido = pedidoOpt.get();
        Produto produto = produtoOpt.get();

        ItensPedido item = new ItensPedido(pedido, produto, dto.getQuantidade(), dto.getPreco());
        itensPedidoRepository.save(item);

        return ResponseEntity.status(201).body(item);
    }
}
