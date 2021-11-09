import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { Movement } from '../model/Movement';
import { HomeService } from '../service/home.service';

@Component({
  selector: 'app-finalizarcarro',
  templateUrl: './finalizarcarro.component.html',
  styleUrls: ['./finalizarcarro.component.css']
})
export class FinalizarcarroComponent implements OnInit {

  movement: Movement = new Movement;

  idUser = environment.id;
  idValue: number;
  idMovement = environment.idMovement;

  constructor(
    private closeCar: HomeService, 
    private route: ActivatedRoute,
    private router: Router
 

    
  ) { }

  ngOnInit(): void {
    if (environment.id == 0) {
      this.router.navigate(['/login'])
    }
    window.scroll(0,0);
   
    let id = this.idMovement
    this.calculateById(id)
 
    
  }



  calculateById(id: number) {
    this.closeCar.calculateMovement(id).subscribe((resp: Movement) => {
      this.movement = resp
    })
  }



    finalizar() {
    this.movement.value.listMovement = [];

    this.closeCar.closeMovement(this.movement).subscribe((resp: Movement)=> {
      this.movement = resp;
      this.router.navigate(['/home'])
    })
  }

}
