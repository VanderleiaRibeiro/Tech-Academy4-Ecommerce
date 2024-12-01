package com.ecommerce.estiloriel.dto;

import java.util.Date;

public record LogPrecosRequestDTO(Integer idUsuario, Integer idProduto, Date data, Double valorAnterior, Double valorPosterior) {
}
