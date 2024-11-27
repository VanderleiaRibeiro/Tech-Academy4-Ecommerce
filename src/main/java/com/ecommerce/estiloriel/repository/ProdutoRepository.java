package com.ecommerce.estiloriel.repository;

import com.ecommerce.estiloriel.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
