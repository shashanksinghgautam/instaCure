import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PatientComponent } from './consultation/patient/patient.component';
import { DoctorDisplayComponent } from './doctor-display/doctor-display.component';
import { HomeComponent } from './home/home.component';
import { LoginComponentComponent } from './login-component/login-component.component';
import { medicineComponent } from './medicine/medicine.component';
import { AddnewComponent } from './medicine/volunteer/addnew/addnew.component';
import { UpdateComponent } from './medicine/volunteer/update/update.component';
import { VolunteerComponent } from './medicine/volunteer/volunteer.component';
import { PatientComponentComponent } from './patient-component/patient-component.component';
import { PatientDisplayComponent } from './patient-display/patient-display.component';
import { RegisterComponentComponent } from './register-component/register-component.component';
import { VolunteerDisplayComponent } from './volunteer-profile/volunteer-display/volunteer-display.component';
import { VolunteerProfileComponent } from './volunteer-profile/volunteer-profile.component';
import { DoctorProfileComponent } from './doctor-profile/doctor-profile.component';
import { DoctorListComponent } from './doctor/doctor-list/doctor-list.component';
import { ListofdoctorsComponent } from './doctor/listofdoctors/listofdoctors.component';
import { EmailNotificationComponent } from './email-notification/email-notification.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { VolNotificationComponent } from './vol-notification/vol-notification.component';

const routes: Routes = [
  { path: '', redirectTo: 'landing-page', pathMatch: 'full' },
  { path: 'home/:role/:id', component: HomeComponent },
  { path: 'login-component', component: LoginComponentComponent },
  { path: 'register-component', component: RegisterComponentComponent },
  { path: 'volunteer-display/:id', component: VolunteerDisplayComponent },
  { path: 'medicine', component: medicineComponent },
  { path: 'medicine-volunteer', component: VolunteerComponent },
  { path: 'add', component: AddnewComponent },
  { path: 'update/:id', component: UpdateComponent },
  { path: 'update-volunteer/:id',component:VolunteerProfileComponent},
  { path: 'consultation/patient', component:PatientComponent },
  { path: 'patient-component/:id', component:PatientComponentComponent},
  { path: 'patient-display/:id', component:PatientDisplayComponent},
  { path: 'doctor-display/:id', component:DoctorDisplayComponent},
  { path: 'doctor-profile/:id', component:DoctorProfileComponent},
  { path: 'landing-page', component:LandingPageComponent},
  { path: 'email-notification', component:EmailNotificationComponent},
  { path: 'doctor-profile', component:DoctorProfileComponent},
  { path: 'update-volunteer/:id', component: VolunteerProfileComponent },
  { path: 'consultation/patient', component: PatientComponent },
  { path: 'DoctorProfileComponent', component: DoctorProfileComponent },
  { path: 'doctor-list', component: DoctorListComponent },
  { path: 'listofdoctors', component: ListofdoctorsComponent },
  { path: 'patient-component/:id', component: PatientComponentComponent },
  { path: 'patient-display/:id', component: PatientDisplayComponent },
  { path: 'doctor-display/:id', component: DoctorDisplayComponent },
  { path: 'doctor-profile/:id', component: DoctorProfileComponent },
  { path: 'doctor-profile', component: DoctorProfileComponent },
  { path: 'landing-page', component: LandingPageComponent },
  { path: 'email-notification', component: EmailNotificationComponent },
  { path: 'update-volunteer/:id', component: VolunteerProfileComponent },
  { path: 'DoctorProfileComponent', component: DoctorProfileComponent },
  { path: 'doctor-list', component: DoctorListComponent },
  { path: 'landing-page', component: LandingPageComponent },
  { path: 'vol-notification', component: VolNotificationComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{useHash:true})],
  exports: [RouterModule],
})
export class AppRoutingModule {}
