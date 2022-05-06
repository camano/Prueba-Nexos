import { Cargo } from "./Cargo";

export class Usuario {
    idUsuario?:number;
    nombre : string;
    edad:number;
    fechaIngreso:string;
    idCargo:number;
    cargo:Cargo;
  constructor(nombre : string,edad:number,fechaIngreso:string,idCargo:number,cargo:Cargo) {
      this.nombre=nombre;
      this.edad=edad;
      this.fechaIngreso=fechaIngreso;
      this.idCargo=idCargo;
      this.cargo=cargo;
  }
}
