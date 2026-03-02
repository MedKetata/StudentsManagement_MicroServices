import {Component, Inject} from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import { AddressService } from 'src/services/address/address.service';

@Component({
  selector: 'app-form-address-dialog',
  templateUrl: './form-address-dialog.component.html',
  styleUrls: ['./form-address-dialog.component.css']
})
export class FormAddressDialogComponent {
   form!: FormGroup;

  constructor(
    private addressService: AddressService,
    private dialogRef: MatDialogRef<FormAddressDialogComponent>,
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
      city: new FormControl(null),
      street: new FormControl(null),
    });
  }

  onSub(): void {

    if (this.data) {
      this.addressService.update(this.data.id, this.form.value)
        .subscribe(() => this.dialogRef.close(true));
    } else {
      this.addressService.save(this.form.value)
        .subscribe(() => this.dialogRef.close(true));
    }
  }

    onCancel(): void {
      this.dialogRef.close(false);
    }

}
