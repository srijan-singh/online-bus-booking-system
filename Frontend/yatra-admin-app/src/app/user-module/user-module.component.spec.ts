import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserModuleComponent } from './user-module.component';

describe('UserModuleComponent', () => {
  let component: UserModuleComponent;
  let fixture: ComponentFixture<UserModuleComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UserModuleComponent]
    });
    fixture = TestBed.createComponent(UserModuleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
