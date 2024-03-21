import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-deteail',
  templateUrl: './deteail.component.html',
  styleUrls: ['./deteail.component.scss']
})
export class DeteailComponent {
constructor(private route: ActivatedRoute){
 this.getToDetail();
}
getToDetail(){
  this.route.url.subscribe((event)=>{
    console.log(+ event[1].path)
  });
  

}
}
