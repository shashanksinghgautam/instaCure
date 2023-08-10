package com.stackroute.medicine.service;




import com.stackroute.medicine.model.*;

import java.util.List;


public interface MedicineService {

    public List<Medicine> getAll();
//    public Medicine getByName(String name) ;
    public Medicine addNew(Medicine emp) ;
    public Medicine getById(int id);
//	public Medicine updateMedicine(Medicine medicine);
}
