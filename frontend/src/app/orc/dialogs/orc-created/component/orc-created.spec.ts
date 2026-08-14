import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrcCreated } from './orc-created';

describe('OrcCreated', () => {
  let component: OrcCreated;
  let fixture: ComponentFixture<OrcCreated>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OrcCreated],
    }).compileComponents();

    fixture = TestBed.createComponent(OrcCreated);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
