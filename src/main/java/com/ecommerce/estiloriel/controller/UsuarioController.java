package com.ecommerce.estiloriel.controller;

import com.ecommerce.estiloriel.dto.UsuarioRequestDTO;
import com.ecommerce.estiloriel.model.Endereco;
import com.ecommerce.estiloriel.model.Usuario;
import com.ecommerce.estiloriel.repository.EnderecoRepository;
import com.ecommerce.estiloriel.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> usuarios = this.usuarioRepository.findAll();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Integer id) {
        Usuario usuario = this.usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody UsuarioRequestDTO dto) {
        if (dto.nome().isEmpty() || dto.email().isEmpty() || dto.senha().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        Endereco endereco = enderecoRepository.findById(dto.idEndereco())
                .orElseThrow(() -> new IllegalArgumentException("Endereço não encontrado"));

        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setSenha(dto.senha());
        usuario.setEndereco(endereco);
        usuario.setTelefone(dto.telefone());
        usuario.setDataCadastro(dto.dataCadastro());

        this.usuarioRepository.save(usuario);

        return ResponseEntity.status(201).body(usuario);
    }
}
