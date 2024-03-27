import { Component,Input } from '@angular/core';
import { Poster } from 'src/app/interface/poster.interface';
@Component({
  selector: 'app-jumbotron',
  templateUrl: './jumbotron.component.html',
  styleUrls: ['./jumbotron.component.scss']
})
export class JumbotronComponent {
@Input() data!:Poster;
constructor(){
}


}
