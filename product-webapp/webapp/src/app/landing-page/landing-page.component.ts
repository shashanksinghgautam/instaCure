import{Component, OnInit}from '@angular/core';
import {Router}from '@angular/router';
import {NavBarComponent}from '../navBar/navBarcomponent';
@Component({
selector: 'app-landing-page',
templateUrl: './landing-page.component.html',
styleUrls: ['./landing-page.component.css'],
})
export class LandingPageComponent implements OnInit {
role:any = localStorage.getItem("role")

constructor(private router: Router) {}

  ngOnInit(): void {}

  goto() {
    console.log(localStorage.getItem('lid'));
    console.log("Role= "+localStorage.getItem('role') );


    if (localStorage.getItem('role') == 'Volunteer') {
      this.router.navigate(['volunteer-display', localStorage.getItem('lid')]);
    }
    if (localStorage.getItem('role') == 'Doctor') {
      this.router.navigate(['doctor-display', localStorage.getItem('lid')]);
    }
    if (localStorage.getItem('role') == 'Patient') {
      this.router.navigate(['patient-display', localStorage.getItem('lid')]);
    }
  }
}
