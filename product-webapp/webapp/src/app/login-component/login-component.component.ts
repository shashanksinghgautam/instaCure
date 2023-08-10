import {
  Component,
  EventEmitter,
  Injectable,
  Input,
  OnInit,
  Output,
  ViewChild,
} from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { RegistrationService } from '../registration.service';
import { User } from '../user';
import { globalid } from 'src/global-variable';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login-component.component.html',
  styleUrls: ['./login-component.component.css'],
})
export class LoginComponentComponent implements OnInit {
  lid!: any;
  lidstr!: string;
  key: string = 'LID';
  role!: any;
  rolestr!: string;
  user = new User();
  errorMsg = '';
  emailPattern = '^[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,4}$';

    @ViewChild('myform') public formref!: NgForm;
    constructor(private router: Router, private service: RegistrationService) { }

    ngOnInit(): void {}

    loginUser(role: string) {
      this.service.getuserid(this.user).subscribe((data) => {
        this.lid = data;
        this.lidstr = this.lid;
        localStorage.setItem('lid', this.lidstr);
      });

      localStorage.setItem('lid', this.lidstr);
      console.log(localStorage.getItem('lid'));

      this.service.getuserrole(this.user).subscribe((data) => {
        this.role = data;
        this.rolestr = this.role;
      });
      localStorage.setItem('role', role);

      console.log(localStorage.getItem('role'));

      this.service.loginUserFromRemote(this.user).subscribe(
        (data) => {
          console.log('Login Success');
          console.log(role);
          Swal.fire('Login Successfull', 'Welcome to InstaCure!', 'success');
          this.router.navigate(['landing-page']);
        },
        (error) => {
          console.log('FAILED');
          Swal.fire(
            'Login Failed',
            'Please Provide Valid Credentials',
            'error'
          );
        }
      );
    }
    createNew() {
      this.router.navigate(['./register-component']);
    }
  }

