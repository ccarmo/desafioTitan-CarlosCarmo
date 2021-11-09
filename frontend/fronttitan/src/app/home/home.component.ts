import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { Movement } from '../model/Movement';
import { HomeService } from '../service/home.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  movement: Movement = new Movement

  listOpenMovement: Movement[]
  listClosedMovement: Movement[]
  
  idMovement: number
  
  constructor(
    private movementS: HomeService,
    private router: Router
  ) { }

  ngOnInit(): void {
    if (environment.id == 0) {
      this.router.navigate(['/login'])
    }
    window.scroll(0,0);
    this.getAllClosedMovement()
    this.getAllOpenMovement()
  }


  getAllOpenMovement() {
    this.movementS.getAllOpenMovement().subscribe((resp: Movement[]) => {
      this.listOpenMovement = resp;
    })
  }

  getAllClosedMovement() {
    this.movementS.getAllClosedMovement().subscribe((resp: Movement[]) => {
      this.listClosedMovement = resp;
    })
  }

  findByIdOpenMovement() {
    environment.idMovement = this.idMovement
    this.movementS.findById(this.idMovement).subscribe((resp: Movement) => {
      this.movement = resp;
    })
  }

  findByIdClosedMovement() {
    environment.idMovement = this.idMovement
    this.movementS.findById(this.idMovement).subscribe((resp: Movement) => {
      this.movement = resp;
    })
  }

}
