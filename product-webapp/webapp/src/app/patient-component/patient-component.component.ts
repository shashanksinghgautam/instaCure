import { HttpClient } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Patient } from 'src/PatientProfile';
import Swal from 'sweetalert2';
import { PatientService } from '../patient.service';

@Component({
  selector: 'app-patient-component',
  templateUrl: './patient-component.component.html',
  styleUrls: ['./patient-component.component.css'],
})
export class PatientComponentComponent implements OnInit {
  id!: number;
  Patient: Patient = new Patient();

  Patients:any[]=[]
  userfile:any = File

  submitted = false;

  Checked: any;
  medcheck:any;
  otherSymp:any
  selectedItemsList:any[] = [];
  medcond:any[] = [];
  precon:any[] = [];
  selectedFile!: File;



  // @ViewChild('patform') public formref!: NgForm;
  constructor(private route: ActivatedRoute,private router: Router,
    private PatientService: PatientService, private http: HttpClient) {
    }

    ngOnInit() {


      this.id = this.route.snapshot.params['id'];
      console.log(this.id);

      this.PatientService.getPatient(this.id)
        .subscribe((data: any) => {
          console.log(data)
          this.Patient = data;
        }, (error: any) => console.log(error));
       this.reloadData()
    }


    reloadData() {

      this.PatientService.getPatient(this.id).subscribe(
       data=>{
         this.Patients.push(data);

       }
     );

   }
    updatePatient() {
      console.log(this.Patient);
      this.PatientService.updatePatient(this.id, this.Patient)
        .subscribe((data: any) => {
          console.log(data);
          this.Patient = new Patient();
          this.gotoList();
        }, (error: any) => console.log(error));
    }



    onSubmit() {
      this.submitted = true;
      this.updatePatient();
      this. aman()
      this.router.navigate(['patient-display',this.id]);
    }

    gotoList() {
      this.router.navigate(['patient-display']);
    }
    kaunda(event: any) {
      console.log(event.target.files[0]);
      this.selectedFile = <File>event.target.files[0];
    }
    aman()
    {
      this.PatientService.uploadFile(this.id, this.selectedFile);
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

