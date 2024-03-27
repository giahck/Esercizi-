import { Component,OnInit,Input } from '@angular/core';
import { PostInterface } from './../../interface/post-interface';
import { PostServiceService } from 'src/app/service/post-service.service';
@Component({
  selector: 'app-edit-body',
  templateUrl: './edit-body.component.html',
  styleUrls: ['./edit-body.component.scss']
})
export class EditBodyComponent implements OnInit {
  posts: PostInterface[] = [];
  @Input() post!: PostInterface
  edit: Boolean = false
  constructor(private postServ:PostServiceService) {
  }
  async  ngOnInit(): Promise<void>{
    const posts = await this.postServ.getPost();
    this.posts = posts;
    
  }
  toggleEdit() {
    this.edit = !this.edit
  }

}
