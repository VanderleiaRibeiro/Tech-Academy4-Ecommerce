package com.ecommerce.estiloriel.repository;

import com.ecommerce.estiloriel.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
