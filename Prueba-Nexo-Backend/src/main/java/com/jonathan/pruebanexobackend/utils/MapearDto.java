package com.jonathan.pruebanexobackend.utils;

import com.jonathan.pruebanexobackend.dto.AgregarMercanciaDto;
import com.jonathan.pruebanexobackend.dto.MercanciaDto;
import com.jonathan.pruebanexobackend.dto.UsuarioDto;
import com.jonathan.pruebanexobackend.entity.Mercancia;
import com.jonathan.pruebanexobackend.entity.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapearDto {

    @Autowired
    private ModelMapper modelMapper;

    public AgregarMercanciaDto mapearEntidadToDtoMercancia(Mercancia mercancia) {
        return this.modelMapper.map(mercancia, AgregarMercanciaDto.class);
    }

    public Mercancia mapearDtoToEntidadMercancia(AgregarMercanciaDto agregarMercanciaDto) {
        return this.modelMapper.map(agregarMercanciaDto, Mercancia.class);
    }

    public MercanciaDto mapearEntidadToDoMercanciaUsuario(Mercancia mercancia) {
        return this.modelMapper.map(mercancia, MercanciaDto.class);
    }

    public UsuarioDto mapearEntidadToDoUsuario(Usuario usuario) {
        return this.modelMapper.map(usuario, UsuarioDto.class);
    }

}
