import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmailService {

  constructor(private http: HttpClient) { }
  private emailURL = "http://localhost:8086/reg/Volunteer/email";

  getVolunteerEmails() {
    return this.http.get(`${this.emailURL}/`);
  }

  sendMail(email:any){
    return this.http.post("http://localhost:8086/email/send",email)
  }

 getMails():Observable<any>{
    return this.http.get("http://localhost:8086/email/allMails")
  }

  deleteMail(id: any): Observable<any> {
    return this.http.delete("http://localhost:8086/email/deletemail/"+id, { responseType: 'text' });
  }


}
