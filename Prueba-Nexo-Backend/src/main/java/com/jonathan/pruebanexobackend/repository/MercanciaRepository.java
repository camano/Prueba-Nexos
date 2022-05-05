package com.jonathan.pruebanexobackend.repository;

import com.jonathan.pruebanexobackend.dto.MercanciaDto;
import com.jonathan.pruebanexobackend.entity.Mercancia;
import com.jonathan.pruebanexobackend.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MercanciaRepository extends JpaRepository<Mercancia, Integer> {

    boolean existsByNombreProducto(String nombre);

    Optional<Mercancia> findByIdMercanciaAndUsuario(int id, Usuario usuario);

    @Query(value = "SELECT * FROM  mercancia where nombre_producto LIKE ?1 ORDER BY id_mercancia desc"
            , nativeQuery = true)
    List<Mercancia> listarMercanciaFiltro(String nombre);

}
