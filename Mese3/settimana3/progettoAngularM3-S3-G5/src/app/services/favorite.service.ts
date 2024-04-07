import { MuvieSService } from 'src/app/services/muvie-s.service';

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Favorite, MoviesPopular } from '../models/db-interface';
import { BehaviorSubject, Observable } from 'rxjs';
import { environment } from 'src/environments/environment.development';
//chiamo apena faccio login
@Injectable({
  providedIn: 'root',
})
export class FavoriteService {
  private favorite = new BehaviorSubject<Favorite[]>([]);
  favorite$ = this.favorite.asObservable();
  constructor(private http: HttpClient, private muvSrv: MuvieSService) {}
  iniUser(id: number) {
    this.http
      .get<Favorite[]>(environment.apiURL + `favorites?userId=${id}`)
      .subscribe((result) => {
        this.favorite.next(result);
        console.log(this.favorite.value);
      });
  }


  
  addFavorite(mouviId: number) {
    //faccio anche una post e modifico il db pero uso il behavior subject per aggiornare la pagina e riprendermelo senza fare get
    let idUser;
    let favoriteId = this.favorite.value.find((favorite) => {
      idUser = favorite.userId;
      if (favorite.movieId === mouviId) {
        return favorite.userId;
      }
      return null;
    });

    if (favoriteId === undefined) {
      /* console.log(this.favorite.getValue()); */

      this.http
        .post<Favorite>(environment.apiURL + 'favorites', {
          userId: idUser,
          movieId: mouviId,
        })
        .subscribe((result) => {
          const currentFavorites = this.favorite.getValue();
          const updatedFavorites = currentFavorites.concat(result);
          this.favorite.next(updatedFavorites);
        });
    }
  }
  serchFavorite(): Observable<MoviesPopular[]> {
    console.log(this.favorite.value);
    
    //ritorna un observable di array di movies linterfaccia e uguale
    let muvie: MoviesPopular[] = []; //dal momento che la get la faccio in un service differente mi apro un oservabole in modo che atendo anche dal component la get
    return new Observable((observer) => {
      const favoritesLength = this.favorite.value.length;
      let count = 0;
      this.favorite.value.forEach((favorite) => {
        this.muvSrv.ricercaMuvie(favorite.movieId.toString()).subscribe((result) => {result.forEach((res) => { muvie.push(res);});
            this.muvSrv.ricercaMuvieToprated(favorite.movieId.toString()).subscribe((result) => { result.forEach((res) => { muvie.push(res); });
                count++;
                if (count === favoritesLength) {
                  observer.next(muvie);
                  observer.complete();
                }
              });
          });
      });
    });
  }
  
  disactiveFavorite(id: number) {
    this.favorite.getValue().find((favorite) => {
      console.log(favorite);
      if (favorite.movieId === id) {
        this.http.delete(environment.apiURL + `favorites/${favorite.id}`) .subscribe();
         /* console.log( */
          /* this.favorite.value.filter(favorite => favorite.movieId !== id)); */
        this.favorite.next(this.favorite.value.filter(favorite => favorite.movieId !== id));
        this.serchFavorite()
        
        /*  const currentFavorites = this.favorite.getValue();
        
        const updatedFavorites = currentFavorites.filter((favorite) => favorite.id === id);
        console.log(updatedFavorites); */
        
        /* this.favorite.next(updatedFavorites); */
        /*   }); */
        
      }  
    }
  );
  this.serchFavorite();
  
}
}

//questa soluzione con muvie messa in un behavior subject in modo che caricoo i favoriti una sola volta pero deve essere inizializata appena faccio login un po come ho fatto con addfavorite
//la funzione é stata testata ed é funzionante
//riscontrato un problema che se la inizializo sul component ogni volta che io acedo al component mi fa una get e mi duplica i favoriti per questo questa funzio deve esere messa solo al login o appena parte il primo component in modo che metto in ascolto solo muvie dichiarato nel caso con funzioni estese
//il codice testato neglialtri component li ho cancellati perche non erano necessaro basta aprire un .sub sulla funzione e ti sara restituito tutto arrey, magari ci si aggiunge anche mouvetoptread ed é completo
/*   serchFavorite(): Observable<MoviesPopular[]> {
  return new Observable(observer => {
    const favoritesLength = this.favorite.value.length;
    let count = 0;

    this.favorite.value.forEach((favorite) => { 
      this.muvSrv.ricercaMuvie(favorite.movieId.toString()).subscribe((result) => {
        
        result.forEach((res) => {
          console.log(res);
          
          this.muvie.next([...this.muvie.value, res]); 
        });

        count++;
        if (count === favoritesLength) {
          console.log(this.muvie.value);
          
          observer.next(this.muvie.value);
          observer.complete();
        }
      });
    });
  });
} */