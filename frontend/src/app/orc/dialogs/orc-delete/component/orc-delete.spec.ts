import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrcDelete } from './orc-delete';

describe('OrcDelete', () => {
  let component: OrcDelete;
  let fixture: ComponentFixture<OrcDelete>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OrcDelete],
    }).compileComponents();

    fixture = TestBed.createComponent(OrcDelete);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
