//package com.ecommerce.estiloriel.controller;
//
//import com.ecommerce.estiloriel.dto.AvaliacaoRequestDTO;
//import com.ecommerce.estiloriel.model.Avaliacao;
//import com.ecommerce.estiloriel.repository.AvaliacaoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/avaliacoes")
//public class AvaliacaoController {
//
//    @Autowired
//    private AvaliacaoRepository repository;
//
//    @GetMapping
//    public ResponseEntity<List<Avaliacao>> findAll() {
//        return ResponseEntity.ok(repository.findAll());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Avaliacao> findById(@PathVariable Integer id) {
//        return ResponseEntity.of(repository.findById(id));
//    }
//
//    @PostMapping
//    public ResponseEntity<Avaliacao> save(@RequestBody AvaliacaoRequestDTO dto) {
//        Avaliacao avaliacao = new Avaliacao();
//        avaliacao.setIdProduto(dto.getIdProduto());
//        avaliacao.setIdUsuario(dto.getIdUsuario());
//        avaliacao.setNota(dto.getNota());
//        avaliacao.setComentario(dto.getComentario());
//        avaliacao.setData(dto.getData());
//
//        return ResponseEntity.ok(repository.save(avaliacao));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Avaliacao> update(@PathVariable Integer id, @RequestBody AvaliacaoRequestDTO dto) {
//        return repository.findById(id)
//                .map(avaliacao -> {
//                    avaliacao.setNota(dto.getNota());
//                    avaliacao.setComentario(dto.getComentario());
//                    return ResponseEntity.ok(repository.save(avaliacao));
//                })
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Object> delete(@PathVariable Integer id) {
//        return repository.findById(id)
//                .map(avaliacao -> {
//                    repository.delete(avaliacao);
//                    return ResponseEntity.noContent().build();
//                })
//                .orElse(ResponseEntity.notFound().build());
//    }
//}
//

package com.ecommerce.estiloriel.controller;

import com.ecommerce.estiloriel.dto.AvaliacaoRequestDTO;
import com.ecommerce.estiloriel.model.Avaliacao;
import com.ecommerce.estiloriel.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/avaliacao")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoRepository repository;

    //retorna todas as avaliações
    @GetMapping
    public ResponseEntity<List<Avaliacao>> findAll() {
        List<Avaliacao> avaliacoes = repository.findAll();
        return ResponseEntity.ok(avaliacoes);
    }

    // retorna uma avaliação pelo id
    @GetMapping("/{id}")
    public ResponseEntity<Avaliacao> findById(@PathVariable Integer id) {
        Avaliacao avaliacao = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Avaliação não foi encontrada"));
        return ResponseEntity.ok(avaliacao);
    }

    // salva uma nova avaliação
    @PostMapping
    public ResponseEntity<Avaliacao> save(@RequestBody AvaliacaoRequestDTO dto) {
        if (dto.getComentario() == null || dto.getComentario().isEmpty()) {
            return ResponseEntity.status(428).build(); // Caso o comentário esteja vazio
        }

        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setIdProduto(dto.getIdProduto());
        avaliacao.setIdUsuario(dto.getIdUsuario());
        avaliacao.setNota(dto.getNota());
        avaliacao.setComentario(dto.getComentario());
        avaliacao.setData(dto.getData());

        repository.save(avaliacao);
        return ResponseEntity.ok(avaliacao);
    }

    //exclui uma avaliação
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Avaliacao avaliacao = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Avaliação não foi encontrada"));
        repository.delete(avaliacao);
        return ResponseEntity.noContent().build();
    }

    //atualiza uma avaliação existente
    @PutMapping("/{id}")
    public ResponseEntity<Avaliacao> update(@PathVariable Integer id, @RequestBody AvaliacaoRequestDTO dto) {
        if (dto.getComentario() == null || dto.getComentario().isEmpty()) {
            return ResponseEntity.status(428).build(); // Caso o comentário esteja vazio
        }

        Avaliacao avaliacao = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Avaliação não foi encontrada"));

        avaliacao.setIdProduto(dto.getIdProduto());
        avaliacao.setIdUsuario(dto.getIdUsuario());
        avaliacao.setNota(dto.getNota());
        avaliacao.setComentario(dto.getComentario());
        avaliacao.setData(dto.getData());

        repository.save(avaliacao);
        return ResponseEntity.ok(avaliacao);
    }
}
