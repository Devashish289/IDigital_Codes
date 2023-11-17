import { TestBed } from '@angular/core/testing';

import { FarmingAssistantService } from './farming-assistant.service';

describe('FarmingAssistantService', () => {
  let service: FarmingAssistantService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FarmingAssistantService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
