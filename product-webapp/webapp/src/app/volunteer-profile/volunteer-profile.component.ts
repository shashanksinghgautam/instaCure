import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Event, Router } from '@angular/router';
import { Observable } from 'rxjs';
import Swal from 'sweetalert2';
import { Doctor } from '../doctor-profile/Doctor';
import { Volunteer } from './volunteer';
import { VolunteerService } from './volunteer.service';

@Component({
  selector: 'app-volunteer-profile',
  templateUrl: './volunteer-profile.component.html',
  styleUrls: ['./volunteer-profile.component.css'],
})
export class VolunteerProfileComponent implements OnInit {
  id!: number;
  Volunteer: Volunteer = new Volunteer();
  Volunteers: any[] = [];
  userfile: any = File;

  submitted = false;
  file!: File;

  imageError!: string;
  isImageSaved!: boolean;
  cardImageBase64!: string;

  selectedFile!: File;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private VolunteerService: VolunteerService,
    private http: HttpClient
  ) {}

  ngOnInit() {
    this.Volunteer = new Volunteer();

    this.id = this.route.snapshot.params['id'];

    this.VolunteerService.getVolunteer(this.id).subscribe(
      (data: any) => {
        console.log(data);
        this.Volunteer = data;
      },
      (error: any) => console.log(error)
    );
    this.reloadData();
  }
  reloadData() {
    this.VolunteerService.getVolunteer(this.id).subscribe((data) => {
      this.Volunteers.push(data);
    });
  }
  updateVolunteer() {
    this.VolunteerService.updateVolunteer(this.id, this.Volunteer).subscribe(
      (data: any) => {
        console.log(data);
        this.Volunteer = new Volunteer();
        this.gotoList();
      },
      (error: any) => console.log(error)
    );
  }

  onSubmit() {
    this.submitted = true;
    this.updateVolunteer();
     this.aman();
    this.router.navigate(['volunteer-display', this.id]);
  }

  gotoList() {
    this.router.navigate(['volunteer-display']);
  }
  kaunda(event: any) {
    console.log(event.target.files[0]);
    this.selectedFile = <File>event.target.files[0];
  }
  aman()
  {
    this.VolunteerService.uploadFile(this.id, this.selectedFile);
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
