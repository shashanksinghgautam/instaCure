import { Component, OnInit } from '@angular/core';
import { EmailBody } from '../email-notification/email-body';
import { EmailService } from '../email-notification/email.service';

@Component({
  selector: 'app-vol-notification',
  templateUrl: './vol-notification.component.html',
  styleUrls: ['./vol-notification.component.css']
})
export class VolNotificationComponent implements OnInit {

  constructor(private service:EmailService) { }
  emailarray :any[]=[];
  email : EmailBody =new EmailBody();

  ngOnInit(): void {
    this.service.getMails().subscribe(data=>{
      this.emailarray=data
      console.log(this.emailarray);

    })

  }

  deleteMail(id:any){
    console.log(id);

    this.service.deleteMail(id).subscribe(
      (data: any) => {
        console.log(data);


      },
      (error: any) => console.log(error));

      window.location.reload();
  }

}
