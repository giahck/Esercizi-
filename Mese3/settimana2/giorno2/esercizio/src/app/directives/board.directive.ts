import { Directive, ElementRef, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appBoard]'
})
export class BoardDirective {

  constructor(private target: ElementRef, private render: Renderer2) {
    this.render.setStyle(this.target.nativeElement, 'backgroundColor', '#E9ECEF');
   }

}
