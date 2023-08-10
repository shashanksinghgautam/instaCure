import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Doctor } from './Doctor';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {
  private baseUrl = "http://localhost:8086/doctor/add";
  private baseUrl1 = "http://localhost:8086/doctor/DoctorProfile";
  private baseUrl2 = "http://localhost:8086/doctor/get";
  private img=  "http://localhost:8086/doctor/Doctor/image"


  constructor(private http: HttpClient) { }

  getDoctors(): Observable<Doctor[]>{
    return this.http.get<Doctor[]>(`${this.baseUrl1}`);
  }
  updateDoctor(id: number, value: any):Observable<any> {
    return this.http.put(`${this.baseUrl1}/${id}`, value);
  }
  getDoctor(id: number) {
    return this.http.get(`${this.baseUrl2}/${id}`);
  }
  getimage(id: number) {
    return this.http.get(`${this.img}/${id}`);
  }
  uploadFile(id: number, file: any): Observable<Object> {
    var formdata = new FormData();
    formdata.append('imgFile', file);
    var requestOptions = {
      method: 'PUT',
      body: formdata,
    };
    var a: any;
    fetch(`${this.img}/${id}`, requestOptions)
      .then((response) => (a = response))
      .then((result) => console.log(result))
      .catch((error) => console.log('error', error));
    return a;
  }

}
