import { Component } from '@angular/core';
import {StudentServiceService} from './student-service.service'
import {Student} from './student'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'student-management-system';
  showList = false;
  deleteOption= false;
  studentEmailOption = false;
  studentData: any = "";
  studentId: string = "";
  studentEmail: string = "";

  first_name: string = "";
  last_name: string = "";
  enrollment_date: string = "";



  studentList: Student[] = [];
  addStudentOption: boolean = false;

  constructor(private studentService: StudentServiceService){

    

  }
  
  ngOnInit(){
    
  }

  async showAllStudents(){
    this.showList = true;
    this.deleteOption = false;
    this.studentEmailOption = false;
    this.addStudentOption = false
    
    this.studentList = await (await fetch("http://localhost:8080/api/v1/student")).json();
 
  }

  showDeleteOption(){
    this.showList = false;
    this.deleteOption = true;
    this.studentEmailOption = false;
    this.addStudentOption = false;
  }

  showEmailOption(){
    this.showList = false;
    this.deleteOption = false;
    this.studentEmailOption = true;
    this.addStudentOption = false;

  }
  showAddOption(){
    this.showList = false;
    this.deleteOption = false;
    this.studentEmailOption = false;
    this.addStudentOption = true;

  }



  async deleteStudent(){

    let response = await fetch("http://localhost:8080/api/v1/student" + "/" + this.studentId, {method: 'DELETE'});
    console.log(response);
  
  }

  async updateEmail(){

    let putMethod = {method: 'PUT', headers: {'Content-type': 'application/json'}, body: JSON.stringify({'email': this.studentEmail})}

    let response = await fetch("http://localhost:8080/api/v1/student" + "/" + this.studentId, putMethod);


  }

  async addNewStudent(){
    let student: Student = {
    first_name: this.first_name,
    last_name: this.last_name,
    email: this.studentEmail,
    enrollment_date: this.enrollment_date
    }

    let postMethod = {method: 'POST', headers: {'Content-type': 'application/json'}, body: JSON.stringify(student)}

    let response = await fetch("http://localhost:8080/api/v1/student", postMethod);

    console.log(JSON.stringify(student));


  }

  

}
