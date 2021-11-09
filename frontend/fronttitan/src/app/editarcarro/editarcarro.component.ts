import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { Movement } from '../model/Movement';
import { HomeService } from '../service/home.service';

@Component({
  selector: 'app-editarcarro',
  templateUrl: './editarcarro.component.html',
  styleUrls: ['./editarcarro.component.css']
})
export class EditarcarroComponent implements OnInit {

  movement: Movement = new Movement;

  idUser = environment.id;
  idValue: number;
  idMovement = environment.idMovement;

  constructor(
    private editCar: HomeService, 
    private route: ActivatedRoute,
    private router: Router
 

    
  ) { }

  ngOnInit(): void {
    if (environment.id == 0) {
      this.router.navigate(['/login'])
    }
    window.scroll(0,0);
   
    let id = this.idMovement
    this.findByIdMovement(id)
    
  }

  findByIdMovement(id: number) {
    this.editCar.findById(id).subscribe((resp: Movement) => {
      this.movement = resp
    })
  }



  editar() {
    this.movement.value.listMovement = [];

    this.editCar.editMovement(this.movement).subscribe((resp: Movement)=> {
      this.movement = resp;
      this.router.navigate(['/home'])
    })
  }

}
