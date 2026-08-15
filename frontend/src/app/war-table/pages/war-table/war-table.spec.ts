import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WarTable } from './war-table';

describe('WarTable', () => {
  let component: WarTable;
  let fixture: ComponentFixture<WarTable>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [WarTable],
    }).compileComponents();

    fixture = TestBed.createComponent(WarTable);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
