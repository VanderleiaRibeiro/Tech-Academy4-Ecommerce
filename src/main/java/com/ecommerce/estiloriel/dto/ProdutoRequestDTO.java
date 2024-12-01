package com.ecommerce.estiloriel.dto;

public record ProdutoRequestDTO(String nome, String descricao, Double preco, Integer estoque, Integer idCategoria, String imagem) {
}
