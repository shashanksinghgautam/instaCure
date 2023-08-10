import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Medicine } from 'src/app/medicine';

import { MedicineService } from 'src/app/medicine.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-volunteer',
  templateUrl: './volunteer.component.html',
  styleUrls: ['./volunteer.component.css']
})
export class VolunteerComponent implements OnInit {
  Medicines!: Observable<Medicine[]>; 
  constructor(private MedicineService: MedicineService,private router: Router) { }

  ngOnInit(): void {
    // this.MedicineService.getMedicines().subscribe((data: Medicine[]) => {
    //   console.log(data);
    //   this.Medicines = data;
    // });
    this.reloadData();
  }
  

  

  

  reloadData() {
    this.Medicines = this.MedicineService.getMedicinesList();
  }

  deleteMedicine(id: number) {
    this.MedicineService.deleteMedicine(id)
      .subscribe(
        (        data: any) => {
          console.log(data);
          this.reloadData();
        },
        (        error: any) => console.log(error));
  }

  

  updateMedicine(id: number){
    this.router.navigate(['update', id]);
  }
 

}
