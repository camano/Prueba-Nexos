export class AgregarMercancia {
  nombreProducto: string;
  cantidad: number;
  fechaIngreso: any;
  usuario: any;

  constructor(
    nombreProducto: string,
    cantidad: number,
    fechaIngreso: any,
    usuario: any
  ) {
    this.nombreProducto = nombreProducto;
    this.cantidad = cantidad;
    this.fechaIngreso = fechaIngreso;
    this.usuario = usuario;
  }
}
