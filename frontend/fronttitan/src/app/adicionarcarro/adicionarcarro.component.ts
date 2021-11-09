import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { Movement } from '../model/Movement';
import { User } from '../model/User';
import { Value } from '../model/Value';
import { HomeService } from '../service/home.service';
import { ValueService } from '../service/value.service';

@Component({
  selector: 'app-adicionarcarro',
  templateUrl: './adicionarcarro.component.html',
  styleUrls: ['./adicionarcarro.component.css']
})
export class AdicionarcarroComponent implements OnInit {

  movement: Movement = new Movement;
  user: User = new User;
  value: Value = new Value;
  listValue: Value[]
  idUser = environment.id;
  idValue: number;
  

  constructor(
    private addCar: HomeService, 
    private router: Router,
    private valueS: ValueService

    
  ) { }

  ngOnInit(): void {
    if (environment.id == 0) {
      this.router.navigate(['/login'])
    }
    window.scroll(0,0);
    this.getAllValues();
    
  }

  getAllValues() {
    this.valueS.getAll().subscribe((resp: Value[]) => {
      this.listValue = resp
    })
  }

  findByIdValue() {
    this.valueS.getById(this.idValue).subscribe((resp: Value) => {
      this.value = resp;
    })
  }

  adicionar() {

    this.value.id = this.idValue
    this.movement.value = this.value

    this.movement.value.listMovement = [];
    
    this.user.id = this.idUser
    this.movement.user = this.user
    console.log(this.movement.user)
    this.addCar.newMovement(this.movement).subscribe((resp: Movement)=> {
      this.movement = resp;

      this.router.navigate(['/home'])
    })
  }

}
