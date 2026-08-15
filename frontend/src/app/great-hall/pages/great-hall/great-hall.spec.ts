import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GreatHall } from './great-hall';

describe('GreatHall', () => {
  let component: GreatHall;
  let fixture: ComponentFixture<GreatHall>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GreatHall],
    }).compileComponents();

    fixture = TestBed.createComponent(GreatHall);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
