import { Injectable, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable, Observer, BehaviorSubject, map } from 'rxjs';
import { Todo, User } from '../models/interface/interfac';
import { HttpRequestService } from './http-request.service';
import { Subscription } from 'rxjs';
@Injectable({
  providedIn: 'root',
})
export class PersoneService /* implements OnInit */ {
  persone: [] = [];
  user: User[] = [];
  todo: Todo[] = [];
  sub!: Subscription;
  todoS = new BehaviorSubject<Todo[]>([]);
  private personeSubject = new BehaviorSubject<User[]>(this.persone);
  constructor(private router: Router, private httpSrv: HttpRequestService) {}

 
  get getUser() {
    return this.httpSrv.getUser();
  }

  getTodo() {
    this.todoS.next(this.todo);
  }

  getTodoVisual(id: number) {
console.log(id);

    this.httpSrv.getTodo().subscribe((elem: Todo[]) => {
      this.todo = elem.filter((el) => el.userId === +id);
      this.getTodo();
    });
  }

  exchangeTodo(id:number){
    this.todo!=this.todo.map(elem=>{
      if(elem.id==id){
        elem.completed=!elem.completed
      return{...elem}
    }
    return elem
    })
   
    
  }




  //register non é attivo funziona ma é fine a sestesso per un eventuale pusch nella registrazione

  pushPerson(myForm: NgForm) {
    /* this.persone.push(myForm.value as User); */

    this.router.navigate(['/']);
    this.pullPersone;
    console.log(this.persone);
  }
  get pullPersone() {
    return new Observable((elem: Observer<User[]>) => {
      elem.next(this.persone);
    });
  }
  getPersone(): Observable<User[]> {
    return this.personeSubject.asObservable();
  }
}
