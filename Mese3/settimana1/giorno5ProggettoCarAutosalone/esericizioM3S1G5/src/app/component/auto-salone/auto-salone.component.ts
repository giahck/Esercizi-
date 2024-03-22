import { Autosalone2 } from './../interface/autosalone2';
import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
/* import { Autosalone1 } from '../interface/autosalone1'; */
@Component({
  selector: 'app-auto-salone',
  templateUrl: './auto-salone.component.html',
  styleUrls: ['./auto-salone.component.scss']
})
export class AutoSaloneComponent {
  isloaded:boolean=false;
  /* catalogo: Autosalone1[]=[]; */
  catalogo2: Autosalone2[]=[];
constructor(private route: ActivatedRoute){
  this.getFetch();
}

async getFetch(){
  let id=0;
  this.route.url.subscribe((event)=>{
    id=+ event[1].path;
    /* console.log(id) */
  });
  if (id===0) 
    id=Math.floor(Math.random()*38)+1;/* se spingi su auto salone allora fa una ricerca random della casa */
  /* console.log(id); */
  
  /* const url = `https://car-api2.p.rapidapi.com/api/trims?direction=asc&sort=id&year=2018&verbose=yes&make_id=${id}&limit=20`; */
  const url = `https://car-api2.p.rapidapi.com/api/bodies?make_id=${id}&sort=id&verbose=yes&direction=asc&year=2018&limit=20`;
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
	this.catalogo2=result.data;
  console.log(this.catalogo2);
  this.isloaded=true;
  
} catch (error) {
  console.error(error);
}
}



}
