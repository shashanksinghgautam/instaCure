import { Component, OnInit } from '@angular/core';
import { Doctor } from 'src/app/doctor-profile/Doctor';
import { DoctorProfileComponent } from 'src/app/doctor-profile/doctor-profile.component';
import { PatientService } from 'src/app/patient.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-doctor-list',
  templateUrl: './doctor-list.component.html',
  styleUrls: ['./doctor-list.component.css'],
})
export class DoctorListComponent implements OnInit {
  y: any;
  p: any;
  msg: String = '';
  doctors: any[]=[]
  doctor: Doctor = new Doctor();
  image: any[] = [];
  constructor(private pservice: PatientService) {}

  ngOnInit(): void {
    var x = this.pservice.getSpecality();

    this.pservice.getDoctors().subscribe((data) => {

      for (let index = 0; index < data.length; index++) {
         data[index].img='http://localhost:8086/doctor/Doctor/image/'+data[index].user.id
        if (x == data[index].speciality) {
          console.log(data[index].user.id);
          // console.log(this.doctors[index].educationQualifiaction);
         // this.image[index]='http://localhost:8086/doctor/Doctor/image/'+data[index].user.id
          this.doctors.push(data[index]);

          console.log("Image addedddd");

          this.msg = 'YOU CAN APPOINT YOUR DOCTOR HERE';
        }
        //this.doctors[index].img='http://localhost:8086/doctor/Doctor/image/'+data[index].user.id
      }
    });
    console.log(this.pservice.getSpecality());
  }
  ONCLICK() {
    let b = document.getElementById('btn');
    b?.setAttribute('class', 'btn btn-success');
    b?.setAttribute('value', 'Appointment Booked');
  }

  clearStorage() {
    Swal.fire(
      'Successfully logged out',
      'Click on Login Button to Login',
      'success'
    ).then(() => {
  localStorage.clear();
    window.location.reload();
});
    localStorage.clear();
  }
}
