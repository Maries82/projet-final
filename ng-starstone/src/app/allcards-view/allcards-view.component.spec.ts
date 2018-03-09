import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllcardsViewComponent } from './allcards-view.component';

describe('AllcardsViewComponent', () => {
  let component: AllcardsViewComponent;
  let fixture: ComponentFixture<AllcardsViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllcardsViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllcardsViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
