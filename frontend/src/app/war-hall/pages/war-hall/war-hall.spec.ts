import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WarHall } from './war-hall';

describe('WarHall', () => {
  let component: WarHall;
  let fixture: ComponentFixture<WarHall>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [WarHall],
    }).compileComponents();

    fixture = TestBed.createComponent(WarHall);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
