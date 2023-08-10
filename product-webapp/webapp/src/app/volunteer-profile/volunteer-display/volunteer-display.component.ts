import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Volunteer } from '../volunteer';
import { VolunteerService } from '../volunteer.service';
import { User } from 'src/app/user';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-volunteer-display',
  templateUrl: './volunteer-display.component.html',
  styleUrls: ['./volunteer-display.component.css'],
})
export class VolunteerDisplayComponent implements OnInit {
  id = Number(localStorage.getItem('lid'));
  img = 'http://localhost:8086/api/Volunteer/image/' + this.id;
  searchText: string = '';
  Volunteers: any[] = [];
  volunteer = new Volunteer();
  // volunteer:object = new Volunteer()

  constructor(
    private VolunteerService: VolunteerService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData() {
    this.VolunteerService.getVolunteer(this.id).subscribe((data) => {
      this.Volunteers.push(data);
    });
    this.VolunteerService.getimage(this.id).subscribe((data) => {
      this.Volunteers.push(data);
    });
  }
  UpdateProfile(id: number): void {
    this.router.navigate(['update-volunteer', id]);
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
