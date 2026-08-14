import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrcList } from './orc-list';

describe('OrcList', () => {
  let component: OrcList;
  let fixture: ComponentFixture<OrcList>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OrcList],
    }).compileComponents();

    fixture = TestBed.createComponent(OrcList);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
