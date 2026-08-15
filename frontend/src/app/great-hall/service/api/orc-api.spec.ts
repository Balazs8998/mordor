import { TestBed } from '@angular/core/testing';

import { OrcApi } from './orc-api';

describe('OrcApi', () => {
  let service: OrcApi;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OrcApi);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
