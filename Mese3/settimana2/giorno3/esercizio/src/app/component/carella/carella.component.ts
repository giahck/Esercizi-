import { Component, OnInit } from '@angular/core';
import { Card, Carello } from 'src/app/module/card.interface';

import { CardService } from 'src/app/service/card.service';

@Component({
  selector: 'app-carella',
  templateUrl: './carella.component.html',
  styleUrls: ['./carella.component.scss']
})
export class CarellaComponent implements OnInit{
  carello!:Carello[];
constructor(private productSrv:CardService){}
ngOnInit(): void {
  this.productSrv.Carello.subscribe(elem => this.carello=elem)
}

decrementaCarell(id:number){
this.productSrv.decrementaCarello(id);
}
}
