import { Autosalone1 } from './../interface/autosalone1';
import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-macchina',
  templateUrl: './macchina.component.html',
  styleUrls: ['./macchina.component.scss'],
})
export class MacchinaComponent {
  isloaded:boolean=false;
   macchina!:Autosalone1
  constructor(private route: ActivatedRoute) {
    this.getFetch();
  }
  async getFetch() {
    let id = 0;
    this.route.url.subscribe((event) => {
      id = +event[1].path;
    });

    const url = `https://car-api2.p.rapidapi.com/api/trims/${id}`;
    const options = {
      method: 'GET',
      headers: {
        'X-RapidAPI-Key': 'dbc55fa0b3msh11db0998867bdf0p127d0ejsn427d844c1974',
        'X-RapidAPI-Host': 'car-api2.p.rapidapi.com',
      },
    };

    try {
      const response = await fetch(url, options);
      const result = await response.json();
      this.macchina=result;
      this.isloaded=true;
      console.log(this.macchina);
      
    } catch (error) {
      console.error(error);
    }
  }
}
