
import { Injectable } from '@angular/core';
import { User } from '../models/db-interface';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }
  getProfile()
  {
    let userJson =localStorage.getItem('user');
    let user = userJson ? JSON.parse(userJson) : null;
    console.log(user.user.id);
    
    return this.http.get<User[]>('http://localhost:4201/users?id='+user.user.id);
  }
}
