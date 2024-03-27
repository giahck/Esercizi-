import { Component,Input } from '@angular/core';
import { Poster } from 'src/app/interface/poster.interface';

@Component({
  selector: 'app-satic-home',
  templateUrl: './satic-home.component.html',
  styleUrls: ['./satic-home.component.scss']
})
export class SaticHomeComponent {
@Input() data:Poster[]=[];
constructor(){  
}
}
