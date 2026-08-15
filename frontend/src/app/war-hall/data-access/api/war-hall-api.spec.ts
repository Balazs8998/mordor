import { TestBed } from '@angular/core/testing';

import { WarHallApi } from './war-hall-api';

describe('WarHallApi', () => {
  let service: WarHallApi;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WarHallApi);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
