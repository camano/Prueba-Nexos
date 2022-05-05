package com.jonathan.pruebanexobackend.controllers;

import com.jonathan.pruebanexobackend.dto.AgregarMercanciaDto;
import com.jonathan.pruebanexobackend.dto.MensajeDto;
import com.jonathan.pruebanexobackend.dto.MercanciaDto;
import com.jonathan.pruebanexobackend.services.MercanciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/mercancia")
public class MercanciaController {
    @Autowired
    private MercanciaService mercanciaService;

    @GetMapping()
    public ResponseEntity<?> listarMercancias(@RequestParam String nombreProducto) {
        String nombreFiltro = "".concat("%").concat(nombreProducto).concat("%");
        System.out.println("nombreFiltro = " + nombreFiltro);
        return new ResponseEntity<>(mercanciaService.listarMercancia(nombreFiltro), HttpStatus.OK);
    }

    @PostMapping("/addMercancia")
    public ResponseEntity<?> addMercanciaController(@Valid @RequestBody AgregarMercanciaDto agregarMercanciaDto) {
        MercanciaDto mercanciaDto =mercanciaService.addMercancia(agregarMercanciaDto);
        Map<String,Object> mensaje= new HashMap<>();
        mensaje.put("mensaje","Se agrego una nueva Mercancia");
        mensaje.put("mercancia",mercanciaDto);
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @PutMapping("updateMercancia/{id}")
    public ResponseEntity<?> updateMercanciaController(@PathVariable("id") int id, @RequestBody AgregarMercanciaDto agregarMercanciaDto) {
        MercanciaDto mercanciaDto=mercanciaService.updateMercancia(agregarMercanciaDto, id);
        Map<String,Object> mensaje= new HashMap<>();
        mensaje.put("mensaje","Se Actualizo la mercancia");
        mensaje.put("mercancia",mercanciaDto);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @DeleteMapping("deleteMercancia/{id}/{idUsuario}")
    public ResponseEntity<?> deleteMercancia(@PathVariable("id") int id, @PathVariable("idUsuario") int idUsuario) {
        MensajeDto mensajeDto= new MensajeDto();
        if(mercanciaService.deleteMercancia(id, idUsuario)){
            mensajeDto.setMensaje("Se Elimino La Mercancia ");
        }
        return new ResponseEntity<>(mensajeDto, HttpStatus.OK);
    }

    @GetMapping("getMercancia/{id}")
    public ResponseEntity<?> getMercanciaIdController(@PathVariable("id") int id) {
        return new ResponseEntity<>(mercanciaService.getMercancia(id), HttpStatus.OK);
    }
}
