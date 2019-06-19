import { TestBed } from '@angular/core/testing';

import { AutoServiceService } from './auto-service.service';

describe('AutoServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AutoServiceService = TestBed.get(AutoServiceService);
    expect(service).toBeTruthy();
  });
});
