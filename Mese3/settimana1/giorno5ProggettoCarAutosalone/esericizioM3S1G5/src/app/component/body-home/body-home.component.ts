import { InfMachina } from './../interface/inf-machina';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-body-home',
  templateUrl: './body-home.component.html',
  styleUrls: ['./body-home.component.scss'],
})
export class BodyHomeComponent {
  @Input() articolo!: string;
  stringa: InfMachina[] = [
    { name: 'Mercedes-Benz',anno: 2017, data: [] },
    { name: 'Fiat', anno: 2018, data: [] },
    { name: 'Volvo',anno: 2019, data: [] },
];
  constructor() {
    this.controller();
  }
  submit() {
    console.log('Submit clicked:', this.articolo);
  }

  async controller() {
  
    for (let i = 0; i < this.stringa.length; i++) {
      await this.getFetch(i);
    }
  }
  async getFetch(id: number) {
    /* let stringa=[{name:'Mercedes-Benz',data:[]},{name:'fiat',data:[]},{name:'volvo',data:[]}] */

    const url = `https://car-api2.p.rapidapi.com/api/models?make=${this.stringa[id].name}&sort=id&limit=3&year=${this.stringa[id].anno}&verbose=yes`; /* ricerca dal 2017 al 2020 */
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
      this.stringa[id].data = result.data.slice(0, 3); /* ne seleziono solo 3 */

      /*  console.log(this.string); */
    } catch (error) {
      console.error(error);
    }
    console.log(this.stringa);
    console.log(this.stringa[0].data);
  }
}
