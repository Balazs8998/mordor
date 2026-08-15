import { TestBed } from '@angular/core/testing';

import { MusteringGroundsStore } from './mustering-grounds-store';

describe('MusteringGroundsStore', () => {
  let service: MusteringGroundsStore;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MusteringGroundsStore);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
