import { Component, OnInit } from '@angular/core';
import { MedicineService } from '../medicine.service';
import { Medicine } from '../medicine';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-medicine',
  templateUrl: './medicine.component.html',
  styleUrls: ['./medicine.component.css'],
})
export class medicineComponent implements OnInit {
  i!:number
  name!:string
  p:any
  qnt:Number[]=[]
  searchText: string = '';
  Medicines!: Observable<Medicine[]>;
  Medicine: Medicine = new Medicine();
  role:any = localStorage.getItem("role")
  formValue: any;
  constructor(
    private MedicineService: MedicineService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData() {
    this.Medicines = this.MedicineService.getMedicinesList();
  }

  buyMedicine(id: number,mname:string ) {
    this.name = mname
    this.i=id
    console.log(this.qnt[id]);
    if(this.qnt[id]>=1 && this.qnt[id]<=15){
    this.MedicineService.buyMedicine(id, this.qnt[id]).subscribe(
      (data: any) => {
        console.log(data);
        this.Medicine = new Medicine();

      },

      (error: any) => console.log(error)
    );
    // console.log(this.Medicine.medicinename)
    Swal.fire(
      ' Succesfull Purchase of '+this.qnt[this.i]+' '+ this.name,
      'Thank You!',
      'success'
    ).then(()=> {

      window.location.reload();

    })
  }
  else{
    Swal.fire(
      'Purchase Failed',
      'Max Limit is 15',
      'error'
    ).then(()=> {

     window.location.reload();

    })
  }
  }

  goToEmail(){
     this.router.navigate(['/email-notification']);
  }
}


