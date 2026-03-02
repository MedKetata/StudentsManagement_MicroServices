import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormAddressDialogComponent } from './form-address-dialog.component';

describe('FormAddressDialogComponent', () => {
  let component: FormAddressDialogComponent;
  let fixture: ComponentFixture<FormAddressDialogComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FormAddressDialogComponent]
    });
    fixture = TestBed.createComponent(FormAddressDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
