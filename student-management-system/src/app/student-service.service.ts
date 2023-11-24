import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import {HttpClient} from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class StudentServiceService {

  private message = new BehaviorSubject(0);
  currentValue = this.message.asObservable();

  constructor(private http:HttpClient) { }

  getData(){
    let url = "http://localhost:8080/api/v1/student";

    return this.http.get(url);
  }

  deleteStudentData(studentNum: string){
    let url = "http://localhost:8080/api/v1/student" + "/" + studentNum;
    this.http.delete(url)

  }

  addStudent(student: string){
     return this.http.post("http://localhost:8080/api/v1/student", student);

  }

  putStudentEmail(email: string){
    return this.http.put("http://localhost:8080/api/v1/student", email);

  }


}
