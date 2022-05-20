package com.jonathan.pruebanexobackend.services.serviceImpl;

import com.jonathan.pruebanexobackend.dto.AgregarMercanciaDto;
import com.jonathan.pruebanexobackend.dto.MercanciaDto;
import com.jonathan.pruebanexobackend.entity.Mercancia;
import com.jonathan.pruebanexobackend.entity.Usuario;
import com.jonathan.pruebanexobackend.excepciones.MercanciaException;
import com.jonathan.pruebanexobackend.repository.MercanciaRepository;
import com.jonathan.pruebanexobackend.repository.UsuarioRepository;
import com.jonathan.pruebanexobackend.services.MercanciaService;
import com.jonathan.pruebanexobackend.utils.MapearDto;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import org.slf4j.Logger;


import java.util.stream.Collectors;


@Service
public class MercanciaServiceImpl implements MercanciaService {

    private final static Logger logger = LoggerFactory.getLogger(MercanciaServiceImpl.class);
    @Autowired
    private MercanciaRepository mercanciaRepository;

    @Autowired
    private MapearDto mapearDto;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<MercanciaDto> listarMercancia(String nombreProducto,String nombreUsuario) {
        /*Sort sort= Sort.by("idMercancia").descending();
        List<Mercancia> mercanciaList = mercanciaRepository.findAll(sort);*/
        List<Mercancia> mercanciaList = mercanciaRepository.listarMercanciaFiltro(nombreProducto,nombreUsuario);
        return mercanciaList.stream()
                .map(mercancia -> mapearDto.mapearEntidadToDoMercanciaUsuario(mercancia))
                /*.flatMap(mercanciaDto -> {
                    if(nombreProducto.equalsIgnoreCase("") && nombreUsuario.equalsIgnoreCase("")){
                        return Stream.of(mercanciaDto);
                    }
                    if (mercanciaDto.getNombreProducto().equalsIgnoreCase(nombreProducto) || mercanciaDto.getUsuario().getNombre().equalsIgnoreCase(nombreUsuario)){
                        return Stream.of(mercanciaDto);
                    }
                    return Stream.empty();
                })*/
                .collect(Collectors.toList());
    }


    @Override
    public MercanciaDto getMercancia(int id) {
        try {
            Mercancia mercancia = mercanciaRepository.findById(id).orElseThrow(() -> {
                throw new MercanciaException(HttpStatus.BAD_REQUEST, "No existe la mercancia");
            });
            return mapearDto.mapearEntidadToDoMercanciaUsuario(mercancia);
        } catch (DataIntegrityViolationException sqlExceptionHelper) {
            throw new MercanciaException(HttpStatus.BAD_REQUEST, "Hubo un error a listar Mercancia");
        }
    }

    @Override
    public MercanciaDto addMercancia(AgregarMercanciaDto agregarMercanciaDto) {
        try {
            logger.info("Datos enviados :: " + agregarMercanciaDto);
            if (mercanciaRepository.existsByNombreProducto(agregarMercanciaDto.getNombreProducto())) {
                throw new MercanciaException(HttpStatus.BAD_REQUEST, "El nombre del producto ya se encuentra usado, use otro");
            }
            Usuario usuario = usuarioRepository.findById(agregarMercanciaDto.getUsuario()).orElseThrow(() -> {
                throw new MercanciaException(HttpStatus.BAD_REQUEST, "El usuario No se encuentra registrado en el sistema");
            });
            int fecha = agregarMercanciaDto.getFechaIngreso().compareTo(LocalDate.now());

            if (fecha  > 0) {
                throw new MercanciaException(HttpStatus.BAD_REQUEST, "La fecha de ingreso debe ser menor o igual a la fecha actual.");
            }
            Mercancia mercancia = mapearDto.mapearDtoToEntidadMercancia(agregarMercanciaDto);
            mercancia.setUsuario(usuario);

            Mercancia nuevaMercancia = mercanciaRepository.save(mercancia);

            return mapearDto.mapearEntidadToDoMercanciaUsuario(nuevaMercancia);

        } catch (DataIntegrityViolationException sqlExceptionHelper) {
            throw new MercanciaException(HttpStatus.BAD_REQUEST, "Hubo un error en agregar Mercancía");
        }
    }

    @Override
    public MercanciaDto updateMercancia(AgregarMercanciaDto agregarMercanciaDto, int id) {
        try {
            logger.info("Datos enviados :: " + agregarMercanciaDto);
            Mercancia mercancia = mercanciaRepository.findById(id).orElseThrow(() -> {
                throw new MercanciaException(HttpStatus.BAD_REQUEST, "No se encuentro la mercancia");
            });
            Usuario usuario = usuarioRepository.findById(agregarMercanciaDto.getUsuario()).orElseThrow(() -> {
                throw new MercanciaException(HttpStatus.BAD_REQUEST, "El usuario No se encuentra registrado en el sistema");
            });
            int fecha = agregarMercanciaDto.getFechaIngreso().compareTo(LocalDate.now());
            if (fecha == 1) {
                throw new MercanciaException(HttpStatus.BAD_REQUEST, "La fecha de ingreso debe ser menor o igual a la fecha actual.");
            }
            mercancia.setCantidad(agregarMercanciaDto.getCantidad());
            mercancia.setFechaIngreso(agregarMercanciaDto.getFechaIngreso());
            mercancia.setNombreProducto(agregarMercanciaDto.getNombreProducto());
            mercancia.setUsuario(usuario);
            Mercancia editarMercancia = mercanciaRepository.save(mercancia);

            return mapearDto.mapearEntidadToDoMercanciaUsuario(editarMercancia);
        } catch (DataIntegrityViolationException sqlExceptionHelper) {
            throw new MercanciaException(HttpStatus.BAD_REQUEST, "Hubo un error a actualizar la mercancia");
        }
    }

    @Override
    public boolean deleteMercancia(int id, int idUsuario) {
        try {
            Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow(() -> {
                throw new MercanciaException(HttpStatus.BAD_REQUEST, "El usuario No se encuentra registrado en el sistema");
            });
            Mercancia mercancia = mercanciaRepository.findByIdMercanciaAndUsuario(id, usuario).orElseThrow(() -> {
                throw new MercanciaException(HttpStatus.BAD_REQUEST, "Este Usuario no puede eliminar esta mercancia");
            });
            mercanciaRepository.delete(mercancia);
            return true;
        } catch (DataIntegrityViolationException sqlExceptionHelper) {
            throw new MercanciaException(HttpStatus.BAD_REQUEST, "Hubo un error en Eliminar la mercancia");
        }

    }

}
