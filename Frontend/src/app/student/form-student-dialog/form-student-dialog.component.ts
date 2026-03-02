import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {Component, Inject} from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { StudentService } from 'src/services/student/student.service';

@Component({
  selector: 'app-form-student-dialog',
  templateUrl: './form-student-dialog.component.html',
  styleUrls: ['./form-student-dialog.component.css']
})
export class FormStudentDialogComponent {
  form!: FormGroup;

  constructor(
    private studentService: StudentService,
    private dialogRef: MatDialogRef<FormStudentDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any

  ) {}

  ngOnInit(): void {
    this.initForm();

    if (this.data) {
      this.form.patchValue(this.data);
    }
  }

  initForm(): void {
    this.form = new FormGroup({
      firstName: new FormControl(null),
      lastName: new FormControl(null),
      email: new FormControl(null),
      city: new FormControl(null),
      street: new FormControl(null),
    });
  }

  onSub(): void {
    console.log("Submit clicked");
    console.log("Form value:", this.form.value);

    if (this.data) {
      this.studentService.update(this.data.id, this.form.value)
        .subscribe({
          next: () => {
            console.log("Update success");
            this.dialogRef.close(true);
          },
          error: (err) => console.error("Update error:", err)
        });
    } else {
      this.studentService.save(this.form.value)
        .subscribe({
          next: () => {
            console.log("Create success");
            this.dialogRef.close(true);
          },
          error: (err) => console.error("Create error:", err)
        });
    }
  }

  onCancel(): void {
    this.dialogRef.close(false);
  }

}
