import { TestBed } from '@angular/core/testing';

import { WarTableApi } from './war-table-api';

describe('WarTableApi', () => {
  let service: WarTableApi;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WarTableApi);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
