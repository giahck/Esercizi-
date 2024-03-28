import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Card, Carello, Product } from 'src/app/module/card.interface';
import { catchError, map } from 'rxjs/operators';
import { Observable, Observer, throwError } from 'rxjs';
@Injectable({
  providedIn: 'root',
})
export class CardService {
  apiURL = 'https://dummyjson.com/products';
  carrello:Carello[]=[];
  constructor(private http: HttpClient) {}
  
  getCard(): Observable<Product[]> {
    return this.http.get<Card>(this.apiURL).pipe(

      map((response: Card) => response.products),
      catchError((err) => {
        return throwError(this.getErrorMessage(err.status));
      })
    );}
    addCarello(product:Product){
    
      /* console.log(product); */
      
      let rest=this.carrello.find(elem=>elem.id==product.id)
      if(rest?.amount==undefined)
      this.carrello.push({amount:1,...product})
      else
      rest!.amount++ 
      
      console.log(this.carrello);
    }
    get Carello(){
      return new Observable((elem: Observer<Carello[]>)=>{
        elem.next(this.carrello)
      })
    }
    decrementaCarello(id:number){
      /* this.carrello = this.carrello.filter(elem =>{
        if(elem.id ===id &&elem.amount!==undefined&& elem.amount>0)
         {elem.amount--;
          return elem
        }else
        return elem
        
      }); */
      

      const index = this.carrello.findIndex(prd => prd.id === id)
    if(this.carrello[index].amount === 1) {
      this.carrello.splice(index, 1)
    } else {
      this.carrello[index].amount--;
    }
    }

    private getErrorMessage(status: number): string {
      let message = '';
      switch (status) {
        case 404:
          message = 'Elementi non trovati';
          break;
        default:
          message = 'Qualcosa non ha funzionato nella chiamata';
          break;
      }
      return message;
    }
}
