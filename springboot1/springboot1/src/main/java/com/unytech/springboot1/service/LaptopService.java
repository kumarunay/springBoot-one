package com.unytech.springboot1.service;

import com.unytech.springboot1.repo.LaptopRepository;
import com.unytech.springboot1.model.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {
    @Autowired
    private LaptopRepository repo;
    public void addLaptop(Laptop lap) {
        repo.save(lap);
//        System.out.println("laptop Service working");

    }

    public boolean isLapGoodForProg(Laptop lap){
        return true;
    }
}
