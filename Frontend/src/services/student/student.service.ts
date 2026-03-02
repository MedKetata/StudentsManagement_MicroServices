import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from 'src/app/models/student';
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(private httpClient: HttpClient) { }
  getAllStudents(): Observable<Student[]> {
    return this.httpClient.get<Student[]>(`${environment.apiUrl}/student-service/api/student/getAllStudent`)
  }

  save(student: Student): Observable<void> {
    return this.httpClient.post<any>(`${environment.apiUrl}/student-service/api/student/create`, student)
  }

  delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${environment.apiUrl}/student-service/api/student/delete/${id}`);
  }
  getStudentById(idCourant: number): Observable<Student> {
    return this.httpClient.get<Student>(`${environment.apiUrl}/student-service/api/student/getById/${idCourant}`);
  }

  update(id: number, student: any) {
    return this.httpClient.put(
      `${environment.apiUrl}/student-service/api/student/update/${id}`,
      student
    );
  }
}



