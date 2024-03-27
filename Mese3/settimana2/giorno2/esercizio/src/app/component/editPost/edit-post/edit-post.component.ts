import { Component, Input  } from '@angular/core';
import { Poster } from 'src/app/interface/poster.interface';

@Component({
  selector: 'app-edit-post',
  templateUrl: './edit-post.component.html',
  styleUrls: ['./edit-post.component.scss']
})
export class EditPostComponent {
visibile:boolean=true;
@Input() post!:Poster
editPost(){
  this.visibile=!this.visibile
}
}
