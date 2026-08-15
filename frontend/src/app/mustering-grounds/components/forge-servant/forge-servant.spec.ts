import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ForgeServant } from './forge-servant';

describe('ForgeServant', () => {
  let component: ForgeServant;
  let fixture: ComponentFixture<ForgeServant>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ForgeServant],
    }).compileComponents();

    fixture = TestBed.createComponent(ForgeServant);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
