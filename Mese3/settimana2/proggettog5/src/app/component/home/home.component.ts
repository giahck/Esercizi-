import { Component, Input, OnInit  } from '@angular/core';
import { User,Todo } from 'src/app/models/interface/interfac';
import { PersoneService } from 'src/app/services/persone.service';
/* import { PersoneService } from 'src/app/services/persone.service'; */
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {
  @Input() personActive: boolean = false;
  @Input() acttiveTodo: boolean = false;
  @Input() activeTodo: boolean = false;
  @Input() dactiveTodo: boolean = false;

  user: User[] = [];
  todo: Todo[] = [];
  userVisual!:User;
  userFilter:User[]=[]
  userSearch:string='';
  constructor(private userSrv:PersoneService) {

  }
 
  ngOnInit(): void {
    this.userSrv.getUser.subscribe((elem:User[])=>{
      this.user=elem
      this.onSearch()
      this.personActive = this.user.length > 0;
    })
   this.userSrv.todoS.subscribe((elem:Todo[])=>{
    this.todo=elem
    this.activeTodoaAll();    
   })
   
  }
  singleUser(id:number,key:User){
    this.userSrv.getTodoVisual(id)
    this.userVisual=key
    this.acttiveTodo=true

  }
  activeTodof(){
    this.activeTodo = true;
    this.dactiveTodo = false;
  }
  dactiveTodof(){
    this.activeTodo = false;
    this.dactiveTodo = true;
  }
  activeTodoaAll(){
    this.activeTodo=true
    this.dactiveTodo = true;
  }
  exchange(id:number){//potrei restituure direttamente id dellaray ma se cancello mi si sfasa tutto 
    this.userSrv.exchangeTodo(id)
  }
  onSearch() {
    this.userFilter=this.user.filter(elem=>elem.firstName.toLowerCase().includes(this.userSearch.toLowerCase()))
   
   }
}
