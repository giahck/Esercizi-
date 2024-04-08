
import { environment } from 'src/environments/environment.development';

import { Component, OnInit } from '@angular/core';
import { Favorite, MoviesPopular, MoviesToprated } from 'src/app/models/db-interface';
import { FavoriteService } from 'src/app/services/favorite.service';
import { FavoriteModule } from './favorite.module';
@Component({
  selector: 'app-favorite',
  templateUrl: './favorite.component.html',
  styleUrls: ['./favorite.component.scss'],
})
export class FavoriteComponent implements OnInit {
  urlimg=environment.urlimg;
  favorit: Favorite[] = [];
  muviFavorit: MoviesPopular[] = [];
  validate:boolean=false;
  constructor(private favSrv: FavoriteService) {}
  ngOnInit(): void {
   this.favSrv.favoriti.subscribe((data) => {
      this.favorit = data;
      /* console.log(this.favorit); */
    });
   this.favSrv.muviFavoriti.subscribe((data) => {
    console.log(data);
    
     data.map(elem=>{
      
      
      this.muviFavorit.push(elem)});
      console.log(this.muviFavorit);
      this.validate=true;      
    })
  }
deselezione(id:number){
  console.log(id);
  
  this.favSrv.cambioFavorito(id);
}
}