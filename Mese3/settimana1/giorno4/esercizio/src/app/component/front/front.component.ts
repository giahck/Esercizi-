import { Component } from '@angular/core';
import { PostInterface } from './../../interface/post-interface';
@Component({
  selector: 'app-front',
  templateUrl: './front.component.html',
  styleUrls: ['./front.component.scss']
})
export class FrontComponent {
  post:PostInterface[]=[];
constructor(){
this.getFetch();
}
async getFetch(){
  const response = await fetch('../../assets/db.json');
  const data = await response.json();
  let random=Math.floor(Math.random()*(data.length-2))
  for(let i=0; i<2;i++){
    this.post.push(data[random+i])
  }
  console.log(this.post);
}

}
