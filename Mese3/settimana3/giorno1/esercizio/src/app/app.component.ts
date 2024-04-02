import { User } from './../../../../../settimana2/giorno2/postApp/src/app/models/user.interface';
import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, ValidationErrors, ValidatorFn, Validators } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'esercizio';
  formSub!: FormGroup;
  user!: User;
  genere = ['Uomo', 'Donna','LGBT+'];
  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.formSub = this.fb.group({
      name: (''),
      cognome: (''),
      username: ['', [Validators.required]],
      password: ['', [Validators.required,Validators.pattern(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/)]],
      passwordConfirm: ['', [Validators.required]],
      gender:this.fb.control('')
    }, { validator: this.passwordMatchValidator });

   /*  this.formSub.valueChanges.subscribe((status) => {
      console.log('Stato del form: ', status);
    }); */
    
  }

  passwordMatchValidator: ValidatorFn = (control: AbstractControl): ValidationErrors | null => {
    const password = control.get('password')?.value;
    const passwordConfirm = control.get('passwordConfirm')?.value;
  
    return password === passwordConfirm ? null : { 'passwordMismatch': true };
  };

  getPasswordConfirm(): { passwordMatch: boolean } {
    const password = this.formSub.get('password')?.value;
    const passwordConfirm = this.formSub.get('passwordConfirm')?.value;
    return { passwordMatch: password === passwordConfirm };
  }

  getUser(name: string){
    return this.formSub.get(name);
  }

  submit(): void {
    this.user=this.formSub.value
    this.user.imgLink='https://w7.pngwing.com/pngs/340/946/png-transparent-avatar-user-computer-icons-software-developer-avatar-child-face-heroes-thumbnail.png'
    console.log(this.user);
    this.formSub.reset();
  }
}