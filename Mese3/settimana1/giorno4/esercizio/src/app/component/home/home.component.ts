import { Component ,OnInit, ViewChild } from '@angular/core';
import { PostInterface } from './../../interface/post-interface';
import { PostServiceService } from 'src/app/service/post-service.service';
import { EditBodyComponent } from '../edit-body/edit-body.component';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  posts: PostInterface[] = [];
  post!: PostInterface;
  @ViewChild("EditBody") EditBody!: EditBodyComponent
  constructor(private postServ:PostServiceService) {
  }
  async  ngOnInit(): Promise<void>{
    const posts = await this.postServ.getPost();
    this.posts = posts;
    console.log(this.posts);
    
    
  }

}
