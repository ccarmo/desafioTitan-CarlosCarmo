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
}
