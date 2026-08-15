import { TestBed } from '@angular/core/testing';

import { GreatHallStore } from './great-hall-store';

describe('GreatHallStore', () => {
  let service: GreatHallStore;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GreatHallStore);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
