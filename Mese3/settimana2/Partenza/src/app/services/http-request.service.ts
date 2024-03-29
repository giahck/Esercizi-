import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Todo, User } from '../models/interface/interfac';
@Injectable({
  providedIn: 'root'
})
export class HttpRequestService {
  private apiURLUser: string = "http://localhost:3000/user"
  private apiURLTodo: string = "http://localhost:3000/todo"
  constructor(private http:HttpClient) { }
  getUser() {
    return this.http.get<User[]>(this.apiURLUser);
}
getTodo() {
  return this.http.get<Todo[]>(this.apiURLTodo);
}

}
