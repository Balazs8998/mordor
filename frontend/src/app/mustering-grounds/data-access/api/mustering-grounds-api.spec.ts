import { TestBed } from '@angular/core/testing';

import { MusteringGroundsApi } from './mustering-grounds-api';

describe('MusteringGroundsApi', () => {
  let service: MusteringGroundsApi;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MusteringGroundsApi);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
