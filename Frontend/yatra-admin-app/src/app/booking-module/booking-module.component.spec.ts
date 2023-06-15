import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookingModuleComponent } from './booking-module.component';

describe('BookingModuleComponent', () => {
  let component: BookingModuleComponent;
  let fixture: ComponentFixture<BookingModuleComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BookingModuleComponent]
    });
    fixture = TestBed.createComponent(BookingModuleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
