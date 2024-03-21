import { PostInterface } from './../../interface/post-interface';
import { Component } from '@angular/core';
@Component({
  selector: 'app-post-active',
  templateUrl: './post-active.component.html',
  styleUrls: ['./post-active.component.scss']
})
export class PostActiveComponent {
  posts: PostInterface[] = [];

  constructor() {
      this.getActivePosts().then((data) => {
          this.posts = data;
      });
  }

  async getActivePosts() {
      const response = await fetch('../../assets/db.json');
      const data = (await response.json()) as Array<PostInterface>;
      return data.filter((post) => post.active);
  }
}
