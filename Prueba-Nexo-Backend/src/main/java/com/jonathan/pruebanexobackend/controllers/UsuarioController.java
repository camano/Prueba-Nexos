package com.jonathan.pruebanexobackend.controllers;

import com.jonathan.pruebanexobackend.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<?>listarUsuarioControlle(){
        return new ResponseEntity<>(usuarioService.listarUsuario(), HttpStatus.OK);
    }

}
