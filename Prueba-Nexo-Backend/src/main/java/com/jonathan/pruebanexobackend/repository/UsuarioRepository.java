package com.jonathan.pruebanexobackend.repository;

import com.jonathan.pruebanexobackend.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
