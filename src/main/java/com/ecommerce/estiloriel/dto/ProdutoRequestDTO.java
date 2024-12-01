package com.ecommerce.estiloriel.dto;

import java.util.Date;

public record ProdutoRequestDTO(String nome, String descricao, Double preco, Integer estoque, Integer idCategoria, String imagem, Date dataCadastro) {
}
