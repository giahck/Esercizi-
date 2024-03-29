
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms'; 
import { User } from 'src/app/models/interface/interfac';
import { PersoneService } from 'src/app/services/persone.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit{
  constructor(private personSrv:PersoneService){}
  formData:User[]=[]
ngOnInit(): void {  
  this.personSrv.pullPersone.subscribe(elem=>this.formData=elem)
}
  submitForm(myForm: NgForm) { 
    if (myForm.valid) {
      this.personSrv.pushPerson(myForm)
      
      
      myForm.resetForm();
    } else {
      console.error('Il form non è valido.');
    }
  }
  
}
