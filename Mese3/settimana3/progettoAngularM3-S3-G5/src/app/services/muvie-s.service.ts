import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MoviesPopular, MoviesToprated } from '../models/db-interface';

@Injectable({
  providedIn: 'root'
})
export class MuvieSService {

  constructor(private http:HttpClient) { }
  getMuvies(){
   return this.http.get<MoviesPopular[]>('http://localhost:4201/movies-popular');
  }
  getMoviesToprated(){
   return this.http.get<MoviesToprated[]>('http://localhost:4201/movies-toprated');
  }
  ricercaMuvie(query:number){
    return this.http.get<MoviesPopular[]>('http://localhost:4201/movies-popular?id='+query);
  }
  ricercaMuvieToprated(query:number){
    return this.http.get<MoviesToprated[]>('http://localhost:4201/movies-toprated?id='+query);
  }

 
}
