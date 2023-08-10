package com.stackroute.medicine.service;



import com.stackroute.medicine.repository.*;
import com.stackroute.medicine.*;
import com.stackroute.medicine.model.Medicine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/* Annotate the class with @Service Annotation */
@Service
public class MedicineServiceImpl implements MedicineService {

	MedicineRepository MedicineRepository;

	/*
	 * Constructor based Autowiring should be implemented
	 */
	private MedicineRepository repo;

	@Autowired
	public MedicineServiceImpl(MedicineRepository repo) {
		super();
//		System.out.println(repo);
		this.repo = repo;
	}

	/*
	 * This is method is used to get all the Medicines
	 */
	@Override
	public List<Medicine> getAll() {
//		System.out.println(repo.findAll());
		return (List<Medicine>) repo.findAll();
	}

	/*
	 * This method is used to get a Medicine by id. The method should throw
	 * MedicineNotFoundException, if the Medicine with the given id is not found
	 */
	@Override
	public Medicine getById(int id)  {
//		System.out.println(repo.findAll());
//		System.out.println(repo.findById(id));
		
		Optional<Medicine> Medicine = repo.findById(id);
		if (Medicine.isPresent()) {
			return Medicine.get();
		} else {
			
			System.out.println("not found");
			return null;
		}

	}

	/*
	 * This method is used to save a new Medicine. The method should throw
	 * MedicineAlreadyExistException, if the new Medicine that we are trying save is
	 * already saved
	 */
	@Override
	public Medicine addNew(Medicine emp) {
//		System.out.println(repo.findAll());
//		System.out.println(repo.findById(id));
		Optional<Medicine> Medicine = repo.findById(emp.getMid());
		if (Medicine.isPresent()) {
			System.out.println("Duplicate");
			return null;
		} else {
			return repo.save(emp);
		}

	}
	
//	@Override
//    public Medicine updateMedicine(Medicine Medicine) {
//        return repo.update(Medicine);
//    }
}
