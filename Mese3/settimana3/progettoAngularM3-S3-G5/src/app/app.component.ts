import { Component, OnInit } from '@angular/core';
import { AuthService } from './auth/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  title = 'progettoAngularM3-S3-G5';
  constructor(private serv:AuthService) { }
 ngOnInit(): void {
   this.serv.iniRestorToken();//richiamo il metodo per il recupero del token appena il componente è inizializzato
 }
}
