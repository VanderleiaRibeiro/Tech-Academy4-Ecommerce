package com.ecommerce.estiloriel.controller;

import com.ecommerce.estiloriel.dto.ProdutoRequestDTO;
import com.ecommerce.estiloriel.model.Categoria;
import com.ecommerce.estiloriel.model.Produto;
import com.ecommerce.estiloriel.repository.CategoriaRepository;
import com.ecommerce.estiloriel.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        List<Produto> produtos = produtoRepository.findAll();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Integer id) {
        Optional<Produto> produtoOpt = produtoRepository.findById(id);
        if (produtoOpt.isPresent()) {
            return ResponseEntity.ok(produtoOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody ProdutoRequestDTO dto) {
        Optional<Categoria> categoriaOpt = categoriaRepository.findById(dto.getIdCategoria());
        if (!categoriaOpt.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        Categoria categoria = categoriaOpt.get();

        Produto produto = new Produto(
                dto.getNome(),
                dto.getDescricao(),
                dto.getPreco(),
                dto.getEstoque(),
                categoria,
                dto.getImagem(),
                dto.getData()
        );

        Produto savedProduto = produtoRepository.save(produto);

        return ResponseEntity.status(201).body(savedProduto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable Integer id, @RequestBody ProdutoRequestDTO dto) {
        Optional<Produto> produtoOpt = produtoRepository.findById(id);
        if (!produtoOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Optional<Categoria> categoriaOpt = categoriaRepository.findById(dto.getIdCategoria());
        if (!categoriaOpt.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        Produto produto = produtoOpt.get();
        Categoria categoria = categoriaOpt.get();

        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setPreco(dto.getPreco());
        produto.setEstoque(dto.getEstoque());
        produto.setCategoria(categoria);
        produto.setImagem(dto.getImagem());
        produto.setDataCadastro(dto.getData());

        Produto updatedProduto = produtoRepository.save(produto);

        return ResponseEntity.ok(updatedProduto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Optional<Produto> produtoOpt = produtoRepository.findById(id);
        if (!produtoOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        produtoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
