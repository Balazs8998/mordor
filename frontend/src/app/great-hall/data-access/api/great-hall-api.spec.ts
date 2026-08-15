import { TestBed } from '@angular/core/testing';

import { GreatHallApi } from './great-hall-api';

describe('GreatHallApi', () => {
  let service: GreatHallApi;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GreatHallApi);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
