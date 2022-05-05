package com.jonathan.pruebanexobackend.services;

import com.jonathan.pruebanexobackend.dto.AgregarMercanciaDto;
import com.jonathan.pruebanexobackend.dto.MercanciaDto;
import com.jonathan.pruebanexobackend.entity.Mercancia;

import java.util.List;

public interface MercanciaService {

    List<MercanciaDto> listarMercancia(String nombreProducto);

    MercanciaDto getMercancia(int id);

    MercanciaDto addMercancia(AgregarMercanciaDto agregarMercanciaDto);

    MercanciaDto updateMercancia(AgregarMercanciaDto agregarMercanciaDto, int id);

    boolean deleteMercancia(int id,int idUsuario);


}
