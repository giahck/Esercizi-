import { Component, ViewChild } from '@angular/core';
import { PostServiceService } from 'src/app/service/post-service.service';
import { Poster } from 'src/app/interface/poster.interface';
import { EditPostComponent } from '../editPost/edit-post/edit-post.component';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent  {
  @ViewChild(EditPostComponent) EditPost!:EditPostComponent;
  poster!:Poster;
  post:Poster[]=[];
  postSingole!:Poster;
  postDuble:Poster[]=[];
  postRight:Poster[]=[];
  attivo:Boolean=false;
  constructor(private service:PostServiceService){
    this.init();
  }
  async init(): Promise<void> {
    try {
      this.post = await this.service.fetch();
      this.postSingole = await this.service.getRandom(1)as Poster;
      this.postDuble = await this.service.getRandom(2)as Poster[];
      this.postRight = await this.service.getRandom(4)as Poster[];
      this.attivo = true;
      console.log(this.postDuble);
    } catch (error) {

      console.error('Error occurred during initialization:', error);
    }
    
  }
  /* async ngOnInit(): Promise<void> {
    this.post=await this.service.getPosts();
    this.attivo = true;//in questo modo non serve neanche si puo cambiare tutto con http request piú veloce
  } */
  


}
