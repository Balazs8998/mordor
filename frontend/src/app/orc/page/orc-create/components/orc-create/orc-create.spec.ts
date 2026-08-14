import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrcCreate } from './orc-create';

describe('OrcCreate', () => {
  let component: OrcCreate;
  let fixture: ComponentFixture<OrcCreate>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OrcCreate],
    }).compileComponents();

    fixture = TestBed.createComponent(OrcCreate);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
