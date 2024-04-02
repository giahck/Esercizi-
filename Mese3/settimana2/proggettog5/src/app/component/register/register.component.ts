import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { User } from 'src/app/models/interface/interfac';
import { Router } from '@angular/router';
import { HttpRequestService } from 'src/app/services/http-request.service';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss'],
})
export class RegisterComponent implements OnInit {
user!:User;
formSub!:FormGroup;
constructor(private fb:FormBuilder,private router: Router,private httpSrv: HttpRequestService){}
ngOnInit(): void {
  this.formSub=this.fb.group({
    firstName:['', [Validators.required,Validators.minLength(3),Validators.maxLength(9)]],
    lastName:['', [Validators.required,Validators.minLength(3),Validators.maxLength(12)]],
    email:['', [Validators.required,Validators.email]],
    /* password: ['', [Validators.required,Validators.pattern(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/)]],
    passwordConfirm: ['', [Validators.required]], */
    title:this.fb.control('')
  })
}
controllo(val:string){  
  return this.formSub.get(val)
}
submit(){
  console.log(this.formSub.value);
  this.user=this.formSub.value;
  this.httpSrv.postUser(this.user)
 /*  this.router.navigate(['/']); */
}

}