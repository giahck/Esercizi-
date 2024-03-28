import { CardService } from 'src/app/service/card.service';
import { Product } from './../../module/card.interface';
import { Component, Input } from '@angular/core';
import { FavoritsService } from 'src/app/service/favorits.service';

@Component({
  selector: 'app-home-body',
  templateUrl: './home-body.component.html',
  styleUrls: ['./home-body.component.scss']
})
export class HomeBodyComponent {
@Input() product!:Product;

constructor(private cardSrv:CardService,private favSrv:FavoritsService){}
addCarello(product:Product){
      this.cardSrv.addCarello(product)      
}
addFav(prod:Product){
 this.favSrv.addFav(prod);  
}

}
