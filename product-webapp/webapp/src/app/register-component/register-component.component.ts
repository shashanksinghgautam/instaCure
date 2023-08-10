import { Component, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { RegistrationService } from '../registration.service';
import { User } from '../user';

@Component({
  selector: 'app-register',
  templateUrl: './register-component.component.html',
  styleUrls: ['./register-component.component.css'],
})
export class RegisterComponentComponent implements OnInit {
  user = new User();
  flag: any;
  errorMsg = '';
  emailPattern = '^[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,4}$';
  moblength: number = 10;
  mobpattern='^[0-9]{10}$';
  constructor(private router: Router, private service: RegistrationService) {}

  ngOnInit(): void {}
  registerUser() {
    this.service.registerUserFromRemote(this.user).subscribe(
      (data) => {
        console.log('Login Success');

        Swal.fire(
          'Registration Succesfull',
          'Please Click on Login Button to Login',
          'success'
        );
        this.router.navigate(['/login-component']);
      },
      (error) => {
        console.log('FAILED');
        Swal.fire(
          'Registration Failed',
          'Please check all the fields',
          'error'
        );
        // this.errorMsg= "*Email or Mobile Already Exists! Try With Different Email or Mobile"
      }
    );
  }
}
