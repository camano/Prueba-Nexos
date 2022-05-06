import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterLinkActive } from '@angular/router';
import { AgregarMercancia } from 'src/app/models/AgregarMercancia';
import { Mercancia } from 'src/app/models/mercancia';
import { Usuario } from 'src/app/models/Usuario';
import { MercanciaService } from 'src/app/service/mercancia.service';

@Component({
  selector: 'app-detalle-mercancia',
  templateUrl: './detalle-mercancia.component.html',
  styleUrls: ['./detalle-mercancia.component.css'],
})
export class DetalleMercanciaComponent implements OnInit {
  mercancia: AgregarMercancia = {
    nombreProducto: '',
    cantidad: 0,
    fechaIngreso: '',
    usuario: 1,
  };
  nombreUsuario: string = '';

  constructor(
    private active: ActivatedRoute,
    private mercanciaService: MercanciaService
  ) {}

  ngOnInit(): void {
    const id = this.active.snapshot.paramMap.get('id');
    this.getByMercancia(id);
  }

  getByMercancia(id: any) {
    this.mercanciaService.getMercanciaBy(id).subscribe(
      (res) => {
        this.mercancia = res;
        this.nombreUsuario = res.usuario.nombre;
      },
      (err) => {
        console.log('Error :: ', err);
      }
    );
  }

  updateMercancia(): void {
    const id = this.active.snapshot.paramMap.get('id');
    const idUsuario = this.active.snapshot.paramMap.get('idUsuario');
    this.mercancia.usuario = idUsuario;
    this.mercanciaService.updateMercancia(this.mercancia, id).subscribe(
      (res) => {
        console.log('Respuesta ::', res);
        this.nombreUsuario = res.mercancia.usuario.nombre;
        alert(res.mensaje);
      },
      (errr) => {
        console.error('Error :: ', errr);
      }
    );
  }
}
