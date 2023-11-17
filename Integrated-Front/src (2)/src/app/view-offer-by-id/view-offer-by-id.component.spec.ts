import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewOfferByIdComponent } from './view-offer-by-id.component';

describe('ViewOfferByIdComponent', () => {
  let component: ViewOfferByIdComponent;
  let fixture: ComponentFixture<ViewOfferByIdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewOfferByIdComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewOfferByIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
