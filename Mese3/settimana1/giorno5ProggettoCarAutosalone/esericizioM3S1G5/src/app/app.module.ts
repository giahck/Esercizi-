import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { Route, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { HomeComponent } from './component/home/home.component';
import { NavComponent } from './component/nav/nav.component';
import { BodyHomeComponent } from './component/body-home/body-home.component';
import { AutoSaloneComponent } from './component/auto-salone/auto-salone.component';
const routers :Route[]=[{
  path:'',
  component:HomeComponent,
},

{
  path: 'salone/:id',
  component:AutoSaloneComponent,
},
{
  path: '**',
  component:HomeComponent,
}
]
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavComponent,
    BodyHomeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(routers)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
