import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrcReforge } from './orc-reforge';

describe('OrcReforge', () => {
  let component: OrcReforge;
  let fixture: ComponentFixture<OrcReforge>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OrcReforge],
    }).compileComponents();

    fixture = TestBed.createComponent(OrcReforge);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
