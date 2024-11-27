package com.ecommerce.estiloriel.repository;

import com.ecommerce.estiloriel.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
