package com.ecommerce.estiloriel.dto;

public record ItensPedidoRequestDTO(Integer idProduto, Integer quantidade, Double preco) {
    public Double getPreco() {
        return 0.0;
    }

    public Integer getIdPedido() {
        return 0;
    }

    public Integer getIdProduto() {
        return 0;
    }

    public Integer getQuantidade() {
        return 0;
    }
}
