import { Component, OnInit } from '@angular/core';
import { MoviesPopular, MoviesToprated } from 'src/app/models/db-interface';
import { FavoriteService } from 'src/app/services/favorite.service';
import { MuvieSService } from 'src/app/services/muvie-s.service';

@Component({
  selector: 'app-mouvie',
  templateUrl: './mouvie.component.html',
  styleUrls: ['./mouvie.component.scss']
})
export class MouvieComponent implements OnInit{
  films: MoviesPopular[] = [];
  coruselfilm: MoviesPopular[][] = [];
  coruselfilmTop: MoviesPopular[][] = [];
  muviFavorite: MoviesPopular[] = [];
  activeMipiace: boolean = false;
  url: string = 'http://image.tmdb.org/t/p/w500';
  constructor(private muvieSrv: MuvieSService, private favSrv: FavoriteService) { }
  ngOnInit(): void {
    this.muvieSrv.getMuvies().subscribe(
      (data: MoviesPopular[]) => { 
       this.films = data;        
       for (let i = 0; i < this.films.length; i += 5) {
        this.coruselfilm.push(this.films.slice(i, i + 4));
      }},
      (err) => {
        console.log(err.error);
      });
    this.muvieSrv.getMoviesToprated().subscribe(
      (data: MoviesToprated[]) => { 
       this.films = data;        
       for (let i = 0; i < this.films.length; i += 5) {
        this.coruselfilmTop.push(this.films.slice(i, i + 3));
      }},
      (err) => {
        console.log(err.error);
      });
      this.favSrv.muviFavoriti.subscribe((data) => {
        this.muviFavorite = data;
      }
      );
     
  }
  exchange(id: number) {
    console.log(id);
    
   this.favSrv.cambioFavorito(id);
   
  }

}
