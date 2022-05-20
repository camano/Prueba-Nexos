package com.jonathan.pruebanexobackend.controllers;

import com.jonathan.pruebanexobackend.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<?>listarUsuarioControlle(){
        return new ResponseEntity<>(usuarioService.listarUsuario(), HttpStatus.OK);
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<?>getUsuario(@PathVariable("idUsuario") int id){
        return  new ResponseEntity<>(usuarioService.getUSuario(id),HttpStatus.OK);
    }

    @GetMapping("/mensaje")
    public String mensaje(){
        return  "Hola mensaje de prueba mejorado okok";
    }
}
