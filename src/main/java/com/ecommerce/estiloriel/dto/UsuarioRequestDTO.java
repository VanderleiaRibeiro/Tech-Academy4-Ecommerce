package com.ecommerce.estiloriel.dto;

public record UsuarioRequestDTO(
        Integer idUsuario,
        String nome,
        String email,
        String senha,
        Integer idEndereco,
        String telefone
) {

}
