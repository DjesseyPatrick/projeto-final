import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Comida } from '../modelo/comida';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ComidaService {

  private url: string = 'http://localhost:8080/comida';

  constructor(private http: HttpClient) { }
  selecionar(): Observable<Comida[]> {
    return this.http.get<Comida[]>(this.url);
  }
  cadastrar(comida: Comida): Observable<Comida> {
    return this.http.post<Comida>(this.url, comida);
  }
  editar(comida: Comida): Observable<Comida> {
    return this.http.put<Comida>(this.url, comida);
  }

  remover(id: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/${id}`);
  }
}
