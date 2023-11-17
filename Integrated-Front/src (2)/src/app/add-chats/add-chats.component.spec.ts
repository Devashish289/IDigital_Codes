import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddChatsComponent } from './add-chats.component';

describe('AddChatsComponent', () => {
  let component: AddChatsComponent;
  let fixture: ComponentFixture<AddChatsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddChatsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddChatsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
