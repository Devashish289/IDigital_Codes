import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddMspComponent } from './add-msp.component';

describe('AddMspComponent', () => {
  let component: AddMspComponent;
  let fixture: ComponentFixture<AddMspComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddMspComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddMspComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
