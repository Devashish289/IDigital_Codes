import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewMspComponent } from './view-msp.component';

describe('ViewMspComponent', () => {
  let component: ViewMspComponent;
  let fixture: ComponentFixture<ViewMspComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewMspComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewMspComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
