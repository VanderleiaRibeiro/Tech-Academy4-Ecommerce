package com.ecommerce.estiloriel.dto;

import java.util.Date;

public record UsuarioRequestDTO(String nome, String email, String senha, Integer idEndereco, Integer telefone, Date dataCadastro ){
}
