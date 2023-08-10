package com.stackroute.medicine.repository;



import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.stackroute.medicine.model.Medicine;
@Repository 
public interface MedicineRepository extends  MongoRepository<Medicine, Integer> {

//	public Medicine update(Medicine medicine);

	

	
//	 	@Query("{name:'?0'}")
//	    Medicine findItemByName(String name);
//	    
//	    @Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
//	    List<Medicine> findAll(String category);
//	    
//	    public long count();
}
