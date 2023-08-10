import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Volunteer } from './volunteer';

@Injectable({
  providedIn: 'root',
})
export class VolunteerService {
  private baseUrl = 'http://localhost:8086/api/Volunteer';

  private baseUrl1 = 'http://localhost:8086/api/Volunteer/image';

  constructor(private http: HttpClient) {}

  getVolunteers(): Observable<Volunteer[]> {
    return this.http.get<Volunteer[]>(`${this.baseUrl}`);
  }
  updateVolunteer(id: number, value: any) {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }
  getVolunteer(id: number) {
    return this.http.get(`${this.baseUrl}/${id}`);
  }
  getimage(id: number) {
    return this.http.get(`${this.baseUrl1}${id}`);
  }

  uploadFile(id: number, file: any): Observable<Object> {
    var formdata = new FormData();
    formdata.append('imgFile', file);
    var requestOptions = {
      method: 'PUT',
      body: formdata,
    };
    var a: any;
    fetch(`${this.baseUrl1}/${id}`, requestOptions)
      .then((response) => (a = response))
      .then((result) => console.log(result))
      .catch((error) => console.log('error', error));
    return a;
  }
}
