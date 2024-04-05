
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { RegisterComponent } from './register/register.component';
import { environment } from 'src/environments/environment.development';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
apiUrl=environment.apiURL
  constructor(private http:HttpClient){ }
  singup(data:RegisterComponent){
    return this.http.post(`${this.apiUrl}register`,data)
  }
}
