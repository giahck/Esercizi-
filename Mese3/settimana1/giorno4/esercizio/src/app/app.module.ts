import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { Route, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { JumbotronComponent } from './component/jumbotron/jumbotron.component';
import { HomeComponent } from './component/home/home.component';
import { NavBarComponent } from './component/nav-bar/nav-bar.component';
import { FrontComponent } from './component/front/front.component';
import { RhigtFrontComponent } from './component/rhigt-front/rhigt-front.component';
import { PostActiveComponent } from './component/post-active/post-active.component';
import { PostInactiveComponent } from './component/post-inactive/post-inactive.component';
import { DeteailComponent } from './component/deteail/deteail.component';
import { EditBodyComponent } from './component/edit-body/edit-body.component';
import { FormsModule } from '@angular/forms';
const routers :Route[]=[{
  path:'',
  component:HomeComponent,
},
{
  path:'active',
  component:PostActiveComponent,
},
{
  path:'inactive',
  component:PostInactiveComponent,
},
{
  path:'post/:id',
  component:DeteailComponent,
},
{
  path: '**',
  component:HomeComponent,
}
]
@NgModule({
  declarations: [
    AppComponent,
    JumbotronComponent,
    HomeComponent,
    NavBarComponent,
    FrontComponent,
    RhigtFrontComponent,
    PostActiveComponent,
    PostInactiveComponent,
    DeteailComponent,
    EditBodyComponent
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
