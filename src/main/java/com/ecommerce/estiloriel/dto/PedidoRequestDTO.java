package com.ecommerce.estiloriel.dto;

import java.util.Date;

public record PedidoRequestDTO(Integer idPedido,Integer idUsuario, Date data, Integer idStatus, Double total) {
}
