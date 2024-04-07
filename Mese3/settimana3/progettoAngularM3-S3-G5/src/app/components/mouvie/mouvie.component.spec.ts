import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MouvieComponent } from './mouvie.component';

describe('MouvieComponent', () => {
  let component: MouvieComponent;
  let fixture: ComponentFixture<MouvieComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MouvieComponent]
    });
    fixture = TestBed.createComponent(MouvieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
