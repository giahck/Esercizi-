import { CardService } from 'src/app/service/card.service';
import { Product } from './../../module/card.interface';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-home-body',
  templateUrl: './home-body.component.html',
  styleUrls: ['./home-body.component.scss']
})
export class HomeBodyComponent {
@Input() product!:Product;

constructor(private cardSrv:CardService){}
addCarello(product:Product){
      this.cardSrv.addCarello(product)      
}

}
