import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'esercizio-m3-s1-g2';
   sum:number=2+1;
   stampa:number|string=0;
   constructor(){
    this.calcola();
   }
   calcola(){
    let tre:number=3;
    if(tre===this.sum) {
    tre=this.sum;
    this.stampa=this.sum;
   }else{
    this.stampa='not component resolution';
   }
  }

}
