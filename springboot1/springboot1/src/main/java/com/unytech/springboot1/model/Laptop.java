package com.unytech.springboot1.model;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer{


    public void compile() {

        System.out.println(" Laptop Compiling");
    }
}
