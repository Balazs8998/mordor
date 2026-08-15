import { TestBed } from '@angular/core/testing';

import { WarHallStore } from './war-hall-store';

describe('WarHallStore', () => {
  let service: WarHallStore;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WarHallStore);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
