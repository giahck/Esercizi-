import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, Observer } from 'rxjs';
import { Card, Product } from '../module/card.interface';

@Injectable({
  providedIn: 'root'
})
export class FavoritsService {
favoriti =new BehaviorSubject<Product[]>([]);
myFav:Product[]=[];

addFav(card:Product){
  let rest=this.myFav.find(elem=>elem.id==card.id)
  if(!rest)
  this.myFav.push(card)
  console.log(this.myFav);
}

get favList(){
  return new Observable((elem:Observer<Product[]>)=>{elem.next(this.myFav)})
}




}
