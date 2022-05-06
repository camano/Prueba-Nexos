package com.jonathan.pruebanexobackend.services.serviceImpl;

import com.jonathan.pruebanexobackend.dto.UsuarioDto;
import com.jonathan.pruebanexobackend.entity.Usuario;
import com.jonathan.pruebanexobackend.excepciones.MercanciaException;
import com.jonathan.pruebanexobackend.repository.UsuarioRepository;
import com.jonathan.pruebanexobackend.services.UsuarioService;
import com.jonathan.pruebanexobackend.utils.MapearDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private MapearDto mapearDto;

    @Override
    public List<UsuarioDto> listarUsuario() {
        Sort sort = Sort.by("idUsuario").ascending();
        List<Usuario> listarUsuarios = usuarioRepository.findAll(sort);
        return listarUsuarios.stream().map(usuario -> mapearDto.mapearEntidadToDoUsuario(usuario)).collect(Collectors.toList());
    }

    @Override
    public UsuarioDto getUSuario(int id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()->{
           throw new MercanciaException(HttpStatus.BAD_REQUEST,"No se encontro el usuario");
        });
        return mapearDto.mapearEntidadToDoUsuario(usuario);
    }
}
