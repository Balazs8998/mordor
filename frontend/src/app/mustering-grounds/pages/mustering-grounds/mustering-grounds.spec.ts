import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MusteringGrounds } from './mustering-grounds';

describe('MusteringGrounds', () => {
  let component: MusteringGrounds;
  let fixture: ComponentFixture<MusteringGrounds>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MusteringGrounds],
    }).compileComponents();

    fixture = TestBed.createComponent(MusteringGrounds);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
