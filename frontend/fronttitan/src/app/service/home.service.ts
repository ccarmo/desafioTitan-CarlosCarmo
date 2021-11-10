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
    return this.http.post<Movement>('https://desafiotitan.herokuapp.com/movimento/adicionar', movement);
  }

  findById(id: number): Observable<Movement> {
    return this.http.get<Movement>(`https://desafiotitan.herokuapp.com/movimento/pesquisar/${id}`)
  }

  getAllOpenMovement(): Observable<Movement[]> {
    return this.http.get<Movement[]>("https://desafiotitan.herokuapp.com/movimento/abertos")
  }

  getAllClosedMovement(): Observable<Movement[]> {
    return this.http.get<Movement[]>("https://desafiotitan.herokuapp.com/movimento/fechados")
  }

  editMovement(movement: Movement): Observable<Movement> {
    return this.http.put<Movement>("https://desafiotitan.herokuapp.com/movimento/editar", movement)
  }

  calculateMovement(id: number): Observable<Movement> {
    return this.http.get<Movement>(`https://desafiotitan.herokuapp.com/movimento/calcular/${id}`)
  }

  closeMovement(movement: Movement): Observable<Movement> {
    return this.http.put<Movement>("https://desafiotitan.herokuapp.com/movimento/finalizar", movement)
  }

}
