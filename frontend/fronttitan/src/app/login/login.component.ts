import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { UserDTO } from '../model/UserDTO';
import { LoginService } from '../service/login.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userDTO: UserDTO = new UserDTO();
  id = environment.id;
  username = environment.username;


  constructor(
    private login: LoginService,
    private router: Router
    
  ) { }

  ngOnInit(): void {

    window.scroll(0,0)
  }

  entrar() {
    this.login.loginUser(this.userDTO).subscribe((resp: UserDTO)=> {
      this.userDTO = resp;

      environment.id       = this.userDTO.id;
      environment.username = this.userDTO.username;
      this.router.navigate(['/home'])
    })
  }

  sair(){
    this.router.navigate(['/login'])
    environment.id = 0
    environment.username = ''
    
  }


}


 
