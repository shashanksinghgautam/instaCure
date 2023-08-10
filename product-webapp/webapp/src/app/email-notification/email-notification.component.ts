import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';
import { User } from '../user';
import { EmailBody } from './email-body';
import { EmailService } from './email.service';

@Component({
  selector: 'app-email-notification',
  templateUrl: './email-notification.component.html',
  styleUrls: ['./email-notification.component.css'],
})
export class EmailNotificationComponent implements OnInit {
  list:any[]=[]

  email = new EmailBody();

  constructor(private service: EmailService) {}

  ngOnInit(): void {
    this.service.getVolunteerEmails().subscribe((data) => {
      this.list.push()
     console.log(data);
    });
  }

  sendEmail() {
    console.log(this.email);

    this.service.sendMail(this.email).subscribe((data)=>{
      Swal.fire(
        "Request Submitted Successfully",
        "You will hear from us very soon!",
        "success"
      )
      console.log("Email Sent to Backend");
    },(error)=>{
      Swal.fire(
        "Request Submitted Successfully",
        "You will hear from us very soon!",
        "success"
      ).then(()=>
      window.location.reload)
    } );
    //this.email=new EmailBody();
  }
}
