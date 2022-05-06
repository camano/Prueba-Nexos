import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cargo } from 'src/app/models/Cargo';
import { Usuario } from 'src/app/models/Usuario';
import { UsuarioService } from 'src/app/service/usuario.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css'],
})
export class NavComponent implements OnInit {
  public listarUsuario: Usuario[] = [];
  public cargo: Cargo = {
    nombre: '',
  };

  constructor(private usuarioService: UsuarioService, private router: Router) {}

  ngOnInit(): void {
    this.listarUsuarios();
  }

  listarUsuarios(): void {
    this.usuarioService.getUsuarioAll().subscribe(
      (res) => {
        console.log('Respuesta : ', res);
        this.listarUsuario = res;
      },
      (err) => {
        console.error('Error : ', err);
      }
    );
  }

  
}
