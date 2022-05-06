import { Usuario } from './Usuario';

export class Mercancia {
  idMercancia?: number;
  nombreProducto: string;
  cantidad: number;
  fechaIngreso: string;
  usuario: Usuario;
  constructor(
    nombreProducto: string,
    cantidad: number,
    fechaIngreso: string,
    usuario: Usuario
  ) {
    this.nombreProducto = nombreProducto;
    this.cantidad = cantidad;
    this.fechaIngreso = fechaIngreso;
    this.usuario = usuario;
  }
}
