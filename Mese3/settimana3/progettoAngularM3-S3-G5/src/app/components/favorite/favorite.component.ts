import { environment } from 'src/environments/environment.development';

import { Component, OnInit } from '@angular/core';
import { MoviesPopular, MoviesToprated } from 'src/app/models/db-interface';
import { FavoriteService } from 'src/app/services/favorite.service';
@Component({
  selector: 'app-favorite',
  templateUrl: './favorite.component.html',
  styleUrls: ['./favorite.component.scss']
})
export class FavoriteComponent implements OnInit{
  validate: boolean = false;
  movie:MoviesToprated[]|MoviesPopular[] = [];
  apiUrl=environment.apiURL;
  imgUrl=environment.urlimg; 
  constructor(private favSrv:FavoriteService) { 
  }
  ngOnInit(): void {
      
    this.favSrv.serchFavorite().subscribe((movies) => {
      // Do something with the movies
      console.log(movies);
      this.validate = true;
      this.movie = movies;
    });
  }
  deselezione(key:number)
  {
   this.favSrv.disactiveFavorite(key);
  }
}
