import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormStudentDialogComponent } from './form-student-dialog.component';

describe('FormStudentDialogComponent', () => {
  let component: FormStudentDialogComponent;
  let fixture: ComponentFixture<FormStudentDialogComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FormStudentDialogComponent]
    });
    fixture = TestBed.createComponent(FormStudentDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
