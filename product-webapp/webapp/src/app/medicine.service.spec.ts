import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { MedicineService } from './medicine.service';

describe('MedicineService', () => {
  let service: MedicineService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
    });
    service = TestBed.inject(MedicineService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
