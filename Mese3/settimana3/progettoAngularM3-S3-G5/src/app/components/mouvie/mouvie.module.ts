import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MdbCarouselModule } from 'mdb-angular-ui-kit/carousel';
import { MouvieRoutingModule } from './mouvie-routing.module';
import { MouvieComponent } from './mouvie.component';
import { MdbPopoverModule } from 'mdb-angular-ui-kit/popover';

@NgModule({
  declarations: [
    MouvieComponent
  ],
  imports: [
    CommonModule,
    MdbCarouselModule,
    MouvieRoutingModule,
    MdbPopoverModule
  ]
})
export class MouvieModule { }
