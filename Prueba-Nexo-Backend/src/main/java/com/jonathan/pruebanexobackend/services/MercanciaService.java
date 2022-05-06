package com.jonathan.pruebanexobackend.services;

import java.time.LocalDate;
import java.util.List;

import com.jonathan.pruebanexobackend.dto.AgregarMercanciaDto;
import com.jonathan.pruebanexobackend.dto.MercanciaDto;

public interface MercanciaService {

    List<MercanciaDto> listarMercancia(String nombreProducto, String fecha);

    MercanciaDto getMercancia(int id);

    MercanciaDto addMercancia(AgregarMercanciaDto agregarMercanciaDto);

    MercanciaDto updateMercancia(AgregarMercanciaDto agregarMercanciaDto, int id);

    boolean deleteMercancia(int id,int idUsuario);


}
