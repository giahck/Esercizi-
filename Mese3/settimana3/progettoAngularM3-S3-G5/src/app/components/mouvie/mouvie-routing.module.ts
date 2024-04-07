import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MouvieComponent } from './mouvie.component';
const routes: Routes = [{ path: '', component: MouvieComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MouvieRoutingModule { }
