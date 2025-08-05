package com.unytech.springboot1.repo;

import com.unytech.springboot1.model.Laptop;
import org.springframework.stereotype.Repository;

@Repository
public class LaptopRepository {
    public void save(Laptop lap){
        System.out.println("Saved In Database");
    }
}
