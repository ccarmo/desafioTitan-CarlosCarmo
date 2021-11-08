import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarcarroComponent } from './editarcarro.component';

describe('EditarcarroComponent', () => {
  let component: EditarcarroComponent;
  let fixture: ComponentFixture<EditarcarroComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditarcarroComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditarcarroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
