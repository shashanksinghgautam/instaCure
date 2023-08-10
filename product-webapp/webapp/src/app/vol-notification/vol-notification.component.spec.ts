import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VolNotificationComponent } from './vol-notification.component';

describe('VolNotificationComponent', () => {
  let component: VolNotificationComponent;
  let fixture: ComponentFixture<VolNotificationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VolNotificationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VolNotificationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
