import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Autosalone1 } from '../interface/autosalone1';
@Component({
  selector: 'app-auto-salone',
  templateUrl: './auto-salone.component.html',
  styleUrls: ['./auto-salone.component.scss']
})
export class AutoSaloneComponent {
  catalogo: Autosalone1[]=[];
constructor(private route: ActivatedRoute){
  this.getFetch();
}

async getFetch(){
  let id=0;
  this.route.url.subscribe((event)=>{
    id=+ event[1].path;
    console.log(id)
  });
  const url = `https://car-api2.p.rapidapi.com/api/trims?direction=asc&sort=id&year=2018&verbose=yes&make_id=${id}&limit=20`;
 /*  const url = 'https://car-api2.p.rapidapi.com/api/bodies?make_id=28&sort=id&verbose=yes&direction=asc&year=2020&limit=100'; */
const options = {
	method: 'GET',
	headers: {
		'X-RapidAPI-Key': 'dbc55fa0b3msh11db0998867bdf0p127d0ejsn427d844c1974',
		'X-RapidAPI-Host': 'car-api2.p.rapidapi.com'
	}
};

try {
	const response = await fetch(url, options);
	const result = await response.json();
	this.catalogo.push(result.data);
  console.log(this.catalogo);
  
} catch (error) {
	console.error(error);
}
}



}
