import { Component } from '@angular/core';

@Component({
  selector: 'app-component2',
  templateUrl: './component2.component.html',
  styleUrl: './component2.component.scss'
})

export class Component2Component {
  nome='';
  cognome='';
constructor(){
  this.stampa();
}
stampa(){
  let objei={nome:'Mario',cognome:'Rossi'}
  this.nome=objei.nome;
  this.cognome=objei.cognome;
}
}
