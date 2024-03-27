import { Injectable } from '@angular/core';
import { Poster } from '../interface/poster.interface';
@Injectable({
  providedIn: 'root'
})
export class PostServiceService {
post:Poster[]=[];
/* postlenght:Poster[]=[]; */
 constructor() { 
 
     /* this.init(); */
  }
/*   async init(): Promise<void> {
    const response = await fetch('../../assets/db.json');
    const data = await response.json();
    this.post = data as Poster[];
    return data;
  } */
   async  fetch(): Promise<Poster[]>{//poterlo fare appena parte il service quando viene attivato
    const response = await fetch('../../assets/db.json');
    const data = await response.json();
    this.post = data as Poster[];
    return data;
    
  }
   getPosts()
  {
    return this.post;
  }
  async getRandom(postLength: number): Promise<Poster | Poster[]> {
    try {
      if (this.post.length <= 0) {
        await this.fetch();
        console.log('entrato');
        
      }
  
      const random = Math.floor(Math.random() * (this.post.length - postLength));
      const randomPosts = this.post.slice(random, random + postLength);
  
      if (postLength === 1) {
        return randomPosts[0]; 
      } else {
        return randomPosts; 
      }
    } catch (error) {
      console.error('Error occurred while getting random post:', error);
      throw error;
    }
  }
}
