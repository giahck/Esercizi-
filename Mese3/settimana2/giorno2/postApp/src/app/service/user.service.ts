import { User } from './../models/user.interface';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor() { }
  getUsers(){
    return this.users;
  }
  getUser(id:number){
    return 
  }
}
