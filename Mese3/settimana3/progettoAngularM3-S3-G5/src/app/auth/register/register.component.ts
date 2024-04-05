import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit{
formSub:FormGroup= new FormGroup({});
  

  /* passwordMatchValidator: any; */
constructor(private fb:FormBuilder,private authSrv:AuthService,private router: Router) { }
ngOnInit(): void {
  this.formSub = this.fb.group({
    name:['',[Validators.required,Validators.minLength(3)]],
    surname:['',[Validators.required,Validators.minLength(3)]],
    email:['',[Validators.required,Validators.email]],
    password: ['', [Validators.required/*, Validators.pattern(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/) */]],
    passwordConfirm: ['', [Validators.required]], 
   
  }, { validators: this.passwordMatchValidator });
}

passwordMatchValidator(g: FormGroup) {
  const password = g.get('password');
  const passwordConfirm = g.get('passwordConfirm');
  
  if (password && passwordConfirm) {
    return password.value === passwordConfirm.value ? null : { 'mismatch': true };
  }
  return null;
}

controllo(val: string) {  
  return this.formSub.get(val);
}
submit(){
  this.formSub.removeControl('passwordConfirm');
  console.log(this.formSub.value);
  this.authSrv.registerPost(this.formSub.value).subscribe(
    (data) => {
      console.log(data);
      this.authSrv.login(this.formSub.value).subscribe(
        (data) => {
          console.log(data);
          this.router.navigate(['/']);
        });
    },
    (err) => {
      console.log(err.error);
    },
  )
}
}
