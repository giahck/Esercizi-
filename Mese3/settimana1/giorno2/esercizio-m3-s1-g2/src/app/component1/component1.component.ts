import { Component } from '@angular/core';

@Component({
  selector: 'app-component1',
  templateUrl: './component1.component.html',
  styleUrl: './component1.component.scss'
})
export class Component1Component {
stampa='componente 2 creato passagli il numero random';
constructor(){
  this.random();
}
random(){
  this.stampa+=Math.floor(Math.random()*10);
}


}
