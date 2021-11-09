import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Movement } from '../model/Movement';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class HomeService {

  constructor(
    private http: HttpClient
  ) { }

  newMovement(movement: Movement): Observable<Movement> {
    return this.http.post<Movement>('http://localhost:8080/movimento/adicionar', movement);
  }

  findById(id: number): Observable<Movement> {
    return this.http.get<Movement>(`http://localhost:8080/movimento/pesquisar/${id}`)
  }

  getAllOpenMovement(): Observable<Movement[]> {
    return this.http.get<Movement[]>("http://localhost:8080/movimento/abertos")
  }

  getAllClosedMovement(): Observable<Movement[]> {
    return this.http.get<Movement[]>("http://localhost:8080/movimento/fechados")
  }

  editMovement(movement: Movement): Observable<Movement> {
    return this.http.put<Movement>("http://localhost:8080/movimento/editar", movement)
  }

}
