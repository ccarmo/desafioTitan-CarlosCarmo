import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FinalizarcarroComponent } from './finalizarcarro.component';

describe('FinalizarcarroComponent', () => {
  let component: FinalizarcarroComponent;
  let fixture: ComponentFixture<FinalizarcarroComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FinalizarcarroComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FinalizarcarroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
