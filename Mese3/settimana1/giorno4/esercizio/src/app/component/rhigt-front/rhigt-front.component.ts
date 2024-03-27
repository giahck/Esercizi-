import { PostInterface } from './../../interface/post-interface';
import { Component ,Output,EventEmitter} from '@angular/core';
@Component({
  selector: 'app-rhigt-front',
  templateUrl: './rhigt-front.component.html',
  styleUrls: ['./rhigt-front.component.scss'],
})
export class RhigtFrontComponent {
  @Output() datiArr= new EventEmitter<PostInterface[]>();
  post: PostInterface[] = [];
  postPusch:PostInterface[]=[];
  constructor() {
    this.getfetch().then((data) => {
      this.post = data;
      this.impacchetta();
    });
  }
  async getfetch() {
    const response = await fetch('../../assets/db.json');
    const data = await response.json();

    return data;
  }
  impacchetta() {
    for (let i = 0; i < 4; i++) {
     this.postPusch.push(this.post[Math.floor(Math.random() * this.post.length)]);
    }
    /* console.log(this.post); */
    
  }
 

}
