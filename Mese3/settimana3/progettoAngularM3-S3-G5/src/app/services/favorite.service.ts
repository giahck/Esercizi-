
import { MuvieSService } from 'src/app/services/muvie-s.service';

import { HttpClient } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import {
  Favorite,
  MoviesPopular,
  MoviesToprated,
} from '../models/db-interface';
import { BehaviorSubject, Observable } from 'rxjs';
import { environment } from 'src/environments/environment.development';
//chiamo apena faccio login
@Injectable({
  providedIn: 'root',
})
export class FavoriteService {
  favoriti = new BehaviorSubject<Favorite[]>([]);
  muviFavoriti = new BehaviorSubject<MoviesToprated[]>([]);
  constructor(private muvSrv: MuvieSService, private http: HttpClient) {}
  iniUser(id: number) {
    //carico tutto il file dei favoriti del user connesso viene dichiarato nel ahuth service

    
    let arr: MoviesToprated[] = [];
    this.http
      .get<Favorite[]>(environment.apiURL + 'favorites?userId=' + id)
      .subscribe((elem) => {
        
        
        if(elem.length!==0){
        this.favoriti.next(elem);
      
        this.favoriti.getValue().map((elem) => {
          this.muvSrv
            .ricercaMuvieToprated(elem.movieId)
            .subscribe((elemMovi) => {
              elemMovi.map((el) => {

                arr.push(el);
              });
            });
          this.muvSrv.ricercaMuvie(elem.movieId).subscribe((elemMovi) => {
            elemMovi.map((el) => {
              arr.push(el);
            });
            if (this.favoriti.getValue().length == arr.length){
              /* console.log(this.favoriti.getValue()); */
              
              this.muviFavoriti.next(arr);}
          });
        });
      }else{        
        this.muviFavoriti.next([]);}

      });
    /* this.http.get<MoviesToprated[]>(environment.apiURL + 'favorites?userId'+id).subscribe(
      (elem)=>{this.muviFavoriti.next(elem);}); */
  }
  cambioFavorito(id: number) {
    let filtrato = this.favoriti.getValue().filter((el) => el.movieId == id);
  /*   console.log(filtrato[0]); */
    if (filtrato.length == 0) {
      this.addFavorite(id);
    } else this.deleteFavorite(filtrato[0]);//deve essere per forza 0 ce ne sara uno solo
  }
  addFavorite(id: number) {
    const userJson = localStorage.getItem('user');
    let user = userJson ? JSON.parse(userJson) : null;
    this.http
      .post<Favorite>(environment.apiURL + 'favorites', {
        userId: user.user.id,
        movieId: id,
      })
      .subscribe((elem) => {
        this.favoriti.next([...this.favoriti.getValue(), elem]);
        this.iniUser(user.user.id);
      });
  }
  
  deleteFavorite(filtrato: Favorite) {
    console.log(this.favoriti.getValue());
    
    this.http.delete(environment.apiURL + 'favorites/' + filtrato.id).subscribe(
      (elem) => {
        
       
     /* this.favoriti.next( this.favoriti.getValue().splice(this.favoriti.getValue().indexOf(filtrato),1)); */

     
     /* this.muviFavoriti.next(this.muviFavoriti.getValue().splice(this.muviFavoriti.getValue().findIndex(el=>el.id==filtrato.movieId),1)); */
           this.iniUser(filtrato.userId);   
      }

      
    );
    
  }
}
