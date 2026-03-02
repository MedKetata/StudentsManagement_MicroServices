import { MatIconModule } from '@angular/material/icon';
import { MatDividerModule } from '@angular/material/divider';
import { MatInputModule } from '@angular/material/input';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudentComponent } from './student/student/student.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatTableModule } from '@angular/material/table';
import { HttpClientModule } from '@angular/common/http';
import { AddressComponent } from './address/address/address.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FormStudentDialogComponent } from './student/form-student-dialog/form-student-dialog.component';
import { MatDialogModule } from '@angular/material/dialog';
import { FormAddressDialogComponent } from './address/form-address-dialog/form-address-dialog.component';
import { ConfirmDialogComponent } from './confirm-dialog/confirm-dialog.component';
import { FlexLayoutModule } from '@angular/flex-layout';

@NgModule({
  declarations: [
    AppComponent,
    StudentComponent,
    AddressComponent,
    FormStudentDialogComponent,
    FormAddressDialogComponent,
    ConfirmDialogComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatPaginatorModule,
    MatSortModule,
    MatInputModule,
    MatFormFieldModule,
    MatTableModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    MatDividerModule,
    MatDialogModule,
    MatIconModule,
    FlexLayoutModule
   
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
