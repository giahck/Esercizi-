import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/module/card.interface';
import { FavoritsService } from 'src/app/service/favorits.service';

@Component({
  selector: 'app-fav',
  templateUrl: './fav.component.html',
  styleUrls: ['./fav.component.scss']
})
export class FavComponent implements OnInit {
favs!:Product[]
constructor(public prSrv:FavoritsService){}
ngOnInit(): void {
  this.prSrv.favList.subscribe((elem:Product[])=>{this.favs=elem})
  console.log(this.favs);
  
}


}
