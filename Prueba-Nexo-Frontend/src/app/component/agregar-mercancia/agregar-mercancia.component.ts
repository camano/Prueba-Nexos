import { Component, OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { AgregarMercancia } from 'src/app/models/AgregarMercancia';
import { HttpClient } from '@angular/common/http';
import { MercanciaService } from 'src/app/service/mercancia.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-agregar-mercancia',
  templateUrl: './agregar-mercancia.component.html',
  styleUrls: ['./agregar-mercancia.component.css'],
})
export class AgregarMercanciaComponent implements OnInit {
  today: Date = new Date();
  pipe = new DatePipe('en-US')
  
  nuevaMercancia: AgregarMercancia = {
    nombreProducto: '',
    cantidad: 0,
    fechaIngreso: '',
    usuario: 0,
  };

  constructor(
    private httpClient: HttpClient,
    private mercanciaService: MercanciaService,
    private active: ActivatedRoute,
    private router:Router
  ) {}

  ngOnInit(): void {}

  addMercancia(): void {
    this.nuevaMercancia.usuario=this.active.snapshot.paramMap.get('id');
    console.log("Nueva Mercancia :: ",this.nuevaMercancia);
    this.mercanciaService.agregarMercancia(this.nuevaMercancia).subscribe(
      (res) => {
        console.log('Respuesta ::', res);
        alert(res.mensaje);
        this.router.navigate(['/']);
      },
      (err) => {
        console.error('Error : ', err);
      }
    );
  }
}
