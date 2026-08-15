import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HordeCreate } from './horde-create';

describe('HordeCreate', () => {
  let component: HordeCreate;
  let fixture: ComponentFixture<HordeCreate>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HordeCreate],
    }).compileComponents();

    fixture = TestBed.createComponent(HordeCreate);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
