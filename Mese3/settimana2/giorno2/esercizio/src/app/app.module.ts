import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { Route, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { HomeComponent } from './component/home/home.component';
import { NavBarComponent } from './component/nav-bar/nav-bar.component';
import { PostAttiviComponent } from './component/post-attivi/post-attivi.component';
import { PostInattiviComponent } from './component/post-inattivi/post-inattivi.component';
import { JumbotronComponent } from './component/jumbotron/jumbotron.component';
import { BoardDirective } from './directives/board.directive';
import { SaticHomeComponent } from './component/satic-home/satic-home.component';
import { RightHomeComponent } from './component/right-home/right-home.component';
import { EditPostComponent } from './component/editPost/edit-post/edit-post.component';
const routers :Route[]=[{
  path:'',
  component:HomeComponent,
},
/* {
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
} */
]
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavBarComponent,
    PostAttiviComponent,
    PostInattiviComponent,
    JumbotronComponent,
    BoardDirective,
    SaticHomeComponent,
    RightHomeComponent,
    EditPostComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routers)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
