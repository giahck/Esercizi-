import { Component,Input } from '@angular/core';
import { Poster } from 'src/app/interface/poster.interface';

@Component({
  selector: 'app-right-home',
  templateUrl: './right-home.component.html',
  styleUrls: ['./right-home.component.scss']
})
export class RightHomeComponent {
  @Input() data:Poster[]=[];
constructor(){}
}
