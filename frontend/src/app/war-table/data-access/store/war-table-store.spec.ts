import { TestBed } from '@angular/core/testing';

import { WarTableStore } from './war-table-store';

describe('WarTableStore', () => {
  let service: WarTableStore;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WarTableStore);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
