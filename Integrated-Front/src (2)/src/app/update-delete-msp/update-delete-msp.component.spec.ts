import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateDeleteMspComponent } from './update-delete-msp.component';

describe('UpdateDeleteMspComponent', () => {
  let component: UpdateDeleteMspComponent;
  let fixture: ComponentFixture<UpdateDeleteMspComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateDeleteMspComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateDeleteMspComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
