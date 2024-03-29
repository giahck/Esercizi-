import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { FormsModule } from '@angular/forms';
import { RouterModule, Route } from '@angular/router';
import { AppComponent } from './app.component';
import { HomeComponent } from './component/home/home.component';
import { NavBarComponent } from './component/nav-bar/nav-bar.component';
import { RegisterComponent } from './component/register/register.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';

const routes: Route[] = [
  {
      path: '',
      component: HomeComponent
  },
  {
      path: 'register',
      component: RegisterComponent
  }
]

@NgModule({
  declarations: [
    
    AppComponent,
    HomeComponent,
    NavBarComponent,
    RegisterComponent,
  ],
  imports: [
    MatFormFieldModule,
    MatInputModule,
    BrowserModule,
    FormsModule,
    BrowserAnimationsModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
