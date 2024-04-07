import { Injectable } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';
import { BehaviorSubject, tap } from 'rxjs';
import { environment } from 'src/environments/environment.development';
import { AuthData, User } from '../models/db-interface';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { FavoriteService } from '../services/favorite.service';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  apiUrl = environment.apiURL;
  jwtToken = new JwtHelperService();
  private authSub = new BehaviorSubject<AuthData | null>(null);
  authObs = this.authSub.asObservable();
  constructor(private http: HttpClient,private router: Router,private favSrv:FavoriteService) {}

  login(data: { email: string; password: string }) {
    return this.http.post<AuthData>(`${this.apiUrl}login`, data).pipe(
      tap((data) => {
        console.log('Auth data: ', data);
      }),
      tap((data) => {
        this.authSub.next(data);
        const userId=data.user.id as unknown as number;
        this.favSrv.iniUser(userId);//mi scalo il metodo per il recupero dei favoriti
        localStorage.setItem('user', JSON.stringify(data));
      })
    );
  }
  iniRestorToken() {
    const userLocalStorage = localStorage.getItem('user');
    if (userLocalStorage) {
      this.authSub.next(JSON.parse(userLocalStorage));
      const userId = (JSON.parse(userLocalStorage)).user.id as unknown as number;
      this.favSrv.iniUser(userId);
    }
  }
  logout() {
    this.authSub.next(null);
    localStorage.removeItem('user');
    this.router.navigate(['/login']);
  }
  registerPost(data:User){
    return this.http.post<User>(`${this.apiUrl}register`,data);
  }

}
