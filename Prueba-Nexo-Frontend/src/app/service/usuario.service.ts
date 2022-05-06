import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Usuario } from '../models/Usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  URLBACKEND= environment.backendUrl;
  constructor(private httpClient:HttpClient) { }

  getUsuarioAll():Observable<any[]>{
    return this.httpClient.get<Usuario[]>(this.URLBACKEND + "usuario");
  }

  getUsuarioBy(id:any):Observable<any>{
    return this.httpClient.get<Usuario>(this.URLBACKEND + "usuario/"+ id);
  }
}
