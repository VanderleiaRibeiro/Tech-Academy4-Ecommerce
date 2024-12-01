package com.ecommerce.estiloriel.dto;

import java.util.Date;

public record AvaliacaoRequestDTO(Integer idAvaliacao, Integer idProduto, Integer idUsuario, Integer nota, String comentario, Date data) {
}
