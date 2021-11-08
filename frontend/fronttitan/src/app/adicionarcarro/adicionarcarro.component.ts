import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Movement } from '../model/Movement';

@Component({
  selector: 'app-adicionarcarro',
  templateUrl: './adicionarcarro.component.html',
  styleUrls: ['./adicionarcarro.component.css']
})
export class AdicionarcarroComponent implements OnInit {

  movement: Movement = new Movement;

  constructor(
    
    private router: Router,

    
  ) { }

  ngOnInit(): void {
    window.scroll(0,0);
  }

}
