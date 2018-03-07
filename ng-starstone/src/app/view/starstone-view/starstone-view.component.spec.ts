import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StarstoneViewComponent } from './starstone-view.component';

describe('StarstoneViewComponent', () => {
  let component: StarstoneViewComponent;
  let fixture: ComponentFixture<StarstoneViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StarstoneViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StarstoneViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
