import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {
  errori: string = '';
  loginForm!: FormGroup;
  registerVar: boolean = false;
constructor(private authSrv:AuthService,private router: Router) {}
  ngOnInit() {
    this.loginForm = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required,
        Validators.minLength(6) 
        /* Validators.pattern(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/) */,
      ]),
    });
  }
  controllo(val: string) {
    return this.loginForm.get(val);
  }
  onSubmit() {
    if (this.loginForm.valid) {
      this.authSrv.login(this.loginForm.value).subscribe(
        (data) => {
          console.log(data);
          this.router.navigate(['/']);
        },
        (err) => {
          this.loginForm.reset();
          // console.log(err.error); // commenta o rimuovi questa riga
          switch (err.error) { 
            case 'Incorrect password':
                 console.log('password errata');
                 this.registerVar = true;
                 this.errori = 'password errata';
                break;
    
            case 'Cannot find user':
                 console.log('Utente non trovato');
                 this.registerVar = true;
                 this.errori = 'Utente non trovato';
                break;
    
            default:
                 console.log('Errore nella chiamata');
                break;
          }
        }
      );
    }
  }
}
