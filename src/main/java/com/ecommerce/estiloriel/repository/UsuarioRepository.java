package com.ecommerce.estiloriel.repository;

import com.ecommerce.estiloriel.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
