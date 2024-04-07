import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { AuthGuard } from './auth/auth.guard';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { FavoriteComponent } from './components/favorite/favorite.component';
const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    canActivate: [AuthGuard],
  },
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'register',
    component: RegisterComponent,
  },
  {
    path: 'favorite',
    loadChildren: () =>import('./components/favorite/favorite.module').then(m => m.FavoriteModule), 
    canActivate: [AuthGuard],
  },
  {
    path: 'movie',
    loadChildren: () =>
      import('./components/mouvie/mouvie.module').then((m) => m.MouvieModule),
      canActivate: [AuthGuard],
  },
  { path: 'favorite', loadChildren: () => import('./components/favorite/favorite.module').then(m => m.FavoriteModule) },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
