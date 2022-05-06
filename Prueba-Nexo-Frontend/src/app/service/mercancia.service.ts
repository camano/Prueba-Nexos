import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { AgregarMercancia } from '../models/AgregarMercancia';
import { Mercancia } from '../models/mercancia';

@Injectable({
  providedIn: 'root',
})
export class MercanciaService {
  URLBACKEND = environment.backendUrl;
  constructor(private httpClient: HttpClient) {}

  getMercanciaAll(nombre: string,nombreUsuario:string): Observable<Mercancia[]> {
    let params = new HttpParams();
    params = params.append('nombreProducto', String(nombre));
    params = params.append('nombreUsuario', String(nombreUsuario));

    const httpOptions = {
      Headers: new HttpHeaders({
        Accept: '*/*',
        'Content-Type': 'application/json',
      }),
      params: params,
    };
    return this.httpClient.get<Mercancia[]>(
      this.URLBACKEND + 'mercancia',
      httpOptions
    );
  }

  agregarMercancia(nuevaMercancia: AgregarMercancia): Observable<any> {
    return this.httpClient.post<any>(
      this.URLBACKEND + 'mercancia/addMercancia',
      nuevaMercancia
    );
  }

  getMercanciaBy(id: number): Observable<Mercancia> {
    return this.httpClient.get<Mercancia>(
      this.URLBACKEND + 'mercancia/getMercancia/' + id
    );
  }

  updateMercancia(
    nuevaMercancia: AgregarMercancia,
    id: any
  ): Observable<any> {
    return this.httpClient.put<any>(
      this.URLBACKEND + 'mercancia/updateMercancia/' + id,
      nuevaMercancia
    );
  }

  deleteMercancia(id: any,idUsuario:any): Observable<any> {
    return this.httpClient.delete<any>(
      this.URLBACKEND + 'mercancia/deleteMercancia/' + id +'/'+idUsuario
    );
  }
}
