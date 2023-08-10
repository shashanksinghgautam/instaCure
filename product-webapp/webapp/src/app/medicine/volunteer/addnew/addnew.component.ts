
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Medicine } from 'src/app/medicine';

import { MedicineService } from 'src/app/medicine.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
@Component({
  selector: 'app-addnew',
  templateUrl: './addnew.component.html',
  styleUrls: ['./addnew.component.css']
})
export class AddnewComponent implements OnInit {

  Medicines!: Observable<Medicine[]>;
  Medicine: Medicine = new Medicine();
  submitted = false;

  constructor(private MedicineService: MedicineService,
    private router: Router) { }

  ngOnInit() {
    this.reloadData();
  }

  newMedicine(): void {
    this.submitted = false;
    this.Medicine = new Medicine();
  }

  save() {
    this.MedicineService
    .createMedicine(this.Medicine).subscribe((data: any) => {
      console.log(data)
      this.Medicine = new Medicine();

    },
      (    error: any) => console.log(error));

  }

  onSubmit() {
    this.submitted = true;
    this.save();
    this.router.navigate(['medicine']);
  }
  gotoList() {

    this.router.navigate(['medicine']);
  }
  reloadData() {
    this.Medicines = this.MedicineService.getMedicinesList();
  }

  buyMedicine(id: number) {
    let qnt = document.querySelector('input')?.value;
    console.log(qnt)
    this.MedicineService.buyMedicine(id,qnt).subscribe((data: any) => {
      console.log(data)
      this.Medicine = new Medicine();

    },
      (    error: any) => console.log(error));

  }

}
