import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Mercancia } from 'src/app/models/mercancia';
import { Usuario } from 'src/app/models/Usuario';
import { MercanciaService } from 'src/app/service/mercancia.service';
import { UsuarioService } from 'src/app/service/usuario.service';

@Component({
  selector: 'app-mercancias',
  templateUrl: './mercancias.component.html',
  styleUrls: ['./mercancias.component.css'],
})
export class MercanciasComponent implements OnInit {
  public mercancias: Mercancia[] = [];

  public nombreProducto: string = '';
  public nombreUsuario: string = '';
  public usuario?: Usuario;
  constructor(
    private mercanciaService: MercanciaService,
    private usuarioService: UsuarioService,
    private active: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {    
    this.getmercanciaAll();    
  }

  getmercanciaAll(): void {
    const params = this.active.snapshot.paramMap.get('id');    
    this.mercanciaService.getMercanciaAll(this.nombreProducto,this.nombreUsuario).subscribe(
      (res) => {
        console.log('Respuesta ::', res);
        this.mercancias = res;
      },
      (err) => {
        console.error('Error :: ', err);
      }
    );
    this.usuarioService.getUsuarioBy(params).subscribe(
      (res) => {
        console.log('Respuesta ::', res);
        if (res.mensaje) {
          alert(res.mensaje);
          this.router.navigate(['/usuario/mercancia/1']);
        }
        this.usuario = res;
        console.log('usuario :: ', this.usuario?.nombre);
      },
      (err) => {
        console.error('Error :: ', err);
      }
    );
  }

  eliminarMercancia(id: any, idUsuario: any): void {
    this.mercanciaService.deleteMercancia(id, idUsuario).subscribe(
      (res) => {
        alert(res.mensaje);
        window.location.reload();
      },
      (err) => {
        console.error('Error : ', err);
      }
    );
  }

  filtros():void{
    console.log("nombre usuario :",this.nombreUsuario);
    this.getmercanciaAll();
  }
}
