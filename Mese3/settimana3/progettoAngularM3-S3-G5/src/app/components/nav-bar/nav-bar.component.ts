import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/auth/auth.service';
import { AuthData } from 'src/app/models/db-interface';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.scss']
})
export class NavBarComponent implements OnInit{
  log!:AuthData|null;
  constructor(private authS:AuthService) { }
  ngOnInit(): void {
    this.authS.authObs.subscribe((data)=>{
      console.log('Dati utente: ',data);
      this.log=data;
    });
  }
  logout() {
    this.authS.logout();
}
}
