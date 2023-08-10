import { HttpClientModule } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule} from '@angular/forms';

import { EmailNotificationComponent } from './email-notification.component';
import { EmailService } from './email.service';

describe('EmailNotificationComponent', () => {
  let component: EmailNotificationComponent;
  let fixture: ComponentFixture<EmailNotificationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports:[HttpClientTestingModule,FormsModule,HttpClientModule],
      declarations: [ EmailNotificationComponent ],
      providers:[EmailService]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmailNotificationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
