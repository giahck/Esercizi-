
import { Directive,ElementRef,Renderer2 } from '@angular/core';

@Directive({
  selector: '[appHilight]'
})
export class HilightDirective {

  constructor(private target:ElementRef,private render:Renderer2) {
    render.setStyle(target.nativeElement,'backgroundColor','red');
   }

}
