import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatureDetails } from './creature-details';

describe('CreatureDetails', () => {
  let component: CreatureDetails;
  let fixture: ComponentFixture<CreatureDetails>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CreatureDetails],
    }).compileComponents();

    fixture = TestBed.createComponent(CreatureDetails);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
