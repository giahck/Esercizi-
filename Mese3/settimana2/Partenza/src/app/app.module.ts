import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { RouterModule, Route } from '@angular/router';
import { AppComponent } from './app.component';
import { HomeComponent } from './component/home/home.component';
import { NavBarComponent } from './component/nav-bar/nav-bar.component';

const routes: Route[] = [
  {
      path: '',
      component: HomeComponent
  }/* ,
  {
      path: 'favorites',
      component: FavoritesComponent
  } */
]

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavBarComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
