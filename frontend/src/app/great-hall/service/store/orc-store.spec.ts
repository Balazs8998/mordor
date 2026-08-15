import { TestBed } from '@angular/core/testing';

import { OrcStore } from './orc-store';

describe('OrcStore', () => {
  let service: OrcStore;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OrcStore);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
