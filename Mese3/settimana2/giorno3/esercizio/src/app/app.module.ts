import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Route, RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { NavBarComponent } from './component/nav-bar/nav-bar.component';
import { HomeComponent } from './component/home/home.component';
import { HomeBodyComponent } from './component/home-body/home-body.component';
import { CarellaComponent } from './component/carella/carella.component';
import { FavComponent } from './component/fav/fav.component';

const routes: Route[] = [
  {
      path: '',
      component: HomeComponent,
  },
  {
      path: 'fav',
      component: FavComponent,
  }
]
@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    HomeBodyComponent,
    HomeComponent,
    CarellaComponent,
    FavComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent,]
})
export class AppModule { }
