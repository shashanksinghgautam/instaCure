package com.stackroute.medicine.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.medicine.execption.ResourceNotFoundException;
import com.stackroute.medicine.model.Medicine;
import com.stackroute.medicine.repository.MedicineRepository;
import com.stackroute.medicine.service.*;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("meds/")
public class MedicineController {
	 	@Autowired
	    private MedicineRepository medicineRepository;
	 	
	 	@Autowired
	    private MedicineService MedicineService;

	@GetMapping("welcome")
	public String welcome() {

		return "Hello Mediciness........";
	}
	    
	 	@Autowired
	 	public MedicineController(MedicineService MedicineService) {
	 		super();
	 		this.MedicineService = MedicineService;
	 	}
	 	

	    @GetMapping("medicine")
	    public List < Medicine > getMedicine() {
	    	System.out.println(this.medicineRepository.findAll());
	        return this.medicineRepository.findAll();
	    }
	
	    
	    @GetMapping("medicine/{id}")
		public ResponseEntity<Medicine> getEmployeeById(@PathVariable(value = "id") int id)
				throws ResourceNotFoundException {
	    	Medicine Medicine = medicineRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
			return ResponseEntity.ok().body(Medicine);
		}
	    
	    @PostMapping("medicine")
	    public ResponseEntity<Medicine> addNewHandler(@RequestBody Medicine Medicine) {
//	    	System.out.println(MedicineService.getAll());
			
				return new ResponseEntity<Medicine>(MedicineService.addNew(Medicine), HttpStatus.CREATED);
			

}
//	    @PutMapping("update")
//	    public Medicine updateLender(@RequestBody Medicine Medicine) throws ResourceNotFoundException{
//	        return MedicineService.updateMedicine(Medicine);
//}
	    @PutMapping("medicine/{id}")
		public ResponseEntity<Medicine> updateMedicine(@PathVariable(value = "id") int Id,@Validated @RequestBody Medicine medicineDetails) throws ResourceNotFoundException {
	    	Medicine medicine = medicineRepository.findById(Id)
					.orElseThrow(() -> new ResourceNotFoundException("Medicine not found for this id :: " + Id));

	    	medicine.setQnt(medicineDetails.getQnt());
	    	medicine.setPrice(medicineDetails.getPrice());
			final Medicine updatedEmployee = medicineRepository.save(medicine);
			return ResponseEntity.ok(updatedEmployee);
		}

	@PutMapping("medicine/buy/{id}/{qnt}")
	public ResponseEntity<Medicine> buyMedicine(@PathVariable(value = "id") int Id,@PathVariable(value = "qnt") int qnt) throws ResourceNotFoundException {
		Medicine medicine = medicineRepository.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("Medicine not found for this id :: " + Id));
		System.out.println("working");
		medicine.setQnt(medicine.getQnt()-qnt);

		final Medicine updatedEmployee = medicineRepository.save(medicine);
		return ResponseEntity.ok(updatedEmployee);
	}
	@GetMapping("medicine/buy/{id}")
	public HttpStatus buyMedicinetest(@PathVariable(value = "id") int Id) throws ResourceNotFoundException {
		
		System.out.println("working");
		return HttpStatus.OK;
	}
	
	    @DeleteMapping("medicine/{id}")
		public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") int Id)
				throws ResourceNotFoundException {
	    	Medicine Medicine = medicineRepository.findById(Id)
					.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + Id));

	    	medicineRepository.delete(Medicine);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
		}
	    
	    
	    
}
