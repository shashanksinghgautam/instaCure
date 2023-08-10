import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { data } from 'jquery';
import Swal from 'sweetalert2';
import { Doctor } from '../doctor-profile/Doctor';
import { DoctorService } from '../doctor-profile/doctor-profile.service';

@Component({
  selector: 'app-doctor-display',
  templateUrl: './doctor-display.component.html',
  styleUrls: ['./doctor-display.component.css'],
})
export class DoctorDisplayComponent implements OnInit {
  id = Number(localStorage.getItem('lid'));
  img = 'http://localhost:8086/doctor/Doctor/image/' + this.id;
  searchText: string = '';
  Doctors: any[] = [];
  Doctor = new Doctor();

  constructor(
    private doctorprofileService: DoctorService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.reloadData();
  }

  UpdateProfile(id: number): void {
    this.router.navigate(['doctor-profile', id]);
  }

  reloadData() {
    this.doctorprofileService
      .getDoctor(this.id)
      .subscribe((data: any): void => {
        this.Doctors.push(data);
      });
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
