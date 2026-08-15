import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatureRoster } from './creature-roster';

describe('CreatureRoster', () => {
  let component: CreatureRoster;
  let fixture: ComponentFixture<CreatureRoster>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CreatureRoster],
    }).compileComponents();

    fixture = TestBed.createComponent(CreatureRoster);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
