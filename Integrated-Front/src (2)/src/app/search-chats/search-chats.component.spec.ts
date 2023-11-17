import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchChatsComponent } from './search-chats.component';

describe('SearchChatsComponent', () => {
  let component: SearchChatsComponent;
  let fixture: ComponentFixture<SearchChatsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchChatsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchChatsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
