import { PostInterface } from './../../interface/post-interface';
import { Component } from '@angular/core';

@Component({
  selector: 'app-jumbotron',
  templateUrl: './jumbotron.component.html',
  styleUrls: ['./jumbotron.component.scss']
})
export class JumbotronComponent {
post!:PostInterface;

constructor(){
  this.getFetch();
}
async getFetch()
{
  const response = await fetch('../../assets/db.json');
        const data = await response.json();
        this.post = data[Math.floor(Math.random() * data.length)];
}

}
