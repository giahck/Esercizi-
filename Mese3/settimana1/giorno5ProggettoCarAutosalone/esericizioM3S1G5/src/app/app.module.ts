import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { HttpClientModule } from '@angular/common/http';
import { Route, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { HomeComponent } from './component/home/home.component';
import { NavComponent } from './component/nav/nav.component';
import { BodyHomeComponent } from './component/body-home/body-home.component';
import { AutoSaloneComponent } from './component/auto-salone/auto-salone.component';
import { MacchinaComponent } from './component/macchina/macchina.component';
const routers :Route[]=[{
  path:'',
  component:HomeComponent,
},

{
  path: 'salone/:id',
  component:AutoSaloneComponent,
},
{
  path: 'macchina/:id',
  component:MacchinaComponent,
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
    BodyHomeComponent,
    AutoSaloneComponent,
    MacchinaComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(routers),
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
