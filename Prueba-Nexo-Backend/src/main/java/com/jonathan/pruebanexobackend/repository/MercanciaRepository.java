package com.jonathan.pruebanexobackend.repository;

import java.util.List;
import java.util.Optional;

import com.jonathan.pruebanexobackend.entity.Mercancia;
import com.jonathan.pruebanexobackend.entity.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MercanciaRepository extends JpaRepository<Mercancia, Integer> {

    boolean existsByNombreProducto(String nombre);

    Optional<Mercancia> findByIdMercanciaAndUsuario(int id, Usuario usuario);

    @Query(value = "SELECT * FROM  mercancia inner join  usuario on mercancia.usuario_id=usuario.id_usuario " +
            " where nombre_producto iLIKE ?1 and  usuario.nombre iLIKE ?2  ORDER BY id_mercancia desc"
            , nativeQuery = true)
    List<Mercancia> listarMercanciaFiltro(String nombre, String localDate);

}
