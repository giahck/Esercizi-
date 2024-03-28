
import { Subscription } from 'rxjs';

import { Component, OnInit } from '@angular/core';
import { Card, Product } from 'src/app/module/card.interface';
import { CardService } from 'src/app/service/card.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit{
  sub!: Subscription;
  products: Product[] = []; // Corrected type definition
value:boolean=false;
  constructor(private cardSrv: CardService) {}

  ngOnInit(): void {
    this.sub = this.cardSrv.getCard().subscribe((results: Product[]) => {
      this.products = results;
      console.log(this.products);
      this.value=true
    });
  }
}