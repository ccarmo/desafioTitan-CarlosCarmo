import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UserDTO } from '../model/UserDTO';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(
    private http: HttpClient
  ) { }
  
  loginUser(userDTO: UserDTO): Observable<UserDTO> {
    return this.http.put<UserDTO>('https://desafiotitan.herokuapp.com/usuario/entrar', userDTO);
  }
}
