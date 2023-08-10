import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Medicine } from 'src/app/medicine';
import { MedicineService } from 'src/app/medicine.service';


@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  id!: number;
  Medicine: Medicine = new Medicine;
  submitted = false;

  constructor(private route: ActivatedRoute,private router: Router,
    private MedicineService: MedicineService) { }

  ngOnInit() {
    this.Medicine = new Medicine();

    this.id = this.route.snapshot.params['id'];
    
    this.MedicineService.getMedicine(this.id)
      .subscribe((data: any) => {
        console.log(data)
        this.Medicine = data;
      }, (error: any) => console.log(error));
  }

  updateMedicine() {
    this.MedicineService.updateMedicine(this.id, this.Medicine)
      .subscribe((data: any) => {
        console.log(data);
        this.Medicine = new Medicine();
        this.gotoList();
      }, (error: any) => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.updateMedicine(); 
    this.router.navigate(['medicine']);   
  }
  
  gotoList() {
    this.router.navigate(['medicine']);
  }

}
