import { MatTableDataSource } from '@angular/material/table';
import { MatSort } from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';
import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { Student } from 'src/app/models/student';
import { StudentService } from 'src/services/student/student.service';
import { MatDialog } from '@angular/material/dialog';
import { FormStudentDialogComponent } from '../form-student-dialog/form-student-dialog.component';
import { ConfirmDialogComponent } from 'src/app/confirm-dialog/confirm-dialog.component';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import {MatDialogRef} from "@angular/material/dialog"
import { Inject } from '@angular/core';
@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements AfterViewInit, OnInit {

  tabStudent: Student[] = [];
  dataSource = new MatTableDataSource<Student>();

  constructor(
    private studentService: StudentService,
    private dialog: MatDialog,

  ) {}

  ngOnInit(): void {
    this.getStudent();
  }

  getStudent() {
    this.studentService.getAllStudents().subscribe((r) => {

      this.tabStudent = r;
      console.log('Données récupérées :', r);
      this.dataSource = new MatTableDataSource<Student>(this.tabStudent);
      console.log(this.dataSource)
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });
  }

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(FormStudentDialogComponent, {
      width: '500px',
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        console.log('Form submitted successfully!');
        this.getStudent();
      } else {
        console.log('Form canceled.');
      }
    });
  }

  edit(student: Student): void {

    const dialogRef = this.dialog.open(FormStudentDialogComponent, {
      width: '500px',
      data: student   // 👈 on envoie les données au dialog
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.getStudent();
      }
    });
  }

  delete(id: number): void {

    const dialogRef = this.dialog.open
      (ConfirmDialogComponent, {});
    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.studentService.delete(id).subscribe(() => { this.dataSource.data = this.dataSource.data.filter(student => student.id !== id); })
      }
    })
  }




  displayedColumns: string[] = ['lastName', 'firstName', 'email', 'city', 'street', 'action'];
}


