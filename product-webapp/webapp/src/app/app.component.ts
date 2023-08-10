import { Component, Injectable } from '@angular/core';
import { User } from './user';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { RegistrationService } from './registration.service';
import { LoginComponentComponent } from './login-component/login-component.component';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
@Injectable()
export class AppComponent {
  title="Webapp"



}
